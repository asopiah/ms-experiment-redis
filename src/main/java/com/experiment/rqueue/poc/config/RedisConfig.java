package com.experiment.rqueue.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @author asopia
 */
@Configuration
@EnableRedisRepositories
public class RedisConfig {
    //Creating Connection with Redis
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(){
       StringRedisTemplate empTemplate = new StringRedisTemplate();
        empTemplate.setConnectionFactory(redisConnectionFactory());
        return empTemplate;
    }



    /*@Bean
    public RedisTemplate<String, String> redisTemplate(){
        RedisTemplate<String, String> empTemplate = new RedisTemplate<>();
        empTemplate.setConnectionFactory(redisConnectionFactory());
        return empTemplate;
    }*/
}
