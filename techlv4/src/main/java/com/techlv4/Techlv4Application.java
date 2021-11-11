package com.techlv4;

import com.techlv4.model.Usuario;
import com.techlv4.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Techlv4Application implements CommandLineRunner{

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Techlv4Application.class, args);
    }

    @Autowired
    private UsuarioRepository ur;

    @Override
    public void run(String... args) throws Exception{
        Usuario u1 = new Usuario(1,"pedro","pedro@gmail.com","123");
        Usuario u2 = new Usuario(2,"joao","joao@gmail.com","321");
        ur.saveAll(Arrays.asList(u1,u2));
    }

}
