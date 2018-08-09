package com.bigdata.datamanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.bigdata.datamanager.mapper"})
public class DatamanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatamanagerApplication.class, args);
	}
}
