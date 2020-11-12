package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.HistorialEquiposException;
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
    public void addEquipo(Equipo equipo) throws HistorialEquiposException {
        try{
            equipoMapper.addEquipo(equipo);
        }catch (Exception e){
            throw new HistorialEquiposException("Error Al Adicionar Equipo");
        }
    }

    @Override
    public List<Equipo> consultarEquiposObj() throws HistorialEquiposException {
        try{
            return equipoMapper.consultarEquiposObj();
        }catch (Exception e){
            e.printStackTrace();
            throw new HistorialEquiposException("Error al consultar Equipo");
        }
    }

    @Override
    public void darDeBajaEquipo(int id, boolean activo) throws HistorialEquiposException {
        try{
            equipoMapper.darDeBajaEquipo(id, activo);
        }catch (Exception e){
            throw new HistorialEquiposException("Error al dar de baja");
        }
    }

    @Override
    public Equipo consultarEquipoId(int id) throws HistorialEquiposException {
        try{
            return equipoMapper.consultarEquipoId(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new HistorialEquiposException("Error al consultar equipo");
        }
    }

    @Override
    public void asociarLaboratorio(int laboratorio, int id) throws HistorialEquiposException {
        try{
            equipoMapper.asociarLaboratorio(laboratorio, id);
        }catch (Exception e){
            throw new HistorialEquiposException("No se pudo asociar el equipo");
        }
    }
}
