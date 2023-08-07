package com.example.ecommercemono2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceMono2Application {



    public static void main(String[] args) {
        SpringApplication.run(ECommerceMono2Application.class, args);

    }

}
/*ApplicationContext apc=SpringApplication.run(DenemeApplication.class, args);
        for(String s: apc.getBeanDefinitionNames()){
            System.out.println(s);
        }*/