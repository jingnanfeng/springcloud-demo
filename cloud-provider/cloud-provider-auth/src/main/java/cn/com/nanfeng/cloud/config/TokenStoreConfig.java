package cn.com.nanfeng.cloud.config;

import cn.com.nanfeng.cloud.security.SecurityStaticConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-07-15 16:47
 */
@Configuration
public class TokenStoreConfig {

    @Resource
    private RedisConnectionFactory redisConnectionFactory;


    @Bean
    public TokenStore tokenStore(){
        //JWT令牌存储方案
        return new RedisTokenStore(redisConnectionFactory);
    }

}
