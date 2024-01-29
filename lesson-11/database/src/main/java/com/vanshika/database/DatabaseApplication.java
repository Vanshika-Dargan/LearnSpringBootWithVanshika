package com.vanshika.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;



@SpringBootApplication
@ComponentScan(basePackages = "com.vanshika")
public class DatabaseApplication {



	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

}
