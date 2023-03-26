package cn.itcast.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 创建并注入RestTemplate，用于发起HTTP请求，远程调用服务
 *
 * @author CZS
 * @create 2023-03-26 16:32
 **/
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced// 用于 服务发现 时，RestTemplate发起的请求会被Ribbon拦截(基于服务名称从Eureka获取服务列表)进行负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
