package edu.eci.cvds.services;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface ServicesElemento {

    List<Elemento> consultarElementos() throws HistorialEquiposException;

    void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException;

    void addElemento(Elemento elemento) throws HistorialEquiposException;

}
