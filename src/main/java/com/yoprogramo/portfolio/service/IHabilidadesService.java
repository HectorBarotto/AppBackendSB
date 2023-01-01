
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.Habilidades;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IHabilidadesService {
    public List<Habilidades> getHabilidades();
    public void saveHabilidades(Habilidades habilidades);
    public void deleteHabilidades(int id);
    public void editHabilidades(Habilidades habilidades);
    public Habilidades findHabilidades(int id);
}
