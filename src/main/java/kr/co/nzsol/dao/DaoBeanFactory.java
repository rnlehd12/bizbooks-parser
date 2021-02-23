package kr.co.nzsol.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@MapperScan(basePackages="kr.co.nzsol.dao.*")
public class DaoBeanFactory {
	
	@Bean(name="primaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public DataSource createDataSourcePrimary() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(destroyMethod = "clearCache")
	public SqlSessionTemplate baseSessionTemplate() {
		try {
			log.debug("========== DB Connection =========");
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		    Resource[] resources = resolver.getResources("classpath*:sql/**/*.xml");

			SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
			sqlSessionFactory.setDataSource(createDataSourcePrimary());
			sqlSessionFactory.setMapperLocations(resources);

			return new SqlSessionTemplate(sqlSessionFactory.getObject());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
