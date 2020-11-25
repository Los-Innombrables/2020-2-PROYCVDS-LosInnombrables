package edu.eci.cvds.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.services.ServicesElemento;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;
import edu.eci.cvds.services.ServicesNovedad;

public class ServicesElementoImpl implements ServicesElemento {

    @Inject
    private ElementoDAO elementoDAO;

    @Override
    public List<Elemento> consultarElementosObj() throws HistorialEquiposException {
        try {
            return elementoDAO.consultarElementosObj();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException {
        try {
            elementoDAO.actualizarEquipoAsociado(id, equipo);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void addElemento(Elemento elemento) throws HistorialEquiposException {
        try {
            elementoDAO.addElemento(elemento);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public List<Elemento> consultarElementosEquipo(int equipo) throws HistorialEquiposException {
        try {
            return elementoDAO.consultarElementosEquipo(equipo);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public Elemento consultarElementoId(int id) throws HistorialEquiposException {
        try {
            return elementoDAO.consultarElementoId(id);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void actualizarEstado(int id, boolean activo) throws HistorialEquiposException {
        try {
            elementoDAO.actualizarEstado(id, activo);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void actualizarMarca(int id, String marca) throws HistorialEquiposException {
        try {
            elementoDAO.actualizarMarca(id, marca);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void actualizarReferencia(int id, String referencia) throws HistorialEquiposException {
        try {
            elementoDAO.actualizarReferencia(id, referencia);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    public void eliminarElementos(int equipo, String torre, String mouse, String pantalla, String teclado,
            int responsable) throws HistorialEquiposException {
        ArrayList<Elemento> elementos = (ArrayList<Elemento>) this.consultarElementosEquipo(equipo);
        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        for (Elemento elemento : elementos) {
            String tipo = elemento.getTipo();
            this.actualizarEquipoAsociado(elemento.getId(), 0);
            if (torre.equalsIgnoreCase(tipo) || mouse.equalsIgnoreCase(tipo) || pantalla.equalsIgnoreCase(tipo)
                    || teclado.equalsIgnoreCase(tipo)) {
                this.actualizarEstado(elemento.getId(), false);
                Novedad novedad = new Novedad(1, responsable, 0, elemento.getId(), null, "Elemento Dado De Baja",
                        "Elemento dado de baja debido junto con su equipo");
                servicesNovedad.registrarNovedad(novedad);
            } else {
                Novedad novedad = new Novedad(1, responsable, 0, elemento.getId(), null, "Elemento Libre",
                        "Elemento libre debido a equipo principal dado de baja");
                servicesNovedad.registrarNovedad(novedad);
            }
        }
    }

}
