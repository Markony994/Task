package tech.enfint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = "tech.enfint")
public class AppConfig
{
    @Bean
    public Developer factoryDev(Manager manager)
    {
        return new Developer(manager);
    }
}
