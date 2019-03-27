package com.tjstats.bracket.madness.dao;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class BracketDAOConfig {
	
	@Value("${db.driver}")
	private String dbDriver;
	
	@Value("${db.url}")
	private String dbUrl;
	
 	@Bean
    public Jdbi createJdbi(DataSource dataSource) {
        return Jdbi.create(dataSource);
    }

    @Bean
    public BracketDAO bracketDAO(Jdbi jdbi) {
    	jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi.onDemand(BracketDAO.class);
    }
    
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dbDriver);
        dataSourceBuilder.url(dbUrl);
        return dataSourceBuilder.build();   
    }
}
