package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.services.ServicesElemento;

import java.util.List;

public class ServicesElementoImpl implements ServicesElemento {

    @Inject
    private ElementoDAO elementoDAO;

    @Override
    public List<Elemento> consultarElementos() {
        try{
            return elementoDAO.consultarElementos();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void actualizarEquipoAsociado(int id, int equipo) {
        try{
            elementoDAO.actualizarEquipoAsociado(id, equipo);
        }catch (Exception e){
        }
    }
}
