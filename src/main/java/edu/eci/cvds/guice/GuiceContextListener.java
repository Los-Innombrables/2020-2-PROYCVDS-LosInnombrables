package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class GuiceContextListener {

    public void contextDestriyed(ServletContextEvent servletContextEvent){
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent){
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            protected void initialize() {
                this.install(JdbcHelper.PostgreSQL);
                this.setEnvironmentId("development");
                this.setClassPathResource("mybatis-config.xml");
                /* Falta Poner los servicios */
                /* Falta Poner las DAO*/
            }
        });

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }

}
