
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.Habilidades;
import com.yoprogramo.portfolio.repository.IHabilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesService implements IHabilidadesService{
    @Autowired
    public IHabilidadesRepository iHabilidadesRepository;
    @Override
    public List<Habilidades> getHabilidades(){
        return iHabilidadesRepository.findAll();
    }
    @Override
    public Habilidades findHabilidades(int id){
        return iHabilidadesRepository.findById(id).orElse(null);
    }
    @Override
    public void saveHabilidades(Habilidades habilidades){
        iHabilidadesRepository.save(habilidades);
    }
    @Override
    public void deleteHabilidades(int id){
        iHabilidadesRepository.deleteById(id);
    }
    @Override
    public void editHabilidades(Habilidades habilidades){
        iHabilidadesRepository.save(habilidades);
    }
}
