package com.ztwl;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.ztwl.config.MyApplicationReadyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Administrator
 */
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class,
//        JpaRepositoriesAutoConfiguration.class, DataSourceConfig.class})
@SpringBootApplication
@EnableDubboConfiguration
@ComponentScan(basePackages = "com.ztwl")
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApplication.class);
        app.addListeners(new MyApplicationReadyEvent());
        app.run(args);
    }
}
