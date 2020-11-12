package edu.eci.cvds;

import com.google.inject.Inject;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestHistorialDeEquipos {

    @Inject
    private SqlSession sqlSession;

    ServicesUsuario servicesUsuario;
    ServicesEquipo servicesEquipo;
    ServicesLaboratorio servicesLaboratorio;
    ServicesElemento servicesElemento;
    ServicesNovedad servicesNovedad;
    ServicesTipoElemento servicesTipoElemento;

    public TestHistorialDeEquipos() {
        servicesUsuario = ServicesHistorialDeEquipoFactory.getInstance().getServicesUsuario();
        servicesEquipo = ServicesHistorialDeEquipoFactory.getInstance().getServicesEquipo();
        servicesLaboratorio = ServicesHistorialDeEquipoFactory.getInstance().getServicesLaboratorio();
        servicesElemento = ServicesHistorialDeEquipoFactory.getInstance().getServicesElemento();
        servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        servicesTipoElemento = ServicesHistorialDeEquipoFactory.getInstance().getServicesTipoElemento();
    }

    @Test
    public void loginValido() {
        try {
            boolean respuesta;
            respuesta = servicesUsuario.logIn("homie.simpson",
                    "a4e5c1418bdae16978bb91c2cffac2dd972ec15bb99f501e8788dde940cb0235");
            Assert.assertTrue(respuesta);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void loginValidoObj() {
        try {
            Usuario usuario;
            usuario = servicesUsuario.logInUsuario("homie.simpson",
                    "a4e5c1418bdae16978bb91c2cffac2dd972ec15bb99f501e8788dde940cb0235");
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test(expected = HistorialEquiposException.class)
    public void loginNoValido() throws HistorialEquiposException {
        boolean respuesta;
        respuesta = servicesUsuario.logIn("admin", "admin");
        Assert.assertFalse(respuesta);
    }

    /*@Test
    public void adicionarEquipoTest() {
        try {
            Equipo equipo = new Equipo(1, 0, "EquipoPrueba", true);
            servicesEquipo.addEquipo(equipo);
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }*/

    @Test
    public void consultarEquiposTest() {
        try {
            ArrayList<Equipo> equipos = (ArrayList<Equipo>) servicesEquipo.consultarEquiposObj();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarUsuariosTest() {
        try {
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) servicesUsuario.consultarUsuarios();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarLaboratoriosTest() {
        try {
            ArrayList<Laboratorio> laboratorios = (ArrayList<Laboratorio>) servicesLaboratorio.consultarLaboratorios();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarLaboratorioNombreTest() {
        try {
            Laboratorio laboratorio = servicesLaboratorio.consultarLaboratorioNombre("Multimedia y Moviles");
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }


    @Test
    public void consultarElementosTest() {
        try {
            ArrayList<Elemento> elementos = (ArrayList<Elemento>) servicesElemento.consultarElementosObj();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarNovedadesTest() {
        try {
            ArrayList<Novedad> novedades = (ArrayList<Novedad>) servicesNovedad.consultarNovedadesObj();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarTipoElementoTest() {
        try {
            ArrayList<TipoElemento> tipoElementos = (ArrayList<TipoElemento>) servicesTipoElemento.consultarTipoElemento();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    /*@Test
    public void asociarElementoEquipo() {
        try {
            Equipo equipo = new Equipo(12,0,"EquipoTest", true);
            servicesElemento.actualizarEquipoAsociado(6, 12);
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }*/

    @Test
    public void consultarEquipoId() {
        try {
            Equipo equipo = servicesEquipo.consultarEquipoId(2);
            equipo.getNombre();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

}
