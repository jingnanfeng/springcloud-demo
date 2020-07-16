package cn.com.nanfeng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-20 18:49
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CloudProviderAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderAuthApplication.class,args);
    }

}
