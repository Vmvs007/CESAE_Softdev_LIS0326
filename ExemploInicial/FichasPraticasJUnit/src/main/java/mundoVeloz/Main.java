package mundoVeloz;

public class Main {
    public static void main(String[] args) {

        Carro carro1 = new Carro("Fiat","Uno","Vermelho",75,1000,10,130);
        Carro carro2 = new Carro("BMW","120","Preto",120,1400,8,180);
        Carro carro3 = new Carro("Mata","Velhos","Azul",40,500,3.5,120);

        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(carro3);

        System.out.println("\n_______________________________________________________________________________________\n");

        carro1.acelerar(100);
        carro2.acelerar(200);
        carro3.travar(20);

        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(carro3);

        System.out.println("\n_______________________________________________________________________________________\n");

        carro1.destravamosTravaoMao();
        carro2.destravamosTravaoMao();
        carro3.destravamosTravaoMao();

        carro1.acelerar(100);
        carro2.acelerar(200);
        carro3.travar(20);

        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(carro3);

        System.out.println("\n_______________________________________________________________________________________\n");

        System.out.println("Consumo do "+carro1.getMarca()+": "+carro1.calcularConsumoDistancia(250));
    }
}
