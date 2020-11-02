package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ElementoMapper {

    List<Elemento> consultarElementos();

    void actualizarEquipoAsociado(@Param("id") int id, @Param("equipo") int equipo);

    void addElemento(@Param("elemento") Elemento elemento);

}
