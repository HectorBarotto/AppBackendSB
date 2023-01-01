
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.ExperienciaLaboral;
import com.yoprogramo.portfolio.repository.IExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService{
    @Autowired
    public IExperienciaLaboralRepository iExperienciaLaboralRepository;
    @Override
    public List<ExperienciaLaboral> getExperienciaLaboral(){
        return iExperienciaLaboralRepository.findAll();
    }
    @Override
    public ExperienciaLaboral findExperienciaLaboral(int id){
        return iExperienciaLaboralRepository.findById(id).orElse(null);
    }
    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral experienciaLaboral){
        iExperienciaLaboralRepository.save(experienciaLaboral);
    }
    @Override
    public void deleteExperienciaLaboral(int id){
        iExperienciaLaboralRepository.deleteById(id);
    }
    @Override
    public void editExperienciaLaboral(ExperienciaLaboral experienciaLaboral){
        iExperienciaLaboralRepository.save(experienciaLaboral);
    }
}
