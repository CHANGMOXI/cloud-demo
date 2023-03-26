package cn.itcast.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 搭建Eureka服务:
 * 1、导入 spring-cloud-starter-netflix-eureka-server 服务端依赖
 * 2、启动类 添加 @EnableEurekaServer注解，开启Eureka的自动装配
 * 3、配置文件编写Eureka配置，比如Eureka服务端口、服务名称、服务地址等
 * <p>
 * Eureka客户端服务注册:
 * 1、导入 spring-cloud-starter-netflix-eureka-client 客户端依赖
 * 2、配置文件编写Eureka配置，即 该客户端服务的名称、Eureka服务端地址
 *
 * Eureka服务发现和拉取:
 * 原本是硬编码服务地址，每次更改地址就要改代码，并且对于多实例的服务，不能硬编码成某一个实例的地址
 * 因此 服务发现和拉取拉取 就是 基于服务名称获取服务列表，然后再对服务列表做负载均衡
 * 1、在其中一个服务(order-service)中，修改访问的另一个服务(user-service)的url地址，用 服务名称 代替 IP和端口号
 * 2、在该服务(order-service)的 RestTemplate 添加 负载均衡注解 @LoadBalanced
 *
 * @author CZS
 * @create 2023-03-26 17:23
 **/
@SpringBootApplication
@EnableEurekaServer// 开启Eureka的自动装配
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
