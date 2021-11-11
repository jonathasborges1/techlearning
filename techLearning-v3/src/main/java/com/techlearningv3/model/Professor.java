package com.techlearningv3.model;


public class Professor extends User {

    private Especialidade especialidade;

    public Professor(String nome, String email, String senha, Especialidade esp){
        super(nome,email,senha);
        this.especialidade = esp;
    }

    public Professor(){}

    @Override
    public String toString() {
        return "Professor{" +
            "especialidade=" + especialidade +
            '}';
    }
}
