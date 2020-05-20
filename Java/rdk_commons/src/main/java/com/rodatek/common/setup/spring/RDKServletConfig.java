/**
 * 
 */
package com.rodatek.common.setup.spring;

/**
 * @author koungam
 *
 */
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.rodatek.common.security.web.SimpleCorsFilter;



//@Configuration
public class RDKServletConfig {

    public RDKServletConfig() {
        super();
    }

    // beans

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        final ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/makraybakery_deployed/api/v1/*");

        final Map<String, String> params = new HashMap<>();
        params.put("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        params.put("contextConfigLocation", "org.spring.sec2.spring");
        params.put("dispatchOptionsRequest", "true");
        registration.setInitParameters(params);

        registration.setLoadOnStartup(1);
        return registration;
    }

    //@Bean
    //public SimpleCorsFilter simpleCorsFilter() {
    //    return new SimpleCorsFilter();
   // }

}
