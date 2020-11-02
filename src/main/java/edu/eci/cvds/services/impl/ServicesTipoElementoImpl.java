package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesTipoElemento;
import edu.eci.cvds.persistence.TipoElementoDAO;

import java.util.List;

public class ServicesTipoElementoImpl implements ServicesTipoElemento {

    @Inject
    private TipoElementoDAO tipoElementoDAO;

    @Override
    public List<TipoElemento> consultarTipoElemento() throws HistorialEquiposException{
        try{
            return tipoElementoDAO.consultarTipoElemento();
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }
}
