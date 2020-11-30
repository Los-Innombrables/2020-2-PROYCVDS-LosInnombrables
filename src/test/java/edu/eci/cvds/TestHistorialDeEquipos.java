package edu.eci.cvds;

import org.junit.Assert;
import org.junit.Test;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesElemento;
import edu.eci.cvds.services.ServicesEquipo;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;
import edu.eci.cvds.services.ServicesLaboratorio;
import edu.eci.cvds.services.ServicesNovedad;
import edu.eci.cvds.services.ServicesTipoElemento;
import edu.eci.cvds.services.ServicesUsuario;

public class TestHistorialDeEquipos {

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
            servicesUsuario.logInUsuario("homie.simpson",
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

    @Test
    public void consultarEquiposTest() {
        try {
            servicesEquipo.consultarEquiposObj();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarUsuariosTest() {
        try {
            servicesUsuario.consultarUsuarios();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarLaboratoriosTest() {
        try {
            servicesLaboratorio.consultarLaboratorios();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarLaboratorioNombreTest() {
        try {
            servicesLaboratorio.consultarLaboratorioNombre("Multimedia y Moviles");
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarElementosTest() {
        try {
            servicesElemento.consultarElementosObj();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarNovedadesTest() {
        try {
            servicesNovedad.consultarNovedadesObj();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarTipoElementoTest() {
        try {
            servicesTipoElemento.consultarTipoElemento();
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

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

    @Test
    public void consultarElementosEquipoTest() {
        try {
            servicesElemento.consultarElementosEquipo(0);
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarElementoIdTest() {
        try {
            servicesElemento.consultarElementoId(0);
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarEquipoIdTest() {
        try {
            servicesEquipo.consultarEquipoId(0);
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarEquiposLabTest() {
        try {
            servicesEquipo.consultarEquiposLab(0);
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarNovedadesEquipoTest() {
        try {
            servicesNovedad.consultarNovedadesEquipo(0);
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void consultarNovedadesElementoTest() {
        try {
            servicesNovedad.consultarNovedadesElemento(0);
            Assert.assertTrue(true);
        } catch (HistorialEquiposException e) {
            Assert.assertTrue(false);
        }
    }
}
