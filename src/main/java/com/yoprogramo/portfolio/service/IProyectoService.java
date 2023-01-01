
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.Proyecto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProyectoService {
    public List<Proyecto> getProyectos();
    public void saveProyecto(Proyecto proyecto);
    public void deleteProyecto(int id);
    public void editProyecto(Proyecto proyecto);
    public Proyecto findProyecto(int id);
}
