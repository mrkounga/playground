package com.rodatek.common.persistence.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistenceJpa-${spring.profiles.active}.properties" })
public class PersistenceJpaConfig {

}
