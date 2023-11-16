package Exemplos.Interfaces.ContaBancaria;

import java.math.BigDecimal;

public class ContaCorrente implements IContaBancaria{

    public BigDecimal saldo;
    public BigDecimal limite;
    
    void sacar(BigDecimal valor){
        BigDecimal saldoTotal = this.saldo.add(this.limite);
        
        if (valor.compareTo(saldoTotal) <= 0){
            this.saldo = this.saldo.subtract(valor);
        }
    }
}
