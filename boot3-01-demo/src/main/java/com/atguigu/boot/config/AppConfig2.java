package com.atguigu.boot.config;

import com.atguigu.boot.bean.Cat;
import com.atguigu.boot.bean.Dog;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
@SpringBootConfiguration
public class AppConfig2 {
    @ConditionalOnClass(name="com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01(){
        return new Cat();
    }
    @ConditionalOnMissingClass(value="com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01() {
        return new Dog();
    }

    @ConditionalOnBean(value = Dog.class)
    @Bean
    public User zhangsan(){
        return new User();
    }
    @ConditionalOnMissingBean(value = Dog.class)
    @Bean
    public User lisi() {
        return new User();
    }

}
