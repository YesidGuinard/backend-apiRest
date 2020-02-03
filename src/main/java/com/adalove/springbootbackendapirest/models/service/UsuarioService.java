package com.adalove.springbootbackendapirest.models.service;

import com.adalove.springbootbackendapirest.models.dao.IUsuarioDao;
import com.adalove.springbootbackendapirest.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    private final IUsuarioDao usuarioDao;
    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUserName(userName);

        if(usuario==null){
            logger.error("Error en el loggin: no existe El usuario en el sistema");
            throw new UsernameNotFoundException("Error en el loggin: no existe El usuario en el sistema");

        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> {
                    return new SimpleGrantedAuthority(role.getNombre());
                }).peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getUserName(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);

    }
}
