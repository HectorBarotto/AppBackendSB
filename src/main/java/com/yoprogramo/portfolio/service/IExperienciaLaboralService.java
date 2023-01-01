package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.ExperienciaLaboral;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IExperienciaLaboralService {
    public List<ExperienciaLaboral> getExperienciaLaboral();
    public void saveExperienciaLaboral(ExperienciaLaboral experienciaLaboral);
    public void deleteExperienciaLaboral(int id);
    public void editExperienciaLaboral(ExperienciaLaboral experienciaLaboral);
    public ExperienciaLaboral findExperienciaLaboral(int id);
}
