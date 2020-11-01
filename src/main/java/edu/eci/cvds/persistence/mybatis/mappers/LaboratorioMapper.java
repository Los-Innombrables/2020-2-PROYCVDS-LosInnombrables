package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Laboratorio;

import java.util.List;

public interface LaboratorioMapper {

    List<Laboratorio> consultarLaboratorios();
}
