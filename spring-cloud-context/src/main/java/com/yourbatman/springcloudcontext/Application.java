package com.yourbatman.springcloudcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext bootContext = SpringApplication.run(Application.class, args);
        System.out.println("boot容器类型" + bootContext.getClass());
        System.out.println("boot容器Bean定义总数：" + bootContext.getBeanFactory().getBeanDefinitionCount());
        System.out.println("boot容器Bean实例总数：" + bootContext.getBeanFactory().getSingletonCount());


        // 寻找出BootstrapMarkerConfiguration这个Bean
        for (String beanDefinitionName : bootContext.getBeanFactory().getSingletonNames()) {
            // if(beanDefinitionName.contains("bootstrapMarkerConfiguration")){
                System.out.println(beanDefinitionName);
            // }
        }

        ConfigurableApplicationContext cloudContext = (ConfigurableApplicationContext) bootContext.getParent();
        System.out.println("cloud容器类型" + cloudContext.getClass());
        System.out.println("cloud容器Bean定义总数：" + cloudContext.getBeanFactory().getBeanDefinitionCount());
        System.out.println("cloud容器Bean实例总数：" + cloudContext.getBeanFactory().getSingletonCount());
    }
}
