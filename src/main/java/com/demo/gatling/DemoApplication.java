package com.demo.gatling;

import com.demo.gatling.unicorns.mappers.Unicorn;
import com.demo.gatling.unicorns.mappers.UnicornMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public Converter<String, Unicorn> unicornConverter(UnicornMapper unicornMapper) {
		return new Converter<String, Unicorn>() {
			@Override
			public Unicorn convert(String id) {
				return unicornMapper.findOneById(Long.valueOf(id));
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
