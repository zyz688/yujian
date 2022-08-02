package com.yujian.financial_client.config;

import com.yujian.financial_client.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ze
 * @create 2022-06-26-18:26
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

//    //静态资源释放
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//    }



    //注册登入检查拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/**")
               .excludePathPatterns("/","/login","/layui/**","/main","addUser");//放行路径
    }






}
