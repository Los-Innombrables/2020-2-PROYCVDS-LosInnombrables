package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface LaboratorioDAO {

    List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException;

}
