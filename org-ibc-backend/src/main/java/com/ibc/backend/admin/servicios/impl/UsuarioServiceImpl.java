package com.ibc.backend.admin.servicios.impl;

import com.ibc.backend.admin.modelo.Usuario;
import com.ibc.backend.admin.modelo.UsuarioRol;
import com.ibc.backend.admin.repositorios.RolRepository;
import com.ibc.backend.admin.repositorios.UsuarioRepository;
import com.ibc.backend.admin.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
    	System.out.println("usuarioLocal = "+usuario.getUsername());
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        try {
        	
       System.out.println("usuarioLocal = "+usuarioLocal);
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
            	System.out.println("rol = "+usuarioRol.getRol());
                rolRepository.save(usuarioRol.getRol());
                
            }
        	System.out.println("rol ===11 ");
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            System.out.println("rol ===112 "+usuarioRoles);
            System.out.println("rol ===1124 "+usuario);
            usuarioLocal = usuarioRepository.save(usuario);
            System.out.println("rol ===113 "+usuario);
        }
        }catch (Exception ex) {
        	ex.printStackTrace();
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

}