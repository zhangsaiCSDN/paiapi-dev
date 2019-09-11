package com.woniuxy.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.woniuxy"})
@EnableTransactionManagement  // 启用声明式事务
@MapperScan("com.woniuxy.dao")
public class PaipaiApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaipaiApplication.class, args);
	}
}

