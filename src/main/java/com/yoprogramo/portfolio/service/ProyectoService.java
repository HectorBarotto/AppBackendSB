
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.Proyecto;
import com.yoprogramo.portfolio.repository.IProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    public IProyectoRepository iProyectoRepository;
    @Override
    public List<Proyecto> getProyectos(){
        return iProyectoRepository.findAll();
    }
    @Override
    public Proyecto findProyecto(int id){
        return iProyectoRepository.findById(id).orElse(null);
    }
    @Override
    public void saveProyecto(Proyecto proyecto){
        iProyectoRepository.save(proyecto);
    }
    @Override
    public void deleteProyecto(int id){
        iProyectoRepository.deleteById(id);
    }
    @Override
    public void editProyecto(Proyecto proyecto){
        iProyectoRepository.save(proyecto);
    }
}
