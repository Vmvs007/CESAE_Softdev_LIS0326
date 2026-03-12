package mundoVeloz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarroTest {

    Carro carro1;
    Carro carro2;

    @BeforeEach
    void setUp() {
        carro1 = new Carro("Fiat", "Uno", "Vermelho", 75, 1000, 10, 130);
        carro2 = new Carro("BMW", "120", "Preto", 120, 1400, 8, 180);
    }

    @Test
    public void testCalcularConsumoDistanciaValida() {
        assertEquals(55, carro1.calcularConsumoDistancia(550));
        assertEquals(0.1, carro1.calcularConsumoDistancia(1));

        assertEquals(16, carro2.calcularConsumoDistancia(200));
    }

    @Test
    public void testCalcularConsumoDistanciaZero() {
        assertEquals(0, carro1.calcularConsumoDistancia(0));
        assertEquals(0, carro2.calcularConsumoDistancia(0));
    }

    @Test
    public void testCalcularConsumoDistanciaNegativa() {

    }

    @Test
    public void testAcelerarCarroDestravado() {
        carro1.destravamosTravaoMao();
        carro2.destravamosTravaoMao();

        assertEquals(0, carro1.getVelocidadeAtual());
        assertEquals(0, carro2.getVelocidadeAtual());

        carro1.acelerar(50);
        carro2.acelerar(20);

        assertEquals(50, carro1.getVelocidadeAtual());
        assertEquals(20, carro2.getVelocidadeAtual());

        carro1.acelerar(20);
        carro2.acelerar(100);

        assertEquals(70, carro1.getVelocidadeAtual());
        assertEquals(120, carro2.getVelocidadeAtual());
    }

    @Test
    public void testAcelerarCarroTravado() {
        carro1.acelerar(30);
        carro2.acelerar(10);

        assertEquals(0, carro1.getVelocidadeAtual());
        assertEquals(0, carro2.getVelocidadeAtual());

    }

    @Test
    public void testAcelerarVelocidadeNegativa() {

    }

    @Test
    public void testAcelerarUltrapassaVelocidadeMaxima() {

    }
}