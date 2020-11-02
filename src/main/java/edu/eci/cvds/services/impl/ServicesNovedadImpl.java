package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.services.ServicesNovedad;

import java.util.List;

public class ServicesNovedadImpl implements ServicesNovedad {

    @Inject
    private NovedadDAO novedadDAO;

    @Override
    public List<Novedad> consultarNovedades() throws HistorialEquiposException{
        try{
            return novedadDAO.consultarNovedades();
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void registrarNovedad(Novedad novedad) throws HistorialEquiposException {
        try{
            novedadDAO.registrarNovedad(novedad);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

}
