/*
package cn.com.nanfeng.cloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

*/
/**
 * @author liutao
 * @Title 安全配置
 * @Description @EnableWebSecurity 启用web安全
 * @date 2020-07-07 22:31
 *//*

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        //金庸csrf
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/oauth/**").permitAll()
            .anyRequest().authenticated();
    }
}
*/
