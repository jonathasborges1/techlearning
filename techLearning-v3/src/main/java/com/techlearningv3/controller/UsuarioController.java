package com.techlearningv3.controller;

import com.techlearningv3.exception.UserNotFoundException;
import com.techlearningv3.model.User;
import com.techlearningv3.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/api")
@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @ResponseStatus(HttpStatus.OK)
    public List<User> buscaUsuarios() { return usuarioService.listaCliente(); } // Retorna uma lista de usuários

    @ResponseStatus(HttpStatus.CREATED)
    public User cadastrarUsuario(@RequestBody User novoUsuario){
        return usuarioService.salvar(novoUsuario);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    User busca1Usuario(@PathVariable Long id) {
        return usuarioService.buscarPorId(id).orElseThrow(
            () -> new UserNotFoundException(id)); // se o cliente não exitir ele trata com Exception
    }

    @PutMapping("/employees/{id}")
    public void atualizaUsuario(@RequestBody User novoUsuario, @PathVariable("id") Long id) {
        usuarioService.buscarPorId(id)
            .map(usuarioBase -> {
                modelMapper.map(novoUsuario,usuarioBase);
                usuarioService.salvar(usuarioBase);
                return Void.TYPE;
            }).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.removerPorId(id);
    }
}
