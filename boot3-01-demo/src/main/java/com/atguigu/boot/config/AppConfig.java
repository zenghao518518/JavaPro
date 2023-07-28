package com.atguigu.boot.config;

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.Sheep;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration//这是一个配置类，替代以前的配置文件 配置类本身也是容器中的组件

//    FastsqlException导入第一种方法
@Import(FastsqlException.class)
//@SpringBootConfiguration
//*1、开启Sheep组件的属性绑定
//*2、默认会把这个组件自己放到容器中
@EnableConfigurationProperties(Sheep.class)//导入第三方的组件
//场景：SpringBoot默认只扫描自己主程序所在的包。
// 如果导入第三方包，即使组件上标注了 @Component、@ConfigurationProperties 注解，也没用。
// 因为组件都扫描不进来，此时使用这个注解就可以快速进行属性绑定并把组件注册进容器
public class AppConfig {
    //单例，多例
    @Scope("prototype")//给容器中放指定类型的组件,组件的名字默认是全类名

    @Bean("userZh")//替代以前的Bean标签 组件在容器中的名字是方法名
    public User user() {
        var user = new User();
        user.setId(1L);
        user.setName("张三");
        return user;
    }
    //pig第二种方法
    @ConfigurationProperties(prefix = "pig")
    @Bean("pig1")
    public Pig pig1(){
        return new Pig();//我们自己new新pig
    }


//    FastsqlException导入第二种方法
//    @Bean
//    public FastsqlException fastsqlException(){
//        return new FastsqlException();
//    }




}
