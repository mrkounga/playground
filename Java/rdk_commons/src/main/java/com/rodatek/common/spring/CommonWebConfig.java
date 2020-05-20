package com.rodatek.common.spring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.rodatek.common.web" })
public class CommonWebConfig {

    public CommonWebConfig() {
        super();
    }

}