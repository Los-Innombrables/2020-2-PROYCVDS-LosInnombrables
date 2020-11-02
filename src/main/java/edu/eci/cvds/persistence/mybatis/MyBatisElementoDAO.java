package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.ElementoMapper;

import javax.inject.Inject;
import java.util.List;

public class MyBatisElementoDAO implements ElementoDAO {

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public List<Elemento> consultarElementos() throws HistorialEquiposException {
        try{
            return elementoMapper.consultarElementos();
        }catch (Exception e){
            throw new HistorialEquiposException("Error al consultar Elementos");
        }
    }

    @Override
    public void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException {
        try{
            elementoMapper.actualizarEquipoAsociado(id, equipo);
        }catch (Exception e){
            e.printStackTrace();
            throw new HistorialEquiposException("Error al Actualizar equipo");
        }
    }
}
