package tech.enfint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "tech.enfint")
public class AppConfig
{
    @Bean
    public static Developer factoryDev(Manager manager)
    {
        return new Developer(manager);
    }
}
