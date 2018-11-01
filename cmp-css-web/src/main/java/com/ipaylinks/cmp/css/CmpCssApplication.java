package com.ipaylinks.cmp.css;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ipaylinks.cmp.css.dal.mapper")
@SpringBootApplication
public class CmpCssApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmpCssApplication.class, args);
	}
}
