package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.TipoElementoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.TipoElementoMapper;

import java.util.List;

public class MyBatisTipoElementoDAO implements TipoElementoDAO {

    @Inject
    TipoElementoMapper tipoElementoMapper;

    @Override
    public List<TipoElemento> consultarTipoElemento() throws HistorialEquiposException {
        try{
            return tipoElementoMapper.consultarTipoElemento();
        }catch (Exception e){
            throw new HistorialEquiposException("Error Al Consultar Los Tipos De Elementos");
        }
    }
}
