package com.lh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.cache.redis")
public class RedisConfig {

//    //自定义RedisTemplate
//    @Bean
//    public RedisTemplate<Object, Student> student_redis_template(RedisConnectionFactory redisConnectionFactory)
//    {
//        RedisTemplate<Object, Student> template = new RedisTemplate<Object, Student>();
//        template.setConnectionFactory(redisConnectionFactory);
//        //使用JSON格式的序列化,保存
//        Jackson2JsonRedisSerializer<Student> serializer = new Jackson2JsonRedisSerializer<Student>(Student.class);
//        template.setDefaultSerializer(serializer);
//        return template;
//    }

}