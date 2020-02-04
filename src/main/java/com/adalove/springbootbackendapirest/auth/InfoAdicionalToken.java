package com.adalove.springbootbackendapirest.auth;

import com.adalove.springbootbackendapirest.models.entity.Usuario;
import com.adalove.springbootbackendapirest.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private IUsuarioService usuarioService;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Usuario usuario = usuarioService.findByUserApellidoHabilitado("Guinard",true);

        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional: ", "Hola Datos add:  " + authentication.getName());
        info.put("info_adicional2: ", usuario.getApellido());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
