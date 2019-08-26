package com.chetwhy.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**

/**
 *
 * @author : Chet
 * @description : SpringBootAdmin启动类
 * @date : 2019/8/26
 */
@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class BootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAdminApplication.class, args);
    }
}
