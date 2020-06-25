package cn.com.nanfeng.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;

/**
 * @author liutao
 * @Title 认证授权服务器
 * @Description
 * @date 2020-06-20 20:36
 */
@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisConnectionFactory redisConnectionFactory;
    @Resource
    private SecurityConfigProperties properties;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Value("${server.accessTokenTimeOut}")
    private int accessTokenTimeOut;
    @Value("${server.refreshTokenTimeOut}")
    private int refreshTokenTimeOut;


    /**
     * token的存储方式
     * @return
     */
    @Bean
    public TokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * 授权配置（authorization）以及令牌（token的访问时间和令牌服务）
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints){
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        //设置access_token的有效时长，默认是2小时
        tokenServices.setAccessTokenValiditySeconds(accessTokenTimeOut);
        //设置refresh_toke的有效时长，默认是1天
        tokenServices.setRefreshTokenValiditySeconds(refreshTokenTimeOut);
        tokenServices.setReuseRefreshToken(false);
        endpoints.tokenServices(tokenServices);
    }

    /**
     * 配置令牌端点(Token Endpoint)的安全约束，允许表单认证
     * @param oauthServer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer)  {
        oauthServer
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");

    }

    /**
     * 配置客户端详细信息
     * clientId 用来标识客户端的id
     * secret 客户端安全码，如果有的话
     * scope 用来现在客户端的访问范围，如果为空（默认）那么客户端有全部的访问范围
     * authorizedGrantTypes:此客户端使用的授权类型，默认为空
     * authorities:此客户端可以使用的权限
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory()
                .withClient(properties.getClientId())
                .secret(passwordEncoder.encode(properties.getClientSecret()))
                .scopes(properties.getScope())
                //支持授权模式,这里配置了三种
                .authorizedGrantTypes("refresh_token","password","authorization_code","client_credentials","implicit");
    }

}
