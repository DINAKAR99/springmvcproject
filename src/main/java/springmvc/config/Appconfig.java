package springmvc.config;

import java.sql.Driver;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springmvc.models.User;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "springmvc.controller" })
public class Appconfig {

    @Bean("viewresolver")
    InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver rv = new InternalResourceViewResolver();

        rv.setPrefix("/WEB-INF/views/");
        rv.setSuffix(".jsp");
        return rv;

    }

    @Bean
    public DriverManagerDataSource getdataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:4233/spring_mvc_orm");
        dataSource.setUsername("postgres");
        dataSource.setPassword("dinakar1.");
        return dataSource;

    }

    @Bean
    LocalSessionFactoryBean getFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(getdataSource());

        Properties p = new Properties();
        p.setProperty("hibernate.hbm2ddl.auto", "update");
        factory.setHibernateProperties(p);

        factory.setAnnotatedClasses(User.class);
        return factory;
    }

    @Bean
    HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager hm = new HibernateTransactionManager();

        hm.setSessionFactory(getFactory().getObject());

        return hm;
    }
}
