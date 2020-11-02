package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Novedad;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NovedadMapper {

    List<Novedad> consultarNovedades();

    void registrarNovedad(@Param("novedad") Novedad novedad);

}
