package mundoVeloz;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private int cv;
    private int cc;
    private double consumoL100Km;
    private double velocidadeMax;
    private double velocidadeAtual;
    private boolean travaoMao;

    public Carro(String marca, String modelo, String cor, int cv, int cc, double consumoL100Km, double velocidadeMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.cv = cv;
        this.cc = cc;
        this.consumoL100Km = consumoL100Km;
        this.velocidadeMax = velocidadeMax;
        this.velocidadeAtual = 0;
        this.travaoMao = true;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public double getConsumoL100Km() {
        return consumoL100Km;
    }

    public void setConsumoL100Km(double consumoL100Km) {
        this.consumoL100Km = consumoL100Km;
    }

    public double getVelocidadeMax() {
        return velocidadeMax;
    }


    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public boolean isTravado() {
        return travaoMao;
    }

    public void puxarTravaoMao() {
        this.travaoMao = true;
    }

    public void destravamosTravaoMao() {
        this.travaoMao = false;
    }

    public double calcularConsumoDistancia(double distancia) {
        return (this.consumoL100Km * distancia) / 100;
    }

    public void acelerar(double aceleracao) {

        if (!this.travaoMao) {
            if (aceleracao > 0) {
                this.velocidadeAtual += aceleracao;
            }

            if (this.velocidadeAtual > this.velocidadeMax) {
                this.velocidadeAtual = this.velocidadeMax;
            }
        }

    }

    public void travar(double travagem) {

        if (travagem > 0) {
            this.velocidadeAtual -= travagem;
        }

        if (this.velocidadeAtual < 0) {
            this.velocidadeAtual = 0;
        }

    }


    @Override
    public String toString() {
        if (this.travaoMao) {
            return this.marca + " | " + this.modelo + " | Vel. Atual: " + this.velocidadeAtual + " Km/h | Travado";
        } else {
            return this.marca + " | " + this.modelo + " | Vel. Atual: " + this.velocidadeAtual + " Km/h | Destravado";
        }

    }
}
