package com.SpringORM;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class App {
    public static void main( String[] args ){
        
//    	ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringORM/Config.xml");
//    	
//    	StudentDao dao = context.getBean("StudentDao", StudentDao.class);
//    	
//    	Student student = new Student(334, "Harry Potter" , "London");
//    	
//    	dao.save(student);
    	DriverManagerDataSource ds = new DriverManagerDataSource();
    	ds.setDriverClassName("com.mysql.jdbc.Driver");
    	ds.setUrl("jdbc:mysql://localhost:3306/ExploringSpring?useSSL=false");
    	ds.setUsername("happypotter");
    	ds.setPassword("password");
    	
    	LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
    	bean.setDataSource(ds);
    	bean.setMappingResources("com/SpringORM/studentConf.xml");
    	
    	Properties prop = new Properties();
    	prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
    	prop.setProperty("hbm2ddl", "update");
    	prop.setProperty("show_sql", "true");
    	
    	bean.setHibernateProperties(prop);
    	
    	HibernateTemplate template = new HibernateTemplate();
    	template.setSessionFactory((SessionFactory) bean);
    	
    	StudentDao dao= new StudentDao();
    	dao.setHibernateTemplate(template);
    	
    	dao.save(new Student(32, "kaustubh", "loin"));
    	
    	
    	
    }
}
