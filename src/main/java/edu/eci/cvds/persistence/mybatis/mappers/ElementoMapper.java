package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Elemento;

import java.util.List;

public interface ElementoMapper {

    List<Elemento> consultarElementos();
}
