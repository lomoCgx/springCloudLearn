package com.example.demo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mengyun.tcctransaction.spring.repository.SpringJdbcTransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TccMysqlConfig {

	/**
	 * 初始化数据源
	 * @return
	 */
	@Bean
	public BasicDataSource initDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("cgx123");
		return dataSource;
	}
	
	
	
	/**
	 * 初始化事物
	 * @return
	 */
	@Bean
	public SpringJdbcTransactionRepository initTransactionRepository(BasicDataSource dataSource) {

		SpringJdbcTransactionRepository springJdbcTransactionRepository = new SpringJdbcTransactionRepository();
		springJdbcTransactionRepository.setDataSource(dataSource);
		return springJdbcTransactionRepository;
	}
	
/*	<bean id="transactionRepository"
		      class="org.mengyun.tcctransaction.spring.repository.SpringJdbcTransactionRepository">
		    <property name="dataSource" ref="dataSource"/>
		</bean>

		<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
		      destroy-method="close">
		    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
		    <property name="url" value="jdbc:mysql://127.0.0.1:3306/test"/>
		    <property name="username" value="root"/>
		    <property name="password" value=""/>
		</bean>*/
}
