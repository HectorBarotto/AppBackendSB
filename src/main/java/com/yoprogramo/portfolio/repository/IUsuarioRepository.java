package com.yoprogramo.portfolio.repository;

import com.yoprogramo.portfolio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByUserNameAndPassword(String userName, String password);
}
