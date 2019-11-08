package com.wy.springboot.config;

import com.wy.springboot.component.LoginHandlerInterceptor;
import com.wy.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
    }

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/wy").setViewName("success");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/emps/list").setViewName("list");
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index").setViewName("index");
    }


    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //静态文件
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//静态文件
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
}
