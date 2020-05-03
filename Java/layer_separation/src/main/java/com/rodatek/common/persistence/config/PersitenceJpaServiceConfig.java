package com.rodatek.common.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
//@ComponentScan(useDefaultFilters = false, includeFilters = @ComponentScan.Filter
//(type = FilterType.REGEX, pattern = ".[persistence]"))
@ComponentScan("com.rodatek.example.repository")
public class PersitenceJpaServiceConfig {
	
	
}
	

