package Exemplos.ClassesAbstratas.ContaBancaria;

import java.math.BigDecimal;

public abstract class ContaBancaria{
    private BigDecimal saldo;

    public void setSaldo(BigDecimal saldo){
        this.saldo = saldo;
    }

    public BigDecimal getSaldo(){
        return this.saldo;
    }

    public abstract void sacar(BigDecimal valor);
    
    public void depositar(BigDecimal valor){
        this.saldo = this.saldo.add(valor);
    }
}