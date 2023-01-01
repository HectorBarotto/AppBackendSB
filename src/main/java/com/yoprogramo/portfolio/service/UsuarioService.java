
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.Usuario;
import com.yoprogramo.portfolio.repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    public IUsuarioRepository iUsuarioRepository;
    @Override
    public List<Usuario> getUsuarios(){
        return iUsuarioRepository.findAll();
    }
    @Override
    public Usuario findUsuario(int id){
        return iUsuarioRepository.findById(id).orElse(null);
    }
    @Override
    public void saveUsuario(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
    @Override
    public void deleteUsuario(int id){
        iUsuarioRepository.deleteById(id);
    }
    @Override
    public void editUsuario(Usuario usuario){
        iUsuarioRepository.save(usuario);
    }
}
