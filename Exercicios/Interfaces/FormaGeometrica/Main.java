/*
b) Escreva um trecho para um programa principal que crie um
objeto do tipo FormaGeometrica (e seja instância da classe
Quadrado) e invoque o método obterNumeroLados().
*/
package Exercicios.Interfaces.FormaGeometrica;

public class Main {

    public static void main(String args[]){
        FormaGeometrica forma = new Quadrado();

        System.out.println("O numero de lados da figura: " + forma.obterNumeroLados());
    }
}
