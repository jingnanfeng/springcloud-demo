package cn.com.nanfeng.cloud.config;

import cn.com.nanfeng.cloud.handler.CustomAuthExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @author liutao
 * @Title 资源服务器
 * @Description
 * @date 2020-06-20 22:55
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

    @Resource
    private CustomAuthExceptionHandler customAuthExceptionHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resource){
        resource.stateless(false)
                .accessDeniedHandler(customAuthExceptionHandler)
                .authenticationEntryPoint(customAuthExceptionHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                .and()
                //授权配置
                .authorizeRequests()
                //下面的路径放行
                .antMatchers("/oauth/token").permitAll()
                //OPTIONS请求不需要鉴权
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                //所有的请求都需要认证
                .anyRequest()
                .authenticated()
            .and()
                //允许跨站请求防护
                .headers().frameOptions().disable()
            .and()
                .cors();
    }

}
