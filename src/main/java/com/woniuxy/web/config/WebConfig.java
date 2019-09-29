package com.woniuxy.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 当前页，就是springBoo环境下的配置类，该类的功能
 * 1.配置CORS
 * 2.配置拦截器
 * 3.配置HttpMessageConveter
 * 4.配置Converter
 */

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 参数registry是SpringBoot框架传入的，我们可以直接调用
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:9999")
			.allowedMethods("POST","GET","PUT","DELETE", "OPTIONS")
			.allowCredentials(true);  // 允许客户端ajax请求携带cookie
	}
	
}
