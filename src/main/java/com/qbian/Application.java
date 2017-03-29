package com.qbian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Qbian on 2017/3/21.
 */
@Controller
@EnableWebMvc
@SpringBootApplication
@EnableScheduling       // 启动定时任务
@EnableAsync             // 启动异步执行函数
@MapperScan(basePackages = "com.qbian.**.dao") // MyBatis 扫描 dao 接口
public class Application extends SpringBootServletInitializer /*WebMvcConfigurerAdapter*/ {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
