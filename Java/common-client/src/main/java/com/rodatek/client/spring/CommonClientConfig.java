package com.rodatek.client.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.rodatek.common.client", "com.rodatek.client" })
public class CommonClientConfig {

    public CommonClientConfig() {
        super();
    }

}
