package com.cnscud.cavedemo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Application.
 *
 * @author Felix Zhang 2021-08-02 19:47
 * @version 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CaveDemoGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CaveDemoGatewayApplication.class, args);
    }
}
