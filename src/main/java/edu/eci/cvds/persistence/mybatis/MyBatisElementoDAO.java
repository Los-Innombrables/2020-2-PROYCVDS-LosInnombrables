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
            throw new HistorialEquiposException("Usuario o Contraseña Incorrectos");
        }
    }
}
