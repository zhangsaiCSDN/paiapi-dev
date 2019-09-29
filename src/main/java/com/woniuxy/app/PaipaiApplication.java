package com.woniuxy.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.woniuxy"})
@EnableTransactionManagement  // 启用声明式事务
@MapperScan("com.woniuxy.dao")
@ServletComponentScan // 告诉springboot，去扫描servlet组件
public class PaipaiApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaipaiApplication.class, args);
	}
}
