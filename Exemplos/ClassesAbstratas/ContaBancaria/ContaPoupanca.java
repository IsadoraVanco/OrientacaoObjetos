package Exemplos.ClassesAbstratas.ContaBancaria;

import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria{
    
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(this.getSaldo()) <= 0){
            BigDecimal novoSaldo = this.getSaldo().subtract(valor);
            this.setSaldo(novoSaldo);
        } else {
            System.out.println("não há saldo suficiente");
        }
    }

}