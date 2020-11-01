package edu.eci.cvds.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatis.*;
import edu.eci.cvds.services.impl.*;
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
                bind(LaboratorioDAO.class).to(MyBatisLaboratorioDAO.class);
                bind(NovedadDAO.class).to(MyBatisNovedadDAO.class);
                bind(TipoElementoDAO.class).to(MyBatisTipoElementoDAO.class);
                /* Falta Poner los servicios */
                bind(ServicesUsuario.class).to(ServicesUsuarioImpl.class);
                bind(ServicesEquipo.class).to(ServicesEquipoImpl.class);
                bind(ServicesElemento.class).to(ServicesElementoImpl.class);
                bind(ServicesLaboratorio.class).to(ServicesLaboratorioImpl.class);
                bind(ServicesNovedad.class).to(ServicesNovedadImpl.class);
                bind(ServicesTipoElemento.class).to(ServicesTipoElementoImpl.class);

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

    public ServicesElemento getServicesElemento(){return injector.getInstance(ServicesElemento.class);}

    public ServicesLaboratorio getServicesLaboratorio(){return injector.getInstance(ServicesLaboratorio.class);}

    public ServicesNovedad getServicesNovedad(){return injector.getInstance(ServicesNovedad.class);}

    public ServicesTipoElemento getServicesTipoElemento(){return injector.getInstance(ServicesTipoElemento.class);}

}
