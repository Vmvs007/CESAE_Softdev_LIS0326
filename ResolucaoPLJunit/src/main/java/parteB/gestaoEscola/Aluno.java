package parteB.gestaoEscola;

import java.util.ArrayList;

/**
 * Classe base que representa um aluno.
 */
class Aluno {
    protected int numeroAluno;
    protected String nome;
    protected int anoNascimento;
    protected String habilitacaoLiteraria;
    protected String nacionalidade;
    protected String morada;
    protected String email;
    protected String telefone;
    protected ArrayList<Double> notas;

    /**
     * Construtor do Aluno
     */
    public Aluno(int numeroAluno, String nome, int anoNascimento, String habilitacaoLiteraria,
                 String nacionalidade, String morada, String email, String telefone) {
        this.numeroAluno = numeroAluno;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.habilitacaoLiteraria = habilitacaoLiteraria;
        this.nacionalidade = nacionalidade;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.notas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova nota ao aluno.
     */
    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    /**
     * Calcula a média das notas.
     */
    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (int i = 0; i < notas.size(); i++) {
            soma += notas.get(i);
        }
        return soma / notas.size();
    }

    /**
     * Retorna a nota mais alta.
     */
    public double notaMaisAlta() {
        if (notas.isEmpty()) {
            return 0;
        }
        double max = notas.get(0);
        for (int i = 1; i < notas.size(); i++) {
            if (notas.get(i) > max) {
                max = notas.get(i);
            }
        }
        return max;
    }

    /**
     * Retorna a nota mais baixa.
     */
    public double notaMaisBaixa() {
        if (notas.isEmpty()) {
            return 0;
        }
        double min = notas.get(0);
        for (int i = 1; i < notas.size(); i++) {
            if (notas.get(i) > min) {
                min = notas.get(i);
            }
        }
        return min;
    }


    public String getNome() {
        return nome;
    }

    public int getNumeroAluno() {
        return numeroAluno;
    }
}