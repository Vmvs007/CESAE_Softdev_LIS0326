package parteB.gestaoBiblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    Livro livro1;
    Livro livro2;
    Livro livro3;
    Livro livro4;

    Biblioteca biblioteca1;
    Biblioteca biblioteca2;

    @BeforeEach
    void setUp() {
        livro1 = new Livro("Heads First: Java", "Joaquim", 2010, 600);
        livro2 = new Livro("Heads First: Python", "Joaquim", 2008, 550);
        livro3 = new Livro("Grimm Brothers", "António", 1990, 300);
        livro4 = new Livro("Carochinha", "Ana", 2000, 20);

        biblioteca1 = new Biblioteca();
        biblioteca2 = new Biblioteca();
    }

    @Test
    public void bibliotecaCriadaSemLivrosTest() {
        assertEquals(0, biblioteca1.contarLivros());
        assertEquals(0, biblioteca2.contarLivros());
    }

    @Test
    public void contarLivrosTest() {
        biblioteca1.adicionarLivro(livro1);

        assertEquals(1, biblioteca1.contarLivros());

        biblioteca1.adicionarLivro(livro3);
        biblioteca1.adicionarLivro(livro4);

        assertEquals(3, biblioteca1.contarLivros());
    }

    @Test
    public void adicionarLivroTest() {
        biblioteca1.adicionarLivro(livro1);

        assertEquals(1, biblioteca1.contarLivros());
        assertEquals(livro1, biblioteca1.pesquisarLivroPorTitulo("Heads First: Java"));
        assertEquals(livro1, biblioteca1.obterLivrosDisponiveis().getFirst());

        biblioteca1.adicionarLivro(livro2);

        assertEquals(2, biblioteca1.contarLivros());
        assertEquals(livro2, biblioteca1.pesquisarLivroPorTitulo("Heads First: Python"));
    }

    @Test
    public void pesquisarLivroPorTituloExistenteTest() {
        biblioteca1.adicionarLivro(livro1);
        assertEquals(livro1, biblioteca1.pesquisarLivroPorTitulo("Heads First: Java"));

        biblioteca1.adicionarLivro(livro2);
        assertEquals(livro2, biblioteca1.pesquisarLivroPorTitulo("Heads First: Python"));
    }

    @Test
    public void pesquisarLivroPorTituloInexistenteTest() {
        biblioteca1.adicionarLivro(livro1);
        biblioteca1.adicionarLivro(livro2);

        assertNull(biblioteca1.pesquisarLivroPorTitulo("Biblia"));
        assertNull(biblioteca1.pesquisarLivroPorTitulo("3 Patinhos"));
        assertNull(biblioteca1.pesquisarLivroPorTitulo("Carochinha"));
    }
}