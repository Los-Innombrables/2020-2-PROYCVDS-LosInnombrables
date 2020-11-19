package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.services.ServicesEquipo;

import javax.inject.Inject;
import java.util.List;

public class ServicesEquipoImpl implements ServicesEquipo {

    @Inject
    private EquipoDAO equipoDAO;

    @Override
    public void addEquipo(Equipo equipo) throws HistorialEquiposException {
        try {
            equipoDAO.addEquipo(equipo);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public List<Equipo> consultarEquiposObj() throws HistorialEquiposException {
        try{
            return equipoDAO.consultarEquiposObj();
        }catch (Exception e){
            e.printStackTrace();
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void darDeBajaEquipo(int id, boolean activo) throws HistorialEquiposException {
        try {
            equipoDAO.darDeBajaEquipo(id, activo);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public Equipo consultarEquipoId(int id) throws HistorialEquiposException {
        try {
            return equipoDAO.consultarEquipoId(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void asociarLaboratorio(int laboratorio, int id) throws HistorialEquiposException {
        try {
            equipoDAO.asociarLaboratorio(laboratorio, id);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public List<Equipo> consultarEquiposLab(int id) throws HistorialEquiposException {
        try{
            return equipoDAO.consultarEquiposLab(id);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void cambiarNombre(String nombre, int id) throws HistorialEquiposException {
        try {
            equipoDAO.cambiarNombre(nombre, id);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public void cambiarEstado(boolean activo, int id) throws HistorialEquiposException {
        try {
            equipoDAO.cambiarEstado(activo, id);
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

}
