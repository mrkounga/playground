package com.rodatek.common.web.spring.config;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	  @Override
	    public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
	        final Optional<HttpMessageConverter<?>> converterFound = converters.stream().filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();
	        if (converterFound.isPresent()) {
	            final AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) converterFound.get();
	            converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	            converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	        }
	        final Optional<HttpMessageConverter<?>> xmlConverterFound = converters.stream().filter(c -> c instanceof MappingJackson2XmlHttpMessageConverter).findFirst();
	        if (xmlConverterFound.isPresent()) {
	            final MappingJackson2XmlHttpMessageConverter converter = (MappingJackson2XmlHttpMessageConverter) xmlConverterFound.get();
	            converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	            converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	        }
	    }
	  
	 
	  @Bean
	    public javax.validation.Validator localValidatorFactoryBean() {
	        return new LocalValidatorFactoryBean();
	    }
	  
	  
	  @Bean
	  public ModelMapper modelMapper() {
		  return new ModelMapper();
	  }

}
