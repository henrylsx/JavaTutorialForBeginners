package com.henrylsx.tutorial_11.spring;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = { "com.henrylsx.tutorial_11.spring" })
public class SpringCoreExample {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(SpringCoreExample.class);
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println("Spring bean : " + beanName);
		}

		DatabaseDateService dateService = context.getBean(DatabaseDateService.class);
		System.out.println("Calling spring bean dateService: "+ dateService.getDatabaseDate());
	}

}

@Component
class DatabaseService {
	String jdbcUrl = "jdbc:h2:file:C:/Users/henry/workspace/JavaTutorialForBeginners/data/localdb";
	String driverName = "org.h2.Driver";
	private ComboPooledDataSource cpds = new ComboPooledDataSource();

	public DatabaseService() {
		try {
			cpds.setDriverClass(driverName); // loads the jdbc driver
			cpds.setJdbcUrl(jdbcUrl);
			cpds.setUser("root");
			cpds.setPassword("root");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public String getDatabaseDate() {
		try {
			Statement stmt = cpds.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT SYSDATE from DUAL;");
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

@Component
class DatabaseDateService {
	@Autowired // auto inject the db service into this class
	DatabaseService dbService;

	public String getDatabaseDate() {
		return dbService.getDatabaseDate();
	}
}