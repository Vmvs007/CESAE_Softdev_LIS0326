package parteA.gestaoProduto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    Produto produto1;
    Produto produto2;

    @BeforeEach
    void setUp() {
        produto1 = new Produto("Bolachas",2,15,"Alimentação","Triunfo");
        produto2 = new Produto("TV LG 75",1500,0,"Tecnologia","LG");
    }

    @Test
    public void calcularPrecoFinalTest(){
        assertEquals(2,produto1.calcularPrecoFinal());
        assertEquals(1500,produto2.calcularPrecoFinal());
    }

    @Test
    public void actualizarPrecoBaseValidoTest(){
        produto1.actualizarPrecoBase(2.1);

        assertEquals(2.1,produto1.calcularPrecoFinal());

        // CONTROLO
        produto2.actualizarPrecoBase(1450);

        assertEquals(1450,produto2.calcularPrecoFinal());
    }

    @Test
    public void aplicarDescontoValidoTest(){
        produto1.aplicarDesconto(0.1);
        assertEquals(1.8,produto1.calcularPrecoFinal());

        produto2.aplicarDesconto(0.5);
        assertEquals(750,produto2.calcularPrecoFinal());
    }


}