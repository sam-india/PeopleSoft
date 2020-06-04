package org.dev.peoplesoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PeopleSoftApplication {
	public static void main(String[] args) {
		SpringApplication.run(PeopleSoftApplication.class, args);
	}
	
/*
	  @Bean
	  public EntityManagerFactory getEntityManagerFactory() 
	  {
		  LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		  emfb.setDataSource(getDataSource()); 
		  emfb.afterPropertiesSet(); 
		  return emfb.getObject(); 
	  }
	 
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/peoplesoft?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); 
		ds.setUsername("devuser");
		ds.setPassword("pass");
		return ds;
	}
*/	
}