package com.techlv4.controller;

import com.techlv4.model.Usuario;
import com.techlv4.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/v1")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> buscaUsuarios() { return usuarioService.listar(); } // Retorna uma lista de usuários

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrarUsuario(@RequestBody Usuario novoUsuario){
        return usuarioService.salvar(novoUsuario);
    }

    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    Usuario busca1Usuario(@PathVariable Long id) {
        return usuarioService.buscarPorId(id).orElseThrow(
            //() -> new UserNotFoundException(id)); // se o cliente não exitir ele trata com Exception
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

    @PutMapping("/usuarios/{id}")
    public void atualizaUsuario(@RequestBody Usuario novoUsuario, @PathVariable("id") Long id) {
        usuarioService.buscarPorId(id)
            .map(usuarioBase -> {
                modelMapper.map(novoUsuario,usuarioBase);
                usuarioService.salvar(usuarioBase);
                return Void.TYPE;
            }).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.removerPorId(id);
    }

}
