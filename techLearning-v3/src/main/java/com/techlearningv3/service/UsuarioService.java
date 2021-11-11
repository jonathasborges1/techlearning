package com.techlearningv3.service;

import com.techlearningv3.model.User;
import com.techlearningv3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<User> listaCliente(){
        return usuarioRepository.findAll();
    }

    public User salvar(User cliente){
        return usuarioRepository.save(cliente);
    }

    public Optional<User> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public void removerPorId(Long id){
        usuarioRepository.deleteById(id);
    }
}
