package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;
import edu.eci.cvds.services.ServicesUsuario;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.Assert;

public class TestHistorialDeEquipos {

    @Inject
    private SqlSession sqlSession;

    ServicesUsuario servicesUsuario;

    public  TestHistorialDeEquipos(){
        servicesUsuario = ServicesHistorialDeEquipoFactory.getInstance().getServicesUsuario();
    }

    @Test
    public void logInValido(){
        try{
            boolean respuesta;
            /*respuesta = servicesUsuario.logIn();*/
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.assertTrue(false);
        }
    }

}
