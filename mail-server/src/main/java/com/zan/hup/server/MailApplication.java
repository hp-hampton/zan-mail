package com.zan.hup.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hupeng on 2018/12/3
 * @version 1.0
 * @Description
 */
@SpringCloudApplication
@EnableFeignClients
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }
}
