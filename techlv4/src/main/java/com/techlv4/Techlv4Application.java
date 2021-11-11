package com.techlv4;

import com.techlv4.model.Especialidade;
import com.techlv4.model.Professor;
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
        Professor p3 = new Professor("tiago","tiago@gmail.com","456", Especialidade.INGLES);
        Professor p1 = new Professor();
        p1.setNome("joao"); p1.setEmail("joao@gmail.com"); p1.setSenha("123"); p1.setEspecialidade(Especialidade.FISICA);
        Professor p2 = new Professor();
        p2.setNome("pedro"); p2.setEmail("pedro@gmail.com"); p2.setSenha("321"); p2.setEspecialidade(Especialidade.MATEMATICA);
        //Professor p2 = new Professor("joao","joao@gmail.com","321", Especialidade.QUIMICA);
        //Usuario u2 = new Usuario(2,"joao","joao@gmail.com","321");
        ur.saveAll(Arrays.asList(p1,p2,p3));
    }
}
