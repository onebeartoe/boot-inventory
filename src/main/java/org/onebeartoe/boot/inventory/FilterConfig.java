package org.onebeartoe.boot.inventory;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

/**
 * The filtering configuration is from this example:
 *
 *      https://www.baeldung.com/spring-boot-add-filter
 * 
 *      https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-basic-customization
 */
@Configuration
public class FilterConfig 
{
    // uncomment this and comment the @Component in the filter class definition to register only for a url pattern
    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() 
    {
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestResponseLoggingFilter());

        registrationBean.addUrlPatterns("/api/inventory/*");

        return registrationBean;
    }
}
