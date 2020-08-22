package com.jiafly.blueberry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuyi
 */
@SpringBootApplication
@MapperScan("com.jiafly.blueberry.domain.repository")
public class BlueberryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlueberryApplication.class, args);
    }


}
