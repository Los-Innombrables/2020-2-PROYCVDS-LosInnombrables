package edu.eci.cvds.persistence.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Elemento;

public interface ElementoMapper {

    List<Elemento> consultarElementosObj();

    void actualizarEquipoAsociado(@Param("id") int id, @Param("equipo") int equipo);

    void addElemento(@Param("elemento") Elemento elemento);

    List<Elemento> consultarElementosEquipo(@Param("equipo") int equipo);

    Elemento consultarElementoId(@Param("id") int id);

    void actualizarEstado(@Param("id") int id, @Param("activo") boolean activo);

    void actualizarMarca(@Param("id") int id, @Param("marca") String marca);

    void actualizarReferencia(@Param("id") int id, @Param("referencia") String referencia);
}
