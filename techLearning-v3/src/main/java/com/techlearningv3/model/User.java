package com.techlearningv3.model;

import javax.persistence.*;

@Entity
//@Table(name = "usuarios")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(name = "nome", nullable = false) // Torna obrigatório
   private String nome;

   private String email;

   @Column(name = "senha", nullable = false)
   private String senha;

    public User(String _username, String _email, String _password) {
        this.nome = _username;
        this.email = _email;
        this.senha = _password;
    }
    public User(){}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email;}

  //  public String getCpf() {return cpf;}
  //  public void setCpf(String cpf) {this.cpf = cpf;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

 //   public Status getStatus() {return status;}
 //   public void setStatus(Status status) {this.status = status;}

    @Override
    public String toString() {
       return
           "Usuario [" +
           "id=" + id +
           ", email=" + email  +
           ", username=" + nome +
           ", password=" + senha +
             Professor.class.toString() +
           "]";
    }

     public String toStringProfessor() {
         return
             "Usuario [" +
                 "id=" + id +
                 ", email=" + email  +
                 ", username=" + nome +
                 ", password=" + senha +
                 Professor.class.toString() +
                 "]";
     }

    public String toStringAluno() {
        return
            "Usuario [" +
                "id=" + id +
                ", email=" + email  +
                ", username=" + nome +
                ", password=" + senha +
                Aluno.class.toString() +
                "]";
    }

}
