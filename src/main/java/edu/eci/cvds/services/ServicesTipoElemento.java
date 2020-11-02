package edu.eci.cvds.services;

import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface ServicesTipoElemento {

    List<TipoElemento> consultarTipoElemento() throws HistorialEquiposException;

}
