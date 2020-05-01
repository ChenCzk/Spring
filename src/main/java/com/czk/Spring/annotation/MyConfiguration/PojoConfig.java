package com.czk.Spring.annotation.MyConfiguration;

import com.czk.Spring.annotation.Aspect.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@ComponentScan(basePackages = {"com.czk.Spring.annotation"}) //扫描该包的POJO
@PropertySource(value = {"classpath:asd.properties"})
@EnableAspectJAutoProxy  //启动切面自动代理
public class PojoConfig {
    /*
    * 使用${}获取Properties文件
    * */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    /*
    * 注册切面RoleAscept
    * */
    @Bean
    public RoleAscept getRoleAscept(){
        return new RoleAscept();
    }

    /*
    * 注册切面
    * */
    @Bean
    public asdAsceprt getasdAscept(){
        return new asdAsceprt();
    }
}
