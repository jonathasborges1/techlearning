package com.techlv4.model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Professor")
public class Professor extends Usuario{
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    public Professor(String nome, String email, String senha, Especialidade esp) {
        super(nome,email,senha);
        this.especialidade = esp;
    }

}
