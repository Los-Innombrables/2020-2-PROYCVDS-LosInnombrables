package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.services.ServicesTipoElemento;
import edu.eci.cvds.persistence.TipoElementoDAO;

import java.util.List;

public class ServicesTipoElementoImpl implements ServicesTipoElemento {

    @Inject
    private TipoElementoDAO tipoElementoDAO;

    @Override
    public List<TipoElemento> consultarTipoElemento() {
        try{
            return tipoElementoDAO.consultarTipoElemento();
        }catch (Exception e){
            return null;
        }
    }
}
