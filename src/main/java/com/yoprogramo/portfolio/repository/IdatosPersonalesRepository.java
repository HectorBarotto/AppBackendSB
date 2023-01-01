
package com.yoprogramo.portfolio.repository;

import com.yoprogramo.portfolio.model.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* Repository o DAO (Data Access Object): Es la capa encargada de la persistencia de los datos, es decir, 
* del resultado de la interacción de modelado entre las clases desarrolladas y las tablas de una base de datos. 
* Permite el acceso a los datos mediante diferentes tecnologías como por ejemplo JDBC o algún ORM 
* como por ejemplo JPA con Hibernate. Cada una de las clases que se encuentren dentro de esta capa 
* deben estar mapeadas/etiquetadas mediante la annotation @Repository.
 */
@Repository
public interface IdatosPersonalesRepository extends JpaRepository<DatosPersonales, Integer>{
    
}
