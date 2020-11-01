package edu.eci.cvds.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatis.MyBatisElementoDAO;
import edu.eci.cvds.persistence.mybatis.MyBatisEquipoDAO;
import edu.eci.cvds.persistence.mybatis.MyBatisUserDAO;
import edu.eci.cvds.services.impl.ServicesElementoImpl;
import edu.eci.cvds.services.impl.ServicesEquipoImpl;
import edu.eci.cvds.services.impl.ServicesUsuarioImpl;
import org.mybatis.guice.XMLMyBatisModule;

public class ServicesHistorialDeEquipoFactory {

    private static ServicesHistorialDeEquipoFactory instance = new ServicesHistorialDeEquipoFactory();
    private static Injector injector;

    public ServicesHistorialDeEquipoFactory() {
        injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                // install(JdbcHelper.PostgreSQL);
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
    }

    public static ServicesHistorialDeEquipoFactory getInstance() {
        return instance;
    }

    public ServicesUsuario getServicesUsuario() {
        return injector.getInstance(ServicesUsuario.class);
    }

    public ServicesEquipo getServicesEquipo(){return injector.getInstance(ServicesEquipo.class);}

}
