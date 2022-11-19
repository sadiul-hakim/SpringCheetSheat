package com.hakim.springJDBC;

import com.hakim.springJDBC.dao.student.StudentRepository;
import com.hakim.springJDBC.dao.student.StudentRepositoryImp;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Hakim
 */
@Configuration
public class Config {
    
    @Bean("dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/learn");
        dataSource.setUsername("Hakim");
        dataSource.setPassword("hakim@123");
        
        return dataSource;
    }
    
    @Bean("jt")
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }
    
    @Bean("repository")
    public StudentRepository getStudentRepository(){
        return new StudentRepositoryImp(getJdbcTemplate());
    }
}
