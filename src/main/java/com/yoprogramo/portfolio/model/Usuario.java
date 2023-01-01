package com.yoprogramo.portfolio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table(name="usuario")
@Getter @Setter
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "is_owner")
    private Boolean isOwner;

    public Usuario(){
        
    }
    public Usuario(int id, String userName, String password, boolean isOwner){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.isOwner = isOwner;
    }
}
