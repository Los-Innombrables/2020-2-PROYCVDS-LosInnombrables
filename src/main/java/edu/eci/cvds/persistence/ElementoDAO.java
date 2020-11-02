package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface ElementoDAO {

    List<Elemento> consultarElementos() throws HistorialEquiposException;

    void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException;

}
