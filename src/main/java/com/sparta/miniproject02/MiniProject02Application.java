package com.sparta.miniproject02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@EnableScheduling
@EnableJpaAuditing // 생성 시간/수정 시간 자동 업데이트
@SpringBootApplication
public class MiniProject02Application {

    public static void main(String[] args) {
        SpringApplication.run(MiniProject02Application.class, args);
    }
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}