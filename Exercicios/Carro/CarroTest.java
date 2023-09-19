// Teste para a classe Carro
import java.util.Scanner;

public class CarroTest{
    public static void main(String args[]){
        int velocidade;
        String marca, modelo;

        Carro carro = new Carro();
        Scanner scan = new Scanner(System.in);

        System.out.printf("Marca inicial do carro: %s %n", carro.getMarca());
        System.out.printf("Modelo inicial do carro: %s %n", carro.getModelo());

        System.out.print("Qual a marca do carro? ");
        marca = scan.nextLine();
        carro.setMarca(marca);
        
        System.out.print("Qual o modelo do carro? ");
        modelo = scan.nextLine();
        carro.setModelo(modelo);

        System.out.print("Qual a velocidade que o carro está? ");
        velocidade = scan.nextInt();
        System.out.printf("A marcha adequada para esta velocidade é %d %n", carro.defineMarcha(velocidade));

        System.out.printf("Marca final do carro: %s %n", carro.getMarca());
        System.out.printf("Modelo final do carro: %s %n", carro.getModelo());
    }
}