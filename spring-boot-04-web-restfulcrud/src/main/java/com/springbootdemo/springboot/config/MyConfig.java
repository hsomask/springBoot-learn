package com.springbootdemo.springboot.config;


import com.springbootdemo.springboot.component.LoginHandlerInterceptor;
import com.springbootdemo.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer()
    {
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/static/**","/webjars/**","/","/user/login");
            }
            //静态文件
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //静态文件
                registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
            //webjar文件
                registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
            }
        };

        return  webMvcConfigurer;

    }
    @Bean
    public LocaleResolver localeResolver()
    {
        return new MyLocaleResolver();
    }
}
