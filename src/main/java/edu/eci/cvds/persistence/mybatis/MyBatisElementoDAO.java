package edu.eci.cvds.persistence.mybatis;

import java.util.List;

import javax.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.ElementoMapper;

public class MyBatisElementoDAO implements ElementoDAO {

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public List<Elemento> consultarElementosObj() throws HistorialEquiposException {
        try {
            return elementoMapper.consultarElementosObj();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HistorialEquiposException("Error al consultar Elementos");
        }
    }

    @Override
    public void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException {
        try {
            elementoMapper.actualizarEquipoAsociado(id, equipo);
        } catch (Exception e) {
            throw new HistorialEquiposException("Error al Actualizar equipo");
        }
    }

    @Override
    public void addElemento(Elemento elemento) throws HistorialEquiposException {
        try {
            elementoMapper.addElemento(elemento);
        } catch (Exception e) {
            throw new HistorialEquiposException("Error Al Adicionar Elemento");
        }
    }

    @Override
    public List<Elemento> consultarElementosEquipo(int equipo) throws HistorialEquiposException {
        try {
            return elementoMapper.consultarElementosEquipo(equipo);
        } catch (Exception e) {
            throw new HistorialEquiposException("Error al consultar Elementos");
        }
    }

    @Override
    public Elemento consultarElementoId(int id) throws HistorialEquiposException {
        try {
            return elementoMapper.consultarElementoId(id);
        } catch (Exception e) {
            throw new HistorialEquiposException("Error al consultar elemento");
        }
    }

    @Override
    public void actualizarEstado(int id, boolean activo) throws HistorialEquiposException {
        try {
            elementoMapper.actualizarEstado(id, activo);
        } catch (Exception e) {
            throw new HistorialEquiposException("Error al actualizar elemento");
        }
    }

    @Override
    public void actualizarMarca(int id, String marca) throws HistorialEquiposException {
        try {
            elementoMapper.actualizarMarca(id, marca);
        } catch (Exception e) {
            throw new HistorialEquiposException("Error al actualizar la marca");
        }
    }

    @Override
    public void actualizarReferencia(int id, String referencia) throws HistorialEquiposException {
        try {
            elementoMapper.actualizarReferencia(id, referencia);
        } catch (Exception e) {
            throw new HistorialEquiposException("Error al actualizar la referencia");
        }
    }

}
