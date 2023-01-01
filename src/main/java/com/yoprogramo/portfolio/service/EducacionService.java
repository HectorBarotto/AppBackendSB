
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.Educacion;
import com.yoprogramo.portfolio.repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    @Autowired
    public IEducacionRepository iEducacionRepository;
    @Override
    public List<Educacion> getEducacion(){
        return iEducacionRepository.findAll();
    }
    @Override
    public Educacion findEducacion(int id){
        return iEducacionRepository.findById(id).orElse(null);
    }
    @Override
    public void saveEducacion(Educacion educacion){
        iEducacionRepository.save(educacion);
    }
    @Override
    public void deleteEducacion(int id){
        iEducacionRepository.deleteById(id);
    }
    @Override
    public void editEducacion(Educacion educacion){
        iEducacionRepository.save(educacion);
    }
}
