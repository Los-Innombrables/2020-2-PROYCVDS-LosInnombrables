package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;
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
    public void loginValido(){
        try{
            boolean respuesta;
            respuesta = servicesUsuario.logIn("homie","a4e5c1418bdae16978bb91c2cffac2dd972ec15bb99f501e8788dde940cb0235");
            Assert.assertTrue(respuesta);
        }catch (Exception e){
            Assert.assertTrue(false);
        }
    }

    @Test
    public void loginValidoObj(){
        try{
            Usuario usuario;
            usuario = servicesUsuario.logInUsuario("homie","a4e5c1418bdae16978bb91c2cffac2dd972ec15bb99f501e8788dde940cb0235");
            /*System.out.println(usuario.getCarnet());
            System.out.println(usuario.getNombre());
            System.out.println(usuario.getApellido());
            System.out.println(usuario.getCorreo());
            System.out.println(usuario.getUserName());
            System.out.println(usuario.getPasswd());
            System.out.println(usuario.isActivo());
            System.out.println(usuario.getRol());*/
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.assertTrue(false);
        }
    }

    @Test
    public void loginNoValido(){
        try {
            boolean respuesta;
            respuesta = servicesUsuario.logIn("admin", "admin");
            Assert.assertFalse(respuesta);
        }catch (Exception e){
            Assert.assertTrue(false);
        }
    }

}
