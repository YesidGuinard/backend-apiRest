package com.adalove.springbootbackendapirest.models.dao;

import com.adalove.springbootbackendapirest.models.entity.Role;
import com.adalove.springbootbackendapirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    public Usuario findByUserName(String userName);

    /*public Usuario findByUserNameAndEmail(String userName,String email);*/

    /*@Query("select u from Usuario u where u.userName=?1 and u.otro=?2")
    public Usuario findByUserName2(String userName,String otro);*/

   // @Query("select u from Usuario u where u.apellido=?1")
    public Usuario findByApellidoAndEnabledAndRolesEquals(String apellido, Boolean enable, Role role);
}
