
package com.yoprogramo.portfolio.repository;

import com.yoprogramo.portfolio.model.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadesRepository extends JpaRepository<Habilidades, Integer> {
    
}
