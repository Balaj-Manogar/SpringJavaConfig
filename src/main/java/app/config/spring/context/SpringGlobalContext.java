package app.config.spring.context;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * Created by Balaji on 01/11/16.
 */

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.baali",
                excludeFilters={@ComponentScan.Filter(org.springframework.stereotype.Controller.class)})
public class SpringGlobalContext
{

    // Data source variables
    private @Value("${jdbc.driverClassName}") String driverName;
    private @Value("${jdbc.url}") String url;
    private @Value("${jdbc.username}") String username;
    private @Value("${jdbc.password}") String password;

    // hibernate variables
    private @Value("${hibernate.dialect}") String hibernateDialect;
    private @Value("${hibernate.show_sql}") String hibernateShowSql;

    @Bean
    public DataSource dataSourceBean()
    {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource)
    {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("org.baali.dao");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
        hibernateProperties.setProperty("hibernate.show_sql", hibernateShowSql);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManagerBean(SessionFactory sessionFactory)
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslationBean() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
