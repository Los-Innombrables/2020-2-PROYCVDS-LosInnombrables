package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface TipoElementoDAO {

    List<TipoElemento> consultarTipoElemento() throws HistorialEquiposException;

}
