package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.EquipoMapper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MyBatisEquipoDAO implements EquipoDAO {

    @Inject
    private EquipoMapper equipoMapper;

    @Override
    public void addEquipo(Equipo equipo) throws PersistenceException {
        try{
            equipoMapper.addEquipo(equipo);
        }catch (Exception e){
            throw new PersistenceException("Error Al Adicionar Equipo");
        }
    }

    @Override
    public List<Equipo> consultarEquipos() throws PersistenceException {
        try{
            return equipoMapper.consultarEquipos();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException("Error Al Consultar Equipos");
        }

    }
}
