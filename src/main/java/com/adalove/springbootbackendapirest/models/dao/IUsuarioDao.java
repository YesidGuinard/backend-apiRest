package com.adalove.springbootbackendapirest.models.dao;

import com.adalove.springbootbackendapirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    public Usuario findByUserName(String userName);

    /*public Usuario findByUserNameAndEmail(String userName,String email);*/

    /*@Query("select u from Usuario u where u.userName=?1 and u.otro=?2")
    public Usuario findByUserName2(String userName,String otro);*/

    @Query("select u from Usuario u where u.userName=?1")
    public Usuario findByUserName2(String userName);
}
