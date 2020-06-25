package cn.com.nanfeng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-20 18:49
 */
//@EnableDiscoveryClient
//@EnableFeignClients
@SpringBootApplication
public class CloudProviderAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderAuthApplication.class,args);
    }

}
