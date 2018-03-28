package io.cvaldezchavez.config;

import javax.sql.DataSource;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("io.cvaldezchavez")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	private static final String DATABASE_DRIVER = "db.driver";
	private static final String DATABASE_URL = "db.url";
	private static final String DATABASE_PASSWORD = "db.password";
	private static final String DATABASE_USERNAME = "db.username";
	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
		dataSource.setUrl(env.getProperty(DATABASE_URL));
		dataSource.setUsername(env.getProperty(DATABASE_USERNAME));
		dataSource.setPassword(env.getProperty(DATABASE_PASSWORD));
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean =
				new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
		sessionFactoryBean.setHibernateProperties(hibernateProperites());
		return sessionFactoryBean;
	}
	
	private Properties hibernateProperites() {
		Properties properties = new Properties();
		properties.put(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
		properties.put(HIBERNATE_SHOW_SQL, env.getProperty(HIBERNATE_SHOW_SQL));
		properties.put(HIBERNATE_HBM2DDL, env.getProperty(HIBERNATE_HBM2DDL));
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager =
				new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}
