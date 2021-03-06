package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.services.ServicesLaboratorio;

import javax.inject.Inject;
import java.util.List;

public class ServicesLaboratorioImpl implements ServicesLaboratorio {

    @Inject
    private LaboratorioDAO laboratorioDAO;

    @Override
    public List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException {
        try {
            return laboratorioDAO.consultarLaboratorios();
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public Laboratorio consultarLaboratorioNombre(String nombre) throws HistorialEquiposException {
        try {
            return laboratorioDAO.consultarLaboratorioNombre(nombre);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void addLaboratorio(Laboratorio laboratorio) throws HistorialEquiposException {
        try {
            laboratorioDAO.addLaboratorio(laboratorio);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void cerrarLaboratorio(int id) throws HistorialEquiposException {
        try {
            laboratorioDAO.cerrarLaboratorio(id);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void actualizarNombre(int id, String nombre) throws HistorialEquiposException {
        try{
            laboratorioDAO.actualizarNombre(id, nombre);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void abrirLaboratorio(int id) throws HistorialEquiposException {
        try{
            laboratorioDAO.abrirLaboratorio(id);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

}
