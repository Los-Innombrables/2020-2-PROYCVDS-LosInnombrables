package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Equipo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipoMapper {

    void addEquipo(@Param("equipo") Equipo equipo);

    List<Equipo> consultarEquiposObj();

    void darDeBajaEquipo(@Param("id") int id, @Param("activo") boolean activo);

    Equipo consultarEquipoId(@Param("id") int id);

    void asociarLaboratorio(@Param("laboratorio") int laboratorio, @Param("id") int id);

    List<Equipo> consultarEquiposLab(@Param("id") int id);

    void cambiarNombre(@Param("nombre") String nombre, @Param("id") int id);

    void cambiarEstado(@Param("activo") boolean activo, @Param("id") int id);

}
