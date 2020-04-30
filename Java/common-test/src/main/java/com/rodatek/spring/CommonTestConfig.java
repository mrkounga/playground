package com.rodatek.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.rodatek.client.spring.CommonClientConfig;

//CommonWebConfig excluded from the import -- to be relook into 

@Configuration
@ComponentScan({ "com.rodatek.test.common" })
@Import({ CommonClientConfig.class })
public class CommonTestConfig {

    public CommonTestConfig() {
        super();
    }

}