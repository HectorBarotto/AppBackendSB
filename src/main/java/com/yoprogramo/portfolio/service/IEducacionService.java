
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.Educacion;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IEducacionService {
    public List<Educacion> getEducacion();
    public void saveEducacion(Educacion educacion);
    public void deleteEducacion(int id);
    public void editEducacion(Educacion educacion);
    public Educacion findEducacion(int id);
}
