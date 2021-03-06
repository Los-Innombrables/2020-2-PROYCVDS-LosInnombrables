package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface ElementoDAO {

    List<Elemento> consultarElementosObj() throws HistorialEquiposException;

    void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException;

    void addElemento(Elemento elemento) throws HistorialEquiposException;

    List<Elemento> consultarElementosEquipo(int equipo) throws HistorialEquiposException;

    Elemento consultarElementoId(int id) throws HistorialEquiposException;

    void actualizarEstado(int id, boolean activo) throws HistorialEquiposException;

    void actualizarMarca(int id, String marca) throws HistorialEquiposException;

    void actualizarReferencia(int id, String referencia) throws HistorialEquiposException;
}
