package com.bych;

import com.bych.util.FrameSpringBeanUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {"com.bych"})
@EnableScheduling
public class BootsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootsApplication.class, args);
    }

    /**
     * websocket可能会有空指针异常，所以需要获取上下文
     * @return
     */
    @Bean
    public FrameSpringBeanUtil frameSpringBeanUtil(){
        return new FrameSpringBeanUtil();
    }
}
