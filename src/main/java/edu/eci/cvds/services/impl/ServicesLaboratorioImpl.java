package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.services.ServicesLaboratorio;

import javax.inject.Inject;
import java.util.List;

public class ServicesLaboratorioImpl implements ServicesLaboratorio {

    @Inject
    private LaboratorioDAO laboratorioDAO;

    @Override
    public List<Laboratorio> consultarLaboratorios() {
        try{
            return laboratorioDAO.consultarLaboratorios();
        }catch (Exception e){
            return null;
        }
    }

}
