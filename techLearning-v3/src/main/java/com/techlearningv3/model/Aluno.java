package com.techlearningv3.model;

import java.util.List;

public class Aluno extends User{

    private List<Especialidade> materias;
    public Aluno(String _username, String _email, String _password,List<Especialidade> _materias){
        super(_username,_email,_password);
        this.materias = _materias;
    }

    public Aluno(){}

    @Override
    public String toString() {
        return "Aluno{" +
            "materias=" + materias +
            '}';
    }
}
