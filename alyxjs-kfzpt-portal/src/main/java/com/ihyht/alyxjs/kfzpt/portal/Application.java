package com.ihyht.alyxjs.kfzpt.portal;

import com.ihyht.alyxjs.kfzpt.service.portal.PortalServiceConfig;
import com.ihyht.alyxjs.nbjcpt.component.auth2.Oauth2Config;
import com.ihyht.alyxjs.nbjcpt.component.dao.mybatis.DaoMybatisConfig;
import com.ihyht.alyxjs.nbjcpt.component.swagger.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
@Import({
        SwaggerConfig.class
        ,Oauth2Config.class
        ,PortalServiceConfig.class
        ,DaoMybatisConfig.class
//        , ApplicationServiceConfig.class
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
