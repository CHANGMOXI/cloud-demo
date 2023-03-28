package cn.itcast.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon配置负载均衡规则，自定义负载均衡规则 代替 默认的轮询负载均衡规则
 * 全局配置，调用所有其他服务都遵循这个自定义规则
 * 若想这个自定义规则只针对某个服务，可以在配置文件中进行配置
 *
 * @author CZS
 * @create 2023-03-26 21:50
 **/
@Configuration
public class RibbonConfig {
//    @Bean
//    public IRule rule() {
//        // 随机负载均衡规则
//        return new RandomRule();
//    }
}
