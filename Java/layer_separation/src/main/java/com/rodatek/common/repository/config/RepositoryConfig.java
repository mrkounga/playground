package com.rodatek.common.repository.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rodatek.common.repository.jpa.BaseJpaRepository;

//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages ="com.rodatek")
//@ComponentScan(useDefaultFilters = true, includeFilters = @ComponentScan.Filter
//(type = FilterType.REGEX, pattern = ".[repository]"))
//@EnableJpaRepositories(basePackages = "com.rodatek", repositoryBaseClass = BaseJpaRepository.class)
public class RepositoryConfig {

}
