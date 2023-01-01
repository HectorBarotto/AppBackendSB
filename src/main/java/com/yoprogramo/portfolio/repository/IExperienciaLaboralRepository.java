
package com.yoprogramo.portfolio.repository;

import com.yoprogramo.portfolio.model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer> {
    
}
