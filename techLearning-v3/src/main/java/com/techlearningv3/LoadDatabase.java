package com.techlearningv3;

import com.techlearningv3.model.Especialidade;
import com.techlearningv3.model.Professor;
import com.techlearningv3.model.User;
import com.techlearningv3.repository.UsuarioRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


public class LoadDatabase implements CommandLineRunner {
    final Logger logger = LogManager.getLogger(TechLearningv3Application.class);

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Instanciando Objetos no h2" );
        System.out.println(args);
        // save a couple of customers
        repository.save(new Professor("lucas", "lucas@gmail.com", "123", Especialidade.MATEMATICA));
        //repository.save(new Professor("pedro", "pedro@gmail.com", "321", Especialidade.FISICA));
        //repository.save(new Aluno("joao", "joao@gmail.com", "321", null));

        // fetch all customers
        logger.info("Professores e Alunos Encontrados com função findAll():");
        logger.info("-------------------------------");
        for (User customer : repository.findAll()) {
            logger.info(customer.toStringProfessor());
            logger.info(customer.toStringAluno());
        }
        logger.info("");

        // fetch an individual customer by ID
        User customer = repository.findById(1L).get();
        logger.info("Professores e Alunos  Encontrados com função findOne(1L):");
        logger.info("--------------------------------");
        logger.info(customer.toStringProfessor());
        logger.info(customer.toStringAluno());
        logger.info("");
    }
}
