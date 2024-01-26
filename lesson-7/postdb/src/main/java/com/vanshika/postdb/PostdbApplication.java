package com.vanshika.postdb;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Log
@SpringBootApplication
public class PostdbApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public PostdbApplication(DataSource dataSource){
		this.dataSource=dataSource;
	}
	public static void main(String[] args) {
		SpringApplication.run(PostdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(dataSource.toString());
		final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.execute("select 1");
	}
}
