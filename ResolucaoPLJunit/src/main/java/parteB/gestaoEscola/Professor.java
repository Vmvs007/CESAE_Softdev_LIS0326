package parteB.gestaoEscola;

import java.util.ArrayList;

class Professor {
    private int idProfessor;
    private String nome;
    private String especialidade;
    private String email;
    private String telefone;

    public Professor(int idProfessor, String nome, String especialidade, String email, String telefone) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}