package com.heu.fuel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication //开启服务启动类
@EnableDiscoveryClient  //发现服务注册
public class BaseServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(BaseServiceApplication.class,args);
    }
}
