package edu.eci.cvds.services;

import edu.eci.cvds.entities.Elemento;

import java.util.List;

public interface ServicesElemento {

    List<Elemento> consultarElementos();

    void actualizarEquipoAsociado(int id, int equipo);

}
