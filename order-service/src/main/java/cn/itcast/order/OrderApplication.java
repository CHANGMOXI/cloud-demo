package cn.itcast.order;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.config.FeignClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
// Feign最佳实践：抽取
// 定义的FeignClient不在启动类扫描包范围时，指定FeignClient的两种方式:
// ①通过basePackages属性指定FeignClient所在包("cn.itcast.feign.clients")，包下所有FeignClient都会扫描到
// ②通过clients属性指定具体的FeignClient，单个或多个(写成{xxx.class, yyy.class})
@EnableFeignClients(clients = UserClient.class, defaultConfiguration = FeignClientConfig.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}