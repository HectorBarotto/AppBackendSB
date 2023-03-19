
package com.yoprogramo.portfolio.controller;

import com.yoprogramo.portfolio.model.DatosPersonales;
import com.yoprogramo.portfolio.model.Educacion;
import com.yoprogramo.portfolio.model.ExperienciaLaboral;
import com.yoprogramo.portfolio.model.Habilidades;
import com.yoprogramo.portfolio.model.Proyecto;
import com.yoprogramo.portfolio.model.Usuario;
import com.yoprogramo.portfolio.service.IEducacionService;
import com.yoprogramo.portfolio.service.IExperienciaLaboralService;
import com.yoprogramo.portfolio.service.IHabilidadesService;
import com.yoprogramo.portfolio.service.IProyectoService;
import com.yoprogramo.portfolio.service.IUsuarioService;
import com.yoprogramo.portfolio.service.IdatosPersonalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*
 Controller: Es la capa encargada de atender las solicitudes http entrantes, derivarlas a la capa que corresponda, 
 esperar por una respuesta, generarla y transmitirla nuevamente al cliente. 
 Generalmente la capa “Controller” trabaja estrechamente con la capa de “Service”, donde a partir de una request 
 llama a las funciones que necesite de la capa service para generar una response.
*/
@RestController //Anotación que determina la clase controladora -Permite redirigir las peticiones del cliente
public class Controller {
    @Autowired //Permite la inyección de dependencias
    private IdatosPersonalesService iDatosPersonalesService;
    @Autowired
    private IUsuarioService iUsuarioService;
    @Autowired
    private IEducacionService iEducacionService;
    @Autowired
    private IExperienciaLaboralService iExperienciaLaboralService;
    @Autowired
    private IHabilidadesService iHabilidadesService;
    @Autowired
    private IProyectoService iProyectoService;
//Usuario
    @GetMapping("/api/usuario/traer") //GET -> Método HTTP para obtener información, end-point que se ejecuta al recibir una solicitud GET
    @ResponseBody // Retorna una Lista en formato JSON en el cuerpo de la respuesta
    public List<Usuario> getUsuarios(){
        return iUsuarioService.getUsuarios();
    }
    @GetMapping("/api/usuario/traer/{id}")
    @ResponseBody
    public Usuario findUsuario(@PathVariable int id){
        return iUsuarioService.findUsuario(id);
    }
    @GetMapping("/api/usuario/traer/{userName}/{password}")
    @ResponseBody
    public Usuario findUsuario(@PathVariable String userName, @PathVariable String password){
        return iUsuarioService.findUsuario(userName, password);
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PostMapping("/api/usuario/login")
    //@ResponseBody
    public Usuario findUsuario(@RequestBody Usuario usuario){
        return iUsuarioService.findUsuario(usuario.getUserName(), usuario.getPassword());
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PostMapping("/api/usuario/agregar") //POST -> Método HTTP para generar información para ser guardada
    /* El método POST no envía valores mediante la URL, sino mediante el cuerpo o la cabecera de los mensajes HTTP.*/
    public int createUsuario (@RequestBody Usuario usuario){
        iUsuarioService.saveUsuario(usuario);
        return usuario.getId();
        /*return iUsuarioService.getIdUsuario(usuario);*/
        //devuelve un string avisando si se creó correctamente
        /*return "Los nuevos datos han sido agregados correctamente.";*/
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @DeleteMapping("/api/usuario/borrar/{id}") // DELETE -> Eliminar registro
    public String deleteUsuario (@PathVariable int id){
        iUsuarioService.deleteUsuario(id);
        //devuelve un string avisando si se eliminó correctamente
        return "El registro sido eliminado correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/usuario/editar") // PUT -> Actualizar información en la DB
    public Usuario editUsuario (@RequestBody Usuario usuario){
        //Busco el registro
        Usuario datos = iUsuarioService.findUsuario(usuario.getId());
        if(datos != null){
            datos = new Usuario(usuario.getId(), usuario.getUserName(), usuario.getPassword(), usuario.getIsOwner());
            /*
            datos.setUserName(usuario.getUserName());
            datos.setPassword(usuario.getPassword());
            datos.setOwner(usuario.isOwner());
            */
            iUsuarioService.editUsuario(datos);
            //Retorna el nuevo registro de usuario
            
        }
        return datos;
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/usuario/editar/{id}") // PUT -> Actualizar información en la DB
    public Usuario editUsuario (@PathVariable int id,
            @RequestParam("userName") String nuevoUsername,
            @RequestParam("password") String nuevoPassword,
            @RequestParam("isOwner") boolean nuevoIsOwner
            ){
        //Busco el registro
        Usuario datos = iUsuarioService.findUsuario(id);
        if(datos != null){
            datos = new Usuario(id, nuevoUsername, nuevoPassword, nuevoIsOwner);
            /*
            datos.setUserName(nuevoUsername);
            datos.setPassword(nuevoPassword);
            datos.setOwner(nuevoIsOwner);
            */
            iUsuarioService.editUsuario(datos);
        }
        //Retorna el nuevo registro de usuario ó null si no encuentra el id
        return datos;
    }
//DatosPersonales   
    @GetMapping("/api/datospersonales/traer") //GET -> Método HTTP para obtener información, end-point que se ejecuta al recibir una solicitud GET
    @ResponseBody // Retorna una Lista en formato JSON en el cuerpo de la respuesta
    public List<DatosPersonales> getDatosPersonales(){
        return iDatosPersonalesService.getDatosPersonales();
    }
    @GetMapping("/api/datospersonales/traer/{id}")
    @ResponseBody
    public DatosPersonales findDatosPersonales(@PathVariable int id){
        return iDatosPersonalesService.findDatosPersonales(id);
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PostMapping("/api/datospersonales/agregar") //POST -> Método HTTP para generar información para ser guardada
    /* El método POST no envía valores mediante la URL, sino mediante el cuerpo o la cabecera de los mensajes HTTP.*/
    @ResponseBody
    public String createDatosPersonales(@RequestBody DatosPersonales datosPersonales){
        iDatosPersonalesService.saveDatosPersonales(datosPersonales);
        //devuelve un string avisando si se creó correctamente
        return "Los nuevos datos han sido agregados correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @DeleteMapping("/api/datospersonales/borrar/{id}") // DELETE -> Eliminar registro
    public String deleteDatosPersonales(@PathVariable int id){
        iDatosPersonalesService.deleteDatosPersonales(id);
        //devuelve un string avisando si se eliminó correctamente
        return "El registro sido eliminado correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/datospersonales/editar") // PUT -> Actualizar información en la DB
    public DatosPersonales editDatosPersonales (@RequestBody DatosPersonales datosPersonales){
        //Busco el registro
        DatosPersonales datos = iDatosPersonalesService.findDatosPersonales(datosPersonales.getId());
        if(datos != null){

            datos = new DatosPersonales(datosPersonales.getId(), datosPersonales.getNombre(), datosPersonales.getApellido(), datosPersonales.getDomicilio(),
                    datosPersonales.getTelefono(), datosPersonales.getEmail(), datosPersonales.getFechaNac(), 
                    datosPersonales.getSobreMi(), datosPersonales.getUrlFoto(), datosPersonales.getUrlBanner(), 
                    datosPersonales.getIdUsuarioFK());
            /*
            datos.setNombre(datosPersonales.getNombre());
            datos.setApellido(datosPersonales.getApellido());
            datos.setDomicilio(datosPersonales.getDomicilio());
            datos.setTelefono(datosPersonales.getTelefono());
            datos.setEmail(datosPersonales.getEmail());
            datos.setFechaNac(datosPersonales.getFechaNac());
            datos.setSobreMi(datosPersonales.getSobreMi());
            datos.setUrlFoto(datosPersonales.getUrlFoto());
            datos.setUrlBanner(datosPersonales.getUrlBanner());
            datos.setIdUsuarioFK(datosPersonales.getIdUsuarioFK());
            */
            
            iDatosPersonalesService.editDatosPersonales(datos);
        }
        //Retorna el nuevo registro de datos personales
        return datos;
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/datospersonales/editar/{id}") // PUT -> Actualizar información en la DB
    public DatosPersonales editDatosPersonales (@PathVariable int id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("domicilio") String nuevoDomicilio,
            @RequestParam("telefono") String nuevoTelefono,
            @RequestParam("email") String nuevoEmail,
            @RequestParam("fechaNac") String nuevofechaNac,
            @RequestParam("sobreMi") String nuevoSobreMi,
            @RequestParam("urlFoto") String nuevoUrlFoto,
            @RequestParam("urlBanner") String nuevoUrlBanner,
            @RequestParam("idUsuarioFK") Integer nuevoIdUsuarioFK
            ){
        //Busco el registro
        DatosPersonales datos = iDatosPersonalesService.findDatosPersonales(id);
        if(datos != null){
            datos = new DatosPersonales(id, nuevoNombre, nuevoApellido, nuevoDomicilio, nuevoTelefono, nuevoEmail, 
                    nuevofechaNac, nuevoSobreMi, nuevoUrlFoto, nuevoUrlBanner, nuevoIdUsuarioFK);
            /*
            datos.setNombre(nuevoNombre);
            datos.setApellido(nuevoApellido);
            datos.setDomicilio(nuevoDomicilio);
            datos.setTelefono(nuevoTelefono);
            datos.setEmail(nuevoEmail);
            datos.setFechaNac(new ControlFecha().validaFecha(nuevofechaNac));
            datos.setSobreMi(nuevoSobreMi);
            datos.setUrlFoto(nuevoUrlFoto);
            datos.setUrlBanner(nuevoUrlBanner);
            datos.setIdUsuarioFK(nuevoIdUsuarioFK);
            */
            
            iDatosPersonalesService.editDatosPersonales(datos);
        }
        //Retorna el nuevo registro de datos personales
        return datos;
    }
//Educacion   
    @GetMapping("/api/educacion/traer")
    @ResponseBody
    public List<Educacion> getEducacion(){
        return iEducacionService.getEducacion();
    }
    @GetMapping("/api/educacion/traer/{id}")
    @ResponseBody
    public Educacion findEducacion(@PathVariable int id){
        return iEducacionService.findEducacion(id);
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PostMapping("/api/educacion/agregar") 
    public String createEducacion(@RequestBody Educacion educacion){
        iEducacionService.saveEducacion(educacion);

        return "Los nuevos datos han sido agregados correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @DeleteMapping("/api/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable int id){
        iEducacionService.deleteEducacion(id);
        return "El registro sido eliminado correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/educacion/editar")
    public Educacion editEducacion (@RequestBody Educacion educacion){

        Educacion datos = iEducacionService.findEducacion(educacion.getId());
        if(datos != null){

            datos = new Educacion(educacion.getId(), educacion.getInstitucion(), educacion.getTitulo(), 
                    educacion.getDescripcion(), educacion.getFechaInicio(), educacion.getFechaFin(), 
                    educacion.getUrlLogo(), educacion.getIdDatosPersonalesFK());

            iEducacionService.editEducacion(datos);
        }

        return datos;
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/educacion/editar/{id}")
    public Educacion editEducacion (@PathVariable int id,
            @RequestParam("institucion") String nuevoInstitucion,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("fechaInicio") String nuevoFechaInicio,
            @RequestParam("fechaFin") String nuevoFechaFin,
            @RequestParam("urlLogo") String nuevoUrlLogo,
            @RequestParam("idDatosPersonalesFK") int nuevoIdDatosPersonalesFK
            ){

        Educacion datos = iEducacionService.findEducacion(id);
        if(datos != null){
            datos = new Educacion(id, nuevoInstitucion, nuevoTitulo, nuevoDescripcion, nuevoFechaInicio, 
                    nuevoFechaFin, nuevoUrlLogo, nuevoIdDatosPersonalesFK);

            iEducacionService.editEducacion(datos);
        }

        return datos;
    }
//ExperienciaLaboral  
    @GetMapping("/api/experiencialaboral/traer")
    @ResponseBody
    public List<ExperienciaLaboral> getExperienciaLaboral(){
        return iExperienciaLaboralService.getExperienciaLaboral();
    }
    @GetMapping("/api/experiencialaboral/traer/{id}")
    @ResponseBody
    public ExperienciaLaboral findExperienciaLaboral(@PathVariable int id){
        return iExperienciaLaboralService.findExperienciaLaboral(id);
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PostMapping("/api/experiencialaboral/agregar") 
    public String createExperienciaLaboral(@RequestBody ExperienciaLaboral experienciaLaboral){
        iExperienciaLaboralService.saveExperienciaLaboral(experienciaLaboral);

        return "Los nuevos datos han sido agregados correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @DeleteMapping("/api/experiencialaboral/borrar/{id}")
    public String deleteExperienciaLaboral(@PathVariable int id){
        iExperienciaLaboralService.deleteExperienciaLaboral(id);
        return "El registro sido eliminado correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/experiencialaboral/editar")
    public ExperienciaLaboral editExperienciaLaboral (@RequestBody ExperienciaLaboral experienciaLaboral){

        ExperienciaLaboral datos = iExperienciaLaboralService.findExperienciaLaboral(experienciaLaboral.getId());
        if(datos != null){

            datos = new ExperienciaLaboral(experienciaLaboral.getId(), experienciaLaboral.getNombreEmpresa(), 
                    experienciaLaboral.getPuesto(), experienciaLaboral.getIsTrabajoActual(), 
                    experienciaLaboral.getFechaInicio(), experienciaLaboral.getFechaFin(), 
                    experienciaLaboral.getDescripcion(), experienciaLaboral.getUrlLogo(), 
                    experienciaLaboral.getIdDatosPersonalesFK());

            iExperienciaLaboralService.editExperienciaLaboral(datos);
        }

        return datos;
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/experiencialaboral/editar/{id}")
    public ExperienciaLaboral editExperienciaLaboral (@PathVariable int id,
            @RequestParam("nombreEmpresa") String nuevoNombreEmpresa,
            @RequestParam("puesto") String nuevoPuesto,
            @RequestParam("isTrabajoActual") boolean nuevoIsTrabajoActual,
            @RequestParam("fechaInicio") String nuevoFechaInicio,
            @RequestParam("fechaFin") String nuevoFechaFin,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("urlLogo") String nuevoUrlLogo,
            @RequestParam("idDatosPersonalesFK") int nuevoIdDatosPersonalesFK
            ){

        ExperienciaLaboral datos = iExperienciaLaboralService.findExperienciaLaboral(id);
        if(datos != null){
            datos = new ExperienciaLaboral(id, nuevoNombreEmpresa, nuevoPuesto, nuevoIsTrabajoActual, 
                    nuevoFechaInicio, nuevoFechaFin, nuevoDescripcion, nuevoUrlLogo, nuevoIdDatosPersonalesFK);

            iExperienciaLaboralService.editExperienciaLaboral(datos);
        }

        return datos;
    }
//Habilidades  
    @GetMapping("/api/habilidades/traer")
    @ResponseBody
    public List<Habilidades> getHabilidades(){
        return iHabilidadesService.getHabilidades();
    }
    @GetMapping("/api/habilidades/traer/{id}")
    @ResponseBody
    public Habilidades findHabilidades(@PathVariable int id){
        return iHabilidadesService.findHabilidades(id);
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PostMapping("/api/habilidades/agregar") 
    public String createHabilidades(@RequestBody Habilidades habilidades){
        iHabilidadesService.saveHabilidades(habilidades);

        return "Los nuevos datos han sido agregados correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @DeleteMapping("/api/habilidades/borrar/{id}")
    public String deleteHabilidades(@PathVariable int id){
        iHabilidadesService.deleteHabilidades(id);
        return "El registro sido eliminado correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/habilidades/editar")
    public Habilidades editHabilidades (@RequestBody Habilidades habilidades){

        Habilidades datos = iHabilidadesService.findHabilidades(habilidades.getId());
        if(datos != null){

            datos = new Habilidades(habilidades.getId(), habilidades.getDescripcion(), 
                    habilidades.getNivel(), habilidades.getIdDatosPersonalesFK());

            iHabilidadesService.editHabilidades(datos);
        }

        return datos;
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/habilidades/editar/{id}")
    public Habilidades editHabilidades (@PathVariable int id,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("nivel") int nuevoNivel,
            @RequestParam("idDatosPersonalesFK") int nuevoIdDatosPersonalesFK
            ){

        Habilidades datos = iHabilidadesService.findHabilidades(id);
        if(datos != null){
            datos = new Habilidades(id, nuevoDescripcion, nuevoNivel, nuevoIdDatosPersonalesFK);

            iHabilidadesService.editHabilidades(datos);
        }

        return datos;
    }
//Proyecto 
    @GetMapping("/api/proyecto/traer")
    @ResponseBody
    public List<Proyecto> getProyectos(){
        return iProyectoService.getProyectos();
    }
    @GetMapping("/api/proyecto/traer/{id}")
    @ResponseBody
    public Proyecto findProyecto(@PathVariable int id){
        return iProyectoService.findProyecto(id);
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PostMapping("/api/proyecto/agregar") 
    public String createProyecto(@RequestBody Proyecto proyecto){
        iProyectoService.saveProyecto(proyecto);

        return "Los nuevos datos han sido agregados correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @DeleteMapping("/api/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable int id){
        iProyectoService.deleteProyecto(id);
        return "El registro sido eliminado correctamente.";
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/proyecto/editar")
    public Proyecto editProyecto (@RequestBody Proyecto proyecto){

        Proyecto datos = iProyectoService.findProyecto(proyecto.getId());
        if(datos != null){

            datos = new Proyecto(proyecto.getId(), proyecto.getProyecto(), proyecto.getDescripcion(), 
                    proyecto.getFechaInicio(), proyecto.getFechaFin(), proyecto.getUrl(), 
                    proyecto.getUrlLogo(), proyecto.getIdDatosPersonalesFK());

            iProyectoService.editProyecto(datos);
        }

        return datos;
    }
    @CrossOrigin(origins = "https://portfolio-hmb.web.app")
    @PutMapping("/api/proyecto/editar/{id}")
    public Proyecto editProyecto (@PathVariable int id,
            @RequestParam("proyecto") String nuevoProyecto,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("fechaInicio") String nuevoFechaInicio,
            @RequestParam("fechaFin") String nuevoFechaFin,
            @RequestParam("url") String nuevoUrl,
            @RequestParam("urlLogo") String nuevoUrlLogo,
            @RequestParam("idDatosPersonalesFK") int nuevoIdDatosPersonalesFK
            ){

        Proyecto datos = iProyectoService.findProyecto(id);
        if(datos != null){
            datos = new Proyecto(id, nuevoProyecto, nuevoDescripcion, nuevoFechaInicio, nuevoFechaFin, 
                    nuevoUrl, nuevoUrlLogo, nuevoIdDatosPersonalesFK);

            iProyectoService.editProyecto(datos);
        }

        return datos;
    }
}
