package com.experiment.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
//@EnableWebFlux
public class MsRqueueSpringBootPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRqueueSpringBootPocApplication.class, args);
    }

}
