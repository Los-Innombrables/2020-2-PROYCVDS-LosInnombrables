package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.services.ServicesEquipo;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServicesEquipoImpl implements ServicesEquipo {

    private String message = "";

    @Inject
    private EquipoDAO equipoDAO;

    @Override
    public void addEquipo(Equipo equipo) {
        try{
            equipoDAO.addEquipo(equipo);
        }catch (Exception e){
            message = "Error Al Adicionar Equipo";
        }
    }

    @Override
    public List<Equipo> consultarEquipos() {
        try{
            return equipoDAO.consultarEquipos();
        }catch (Exception e){
            message = "Error Al Consultar Equipos";
            return null;
        }
    }

}
