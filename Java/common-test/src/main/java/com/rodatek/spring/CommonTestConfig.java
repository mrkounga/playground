package com.rodatek.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


import com.rodatek.client.spring.CommonClientConfig;
import com.rodatek.common.spring.CommonWebConfig;


@Configuration
@ComponentScan({ "com.rodatek.test.common" })
@Import({ CommonClientConfig.class, CommonWebConfig.class})
public class CommonTestConfig {

    public CommonTestConfig() {
        super();
    }

}