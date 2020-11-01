package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Novedad;

import java.util.List;

public interface NovedadMapper {

    List<Novedad> consultarNovedades();

}
