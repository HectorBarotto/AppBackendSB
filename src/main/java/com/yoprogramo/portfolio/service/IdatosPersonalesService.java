package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.DatosPersonales;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IdatosPersonalesService {
    //método para traer una ista con datos personales de los usuarios del portfolio
    public List<DatosPersonales> getDatosPersonales();
    //método para ingresar datos personales de un usuario
    public void saveDatosPersonales(DatosPersonales datosPersonales);
    //método para borrar datos personales de un usuario
    public void deleteDatosPersonales(int id);
    //método para modificar datos personales de un usuario
    public void editDatosPersonales(DatosPersonales datosPersonales);
    //método para encontrar los datos personales de un usuario
    public DatosPersonales findDatosPersonales(int id);
}
