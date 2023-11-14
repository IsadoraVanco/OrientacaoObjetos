package Exemplos.ClassesAbstratas.ContaBancaria;

import java.math.BigDecimal;

public class Main {
    
    public static void main(String args[]){
        ContaBancaria contaBancaria = new ContaPoupanca();
        contaBancaria.depositar(new BigDecimal(200));
        contaBancaria.sacar(new BigDecimal(100));
    }
}
