package com.techlv4.model;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", nullable = false) // Torna obrigatório
    private String nome;

    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

}
