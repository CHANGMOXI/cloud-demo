package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chenzhisheng
 * @date 2023/03/29 20:07
 **/
@Data
@Component
@ConfigurationProperties(prefix = "pattern")// Nacos配置更新 --> 对于绑定到Bean的配置，使用@ConfigurationProperties注解绑定这种方式就会自动热更新，无需配置其他东西
public class PatternProperties {
    private String dateformat;
}