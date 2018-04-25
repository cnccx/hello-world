package com.ztwl.config;

import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.ztwl.common.interceptor.AccessTokenVerifyInterceptor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Log4j2
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    AccessTokenVerifyInterceptor accessTokenVerifyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(accessTokenVerifyInterceptor)
//                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
