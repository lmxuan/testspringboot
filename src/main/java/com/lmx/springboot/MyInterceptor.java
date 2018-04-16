package com.lmx.springboot;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@SpringBootConfiguration
public class MyInterceptor extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				System.out.println("pre自定义拦截器............");
				return true;
			}

			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				System.out.println("post自定义拦截器............");
			}

			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
					Exception ex) throws Exception {
			}
		};
		registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
	}

//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		System.out.println("重写方法定义消息转化器");
//		converters.add(new StringHttpMessageConverter(Charset.forName("ISO-8859-1")));
//	}
	
}
