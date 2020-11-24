package edu.eci.cvds.services;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface ServicesLaboratorio {

    List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException;

    Laboratorio consultarLaboratorioNombre(String nombre) throws HistorialEquiposException;

    void addLaboratorio(Laboratorio laboratorio) throws HistorialEquiposException;

    void cerrarLaboratorio(int id) throws HistorialEquiposException;

    void actualizarNombre(int id, String nombre) throws HistorialEquiposException;

    void abrirLaboratorio(int id) throws  HistorialEquiposException;

}
