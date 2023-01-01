
package com.yoprogramo.portfolio.service;

import com.yoprogramo.portfolio.model.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {
    public List<Usuario> getUsuarios();
    public void saveUsuario(Usuario usuario);
    public void deleteUsuario(int id);
    public void editUsuario(Usuario usuario);
    public Usuario findUsuario(int id);
}
