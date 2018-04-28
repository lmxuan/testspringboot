package com.lmx.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * Springboot 的项目
 * @author Administrator
 *
 */
@Controller
@SpringBootApplication
@EnableScheduling
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@Configuration
//@ComponentScan(basePackages={"com.lmx"})
public class HelloApplication extends SpringBootServletInitializer {
	
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(HelloApplication.class);
//	}
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello(){
		System.out.println("hello 李明轩");
		return "hello ";
	}
	/**
	 * 自定义消息转化器
	 * @return
	 */
//	@Bean
//	public StringHttpMessageConverter stringHttpMessageConverter(){
//		System.out.println("通过bean来实现消息转化器");
//		return new StringHttpMessageConverter(Charset.forName("UTF-8") );
//	}
	
	/**
	 * 
	 * @param args
	 */
	@Bean
	public HttpMessageConverters httpMessageConverters(){
		FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		messageConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = messageConverter;
		return new HttpMessageConverters(converter);
	}
	
	public static void main(String[] args){
		SpringApplication application = new SpringApplication(HelloApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
