package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.persistence.mybatis.mappers.NovedadMapper;

import java.util.List;

public class MyBatisNovedadDAO implements NovedadDAO {

    @Inject
    private NovedadMapper novedadMapper;

    @Override
    public List<Novedad> consultarNovedadesObj() throws HistorialEquiposException {
        try{
            return novedadMapper.consultarNovedadesObj();
        }catch (Exception e){
            e.printStackTrace();
            throw new HistorialEquiposException("Error al consultar novedades");
        }
    }

    @Override
    public void registrarNovedad(Novedad novedad) throws HistorialEquiposException {
        try{
            novedadMapper.registrarNovedad(novedad);
        }catch (Exception e){
            throw new HistorialEquiposException("Error Al Agregar Novedad");
        }
    }

}
