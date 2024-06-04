package com.SpringCore.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.SpringCore.annotations")
public class AppConfig {
//	before adding @componentScan and adding @Component annotations 
//	@Bean
//	public Samsung getPhone() {
//		return new Samsung();
//	}
//	@Bean 
//	public MobileProcessor getProcessor() {
//		return new Snapdragon();
//	}
}
