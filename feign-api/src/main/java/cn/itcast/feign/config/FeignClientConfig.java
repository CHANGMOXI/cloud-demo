package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 自定义Feign配置，类 不加注解，所以让自定义配置生效的方式有两种:
 * ①全局生效：把Feign配置类放在启动类的@EnableFeignClients注解的defaultConfiguration属性 {@link cn.itcast.order.OrderApplication}
 * ②局部生效：把Feign配置类放在其他服务的FeignClient接口的@FeignClient注解的configuration属性 {@link cn.itcast.order.clients.UserClient}
 *
 * @author chenzhisheng
 * @date 2023/03/31 10:48
 **/
public class FeignClientConfig {
    /**
     * 自定义Feign日志级别
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}