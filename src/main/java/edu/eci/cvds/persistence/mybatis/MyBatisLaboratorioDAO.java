package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.persistence.mybatis.mappers.LaboratorioMapper;

import javax.inject.Inject;
import java.util.List;

public class MyBatisLaboratorioDAO implements LaboratorioDAO {

    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Override
    public List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException {
        try{
           return laboratorioMapper.consultarLaboratorios();
        }catch (Exception e){
            throw new HistorialEquiposException("Error Al Consultar Laboratorios");
        }
    }

    @Override
    public Laboratorio consultarLaboratorioNombre(String nombre) throws HistorialEquiposException {
        try{
            return laboratorioMapper.consultarLaboratorioNombre(nombre);
        }catch (Exception e){
            throw  new HistorialEquiposException("Laboratorio con nombre " + nombre + " no existe");
        }
    }

}
