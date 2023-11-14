/*
 * b) Escreva um trecho para um programa principal que crie um 
 * objeto do tipo Veiculo (e seja instância da classe Carro) 
 * e invoque o método obterNrEixos().
 */

package Exercicios.ClassesAbstratas.Veiculo;

public class Main {
    
    public static void main(String args[]){
        Veiculo v = new Carro();

        System.out.println("O numero de eixos de um carro é " + v.obterNrEixos());
    }
}
