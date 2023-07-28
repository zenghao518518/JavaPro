package com.atguigu.boot;

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //这是一个SpringBoot应用
public class MainApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MainApplication.class,args);

        //java10： 局部变量类型的自动推断
        var ioc = SpringApplication.run(MainApplication.class, args);

        //1、获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        //2、挨个遍历：
        // dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
        // SpringBoot把以前配置的核心组件现在都给我们自动配置好了。
//        for (String name : names) {
//            System.out.println(name);
//        }

        String[] forType = ioc.getBeanNamesForType(User.class);
        for (String s : forType) {
            System.out.println(s);
        }
        Object user1 = ioc.getBean("userZh");
        Object user2 = ioc.getBean("userZh");
        System.out.println(user1 == user2);

        String[] forType1 = ioc.getBeanNamesForType(FastsqlException.class);
        for (String s : forType1) {
            System.out.println(s);
        }

        //@ConditionalOnClass (org.springframework.boot.autoconfigure.condition)
        //@ConditionalOnMissingClass (org.springframework.boot.autoconfigure.condition)

        //@ConditionalOnBean (org.springframework.boot.autoconfigure.condition)
        //@ConditionalOnMissingBean (org.springframework.boot.autoconfigure.condition)

        for (String s : ioc.getBeanNamesForType(Cat.class)) {
            System.out.println("cat: " + s);
        }
        for (String s : ioc.getBeanNamesForType(Dog.class)) {
            System.out.println("dog: " + s);
        }
        for (String s : ioc.getBeanNamesForType(User.class)) {
            System.out.println("user: " + s);
        }
        //属性绑定
        //@ConfigurationProperties(prefix = "pig")

        Pig pig = ioc.getBean(Pig.class);
        System.out.println("pig: " + pig.getName());

        for (String s : ioc.getBeanNamesForType(Pig.class)) {
            System.out.println("Pig: " + s);
        }
        //@EnableConfigurationProperties组合使用
        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println("sheep: " + sheep.getName());

    }
}