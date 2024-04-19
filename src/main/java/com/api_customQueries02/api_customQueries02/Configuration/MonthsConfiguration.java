package com.api_customQueries02.api_customQueries02.Configuration;


import com.api_customQueries02.api_customQueries02.Interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MonthsConfiguration implements WebMvcConfigurer {

    public MonthsConfiguration(MonthInterceptor monthInterceptor) {
        this.monthInterceptor = monthInterceptor;
    }

    @Autowired
    private MonthInterceptor monthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor).addPathPatterns("/months");
    }
}