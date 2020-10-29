package edu.eci.cvds.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatis.MyBatisUserDAO;
import edu.eci.cvds.services.impl.ServicesUsuarioImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

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
                /* Falta Poner los servicios */
                bind(ServicesUsuario.class).to(ServicesUsuarioImpl.class);
            }
        });
    }

    public static ServicesHistorialDeEquipoFactory getInstance() {
        return instance;
    }

    public ServicesUsuario getServicesUsuario() {
        return injector.getInstance(ServicesUsuario.class);
    }

}
