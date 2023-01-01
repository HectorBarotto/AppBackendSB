
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.DatosPersonales;
import com.yoprogramo.portfolio.repository.IdatosPersonalesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service:  La capa de “Service”, mejor conocida como lógica de negocio, es la capa donde se especifican 
 * todas las funciones u operaciones que sean necesarias y que puedan ofrecer, como dice su nombre, 
 * un servicio a la capa controller. La capa service, por ejemplo, puede encargarse de las autenticaciones o 
 * de las políticas de autorización que puede tener la aplicación con respecto al acceso a determinadas funciones.
 */
@Service
public class DatosPersonalesService implements IdatosPersonalesService{

    /**
     * Inyección de Dependencias. La inyección de dependencias, o mejor conocida como DI 
     * (dependency inyection por sus siglas en inglés), es un patrón de diseño que está orientado al manejo 
     * de los objetos de una aplicación. Su principal objetivo es el de mantener las capas de una aplicación 
     * lo más desacopladas posible entre sí. Para poder lograr esto, la inyección de dependencias permite que 
     * cada una de las partes del programa que se esté desarrollando sea independiente y que no se comuniquen 
     * entre si mediante instancias, sino mediante interfaces.
     * Se entiende entonces que la inyección de dependencias busca desacoplar lo máximo posible la relación entre 
     * clases o capas, pero… ¿Qué es una dependencia? Una dependencia es una relación que puede existir entre una 
     * o varias clases, donde generalmente una (o varias) dependen de otra principal:
     */
    @Autowired // Permite realizar inyección de dependencias
    public IdatosPersonalesRepository iDatosPersonalesRepository;
    
    @Override
    public List<DatosPersonales> getDatosPersonales(){
        /*
        List<DatosPersonales> listaDatosPersonales = iDatosPersonalesRepository.findAll();
        return listaDatosPersonales;
        */
        return iDatosPersonalesRepository.findAll();
    }
    @Override
    public DatosPersonales findDatosPersonales(int id){
        /*
        DatosPersonales datos = iDatosPersonalesRepository.findById(id).orElse(null);
        return datos;
        */
        return iDatosPersonalesRepository.findById(id).orElse(null);
    }
    @Override
    public void saveDatosPersonales(DatosPersonales datosPersonales){
        iDatosPersonalesRepository.save(datosPersonales);
    }
    @Override
    public void deleteDatosPersonales(int id){
        iDatosPersonalesRepository.deleteById(id);
    }
    @Override
    public void editDatosPersonales(DatosPersonales datosPersonales){
        iDatosPersonalesRepository.save(datosPersonales);
    }

}
