package com.cnscud.cavedemo.fundmain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main Application.
 *
 * @author Felix Zhang 2021-08-02 16:02
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.cnscud.cavedemo.fundmain.dao"})
public class FundMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundMainApplication.class, args);
    }
}
