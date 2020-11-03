package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.services.ServicesElemento;

import java.util.List;

public class ServicesElementoImpl implements ServicesElemento {

    @Inject
    private ElementoDAO elementoDAO;

    @Override
    public List<Elemento> consultarElementos() throws HistorialEquiposException {
        try{
            return elementoDAO.consultarElementos();
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException{
        try{
            elementoDAO.actualizarEquipoAsociado(id, equipo);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void addElemento(Elemento elemento) throws HistorialEquiposException {
        try{
            elementoDAO.addElemento(elemento);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public List<Elemento> consultarElementosEquipo(int equipo) throws HistorialEquiposException {
        try{
            return elementoDAO.consultarElementosEquipo(equipo);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public Elemento consultarElementoId(int id) throws HistorialEquiposException {
        try{
            return elementoDAO.consultarElementoId(id);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

}
