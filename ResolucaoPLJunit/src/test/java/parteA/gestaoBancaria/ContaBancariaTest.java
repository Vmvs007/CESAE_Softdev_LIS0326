package parteA.gestaoBancaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    ContaBancaria conta1;
    ContaBancaria conta2;
    ContaBancaria conta3;
    ContaBancaria conta4;
    ContaBancaria conta5;

    @BeforeEach
    void setUp() {
        conta1 = new ContaBancaria("Joaquim", 0, 2026, "PT", "Pt500011 123");
        conta2 = new ContaBancaria("Joana", 0, 2022, "PT", "Pt500033 335");
        conta3 = new ContaBancaria("António", 2000, 1999, "PT", "Pt500044 669");
        conta4 = new ContaBancaria("Deolinda", 550, 2001, "ES", "ES400011 333");
        conta5 = new ContaBancaria("José", 31, 2001, "ES", "ES400022 333");
    }

    @Test
    public void testComDerivacao() {
        conta5.aplicarRendimentoMensal(0.015);
        assertEquals(30.465, conta5.consultarSaldo(), 0.001);

    }

    @Test
    public void testConsultarSaldo() {
        assertEquals(0, conta1.consultarSaldo());
        assertEquals(2000, conta3.consultarSaldo());
    }

    @Test
    public void testDepositarValorPositivo() {
        conta1.depositar(150);
        assertEquals(150, conta1.consultarSaldo());

        conta2.depositar(1);
        assertEquals(1, conta2.consultarSaldo());

        conta3.depositar(600);
        assertEquals(2600, conta3.consultarSaldo());
    }

    @Test
    public void testDepositarZero() {
        assertThrows(IllegalArgumentException.class, () -> conta1.depositar(0));
        assertThrows(IllegalArgumentException.class, () -> conta3.depositar(0));
    }

    @Test
    public void testDepositarNegativo() {
        assertThrows(IllegalArgumentException.class, () -> conta1.depositar(-50));
        assertThrows(IllegalArgumentException.class, () -> conta3.depositar(-1));
    }


    @Test
    public void testLevantarValorValido() {
        conta3.levantar(2000);
        assertEquals(0, conta3.consultarSaldo());

        conta4.levantar(500);
        assertEquals(50, conta4.consultarSaldo());
    }

    @Test
    public void testLevantarValorSemSaldo() {
        conta1.levantar(75);
        assertEquals(0, conta1.consultarSaldo());

        conta3.levantar(2001);
        assertEquals(2000, conta3.consultarSaldo());

        conta4.levantar(1000);
        assertEquals(550, conta4.consultarSaldo());
    }

    @Test
    public void testLevantarZero() {
        assertThrows(IllegalArgumentException.class, () -> conta1.levantar(0));
        assertThrows(IllegalArgumentException.class, () -> conta3.levantar(0));
    }

    @Test
    public void testLevantarValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> conta1.levantar(-400));
        assertThrows(IllegalArgumentException.class, () -> conta3.levantar(-1));
    }

    @Test
    public void testTransferirValorValido() {
        conta3.transferir(conta1, 2000);
        assertEquals(0, conta3.consultarSaldo());
        assertEquals(2000, conta1.consultarSaldo());

        conta1.transferir(conta4, 1);
        assertEquals(1999, conta1.consultarSaldo());
        assertEquals(551, conta4.consultarSaldo());

        conta4.transferir(conta2, 51);
        assertEquals(500, conta4.consultarSaldo());
        assertEquals(51, conta2.consultarSaldo());
    }

    @Test
    public void testTransferirValorSemSaldo() {
        conta1.transferir(conta2, 1);
        assertEquals(0, conta1.consultarSaldo());
        assertEquals(0, conta2.consultarSaldo());

        conta3.transferir(conta4, 2001);
        assertEquals(2000, conta3.consultarSaldo());
        assertEquals(550, conta4.consultarSaldo());

        conta4.transferir(conta1, 5000);
        assertEquals(0, conta1.consultarSaldo());
        assertEquals(550, conta4.consultarSaldo());
    }

    @Test
    public void testTransferirParaOProprio() {
        assertThrows(IllegalArgumentException.class, () -> conta3.transferir(conta3, 50));
        assertThrows(IllegalArgumentException.class, () -> conta1.transferir(conta1, 0));
    }

    @Test
    public void testTransferirZero() {
        assertThrows(IllegalArgumentException.class, () -> conta1.transferir(conta3, 0));
        assertThrows(IllegalArgumentException.class, () -> conta4.transferir(conta2, 0));
    }

    @Test
    public void testTransferirNegativo() {
        assertThrows(IllegalArgumentException.class, () -> conta1.transferir(conta3, -50));
        assertThrows(IllegalArgumentException.class, () -> conta4.transferir(conta2, -1));
    }

    @Test
    public void testGerarResumoConta() {
        assertEquals("Titular: Joaquim, IBAN: Pt500011 123, País: PT, AnoCriação: 2026, Saldo: 0.0", conta1.gerarResumoConta());
        assertEquals("Titular: Deolinda, IBAN: ES400011 333, País: ES, AnoCriação: 2001, Saldo: 550.0", conta4.gerarResumoConta());
    }


}