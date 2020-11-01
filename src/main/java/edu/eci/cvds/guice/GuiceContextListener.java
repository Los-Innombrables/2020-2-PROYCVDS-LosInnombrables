package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatis.MyBatisElementoDAO;
import edu.eci.cvds.persistence.mybatis.MyBatisEquipoDAO;
import edu.eci.cvds.persistence.mybatis.MyBatisUserDAO;
import edu.eci.cvds.services.ServicesElemento;
import edu.eci.cvds.services.ServicesEquipo;
import edu.eci.cvds.services.ServicesUsuario;
import edu.eci.cvds.services.impl.ServicesElementoImpl;
import edu.eci.cvds.services.impl.ServicesEquipoImpl;
import edu.eci.cvds.services.impl.ServicesUsuarioImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                /* Falta Poner las DAO */
                bind(UsuarioDAO.class).to(MyBatisUserDAO.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(ElementoDAO.class).to(MyBatisElementoDAO.class);
                /* Falta Poner los servicios */
                bind(ServicesUsuario.class).to(ServicesUsuarioImpl.class);
                bind(ServicesEquipo.class).to(ServicesEquipoImpl.class);
                bind(ServicesElemento.class).to(ServicesElementoImpl.class);
            }
        });

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }

}
