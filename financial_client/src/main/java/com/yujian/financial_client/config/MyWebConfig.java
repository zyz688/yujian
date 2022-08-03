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
//web 配置
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    //静态资源释放
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }



    //注册登入检查拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")               //添加拦截路径
                .excludePathPatterns( //放行路径
                        "/",
                        "/login",      //前面两个登入页
                        "/layui/**",   //静态资源
                        "/regist",     //注册页面
                        "/LoginMain",  //登入判断
                        "/addUser",    //注册用户
                        "/favicon.ico", //公司图标
                        "/img/**",      //放行图片
                        "/captcha",     //验证码
                        "/loginOut",     //退出请求
                        "/dist/**"        //自定义插件
                         );


    }

}
