package Exercicios.Listas.Banco;

/*
Crie uma classe ContaBancaria.
Inclua os seguintes atributos:
• cliente: String;
• numeroConta: String;
• saldo: BigDecimal;
Inclua os seguintes métodos na classe ContaBancaria:
• sacar: não permitir que o saldo fique menor que zero;
• depositar;
 */
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaBancaria {
    private String cliente;
    private String numeroConta;
    private BigDecimal saldo = new BigDecimal(0);

    public void setSaldo(BigDecimal valor){
        this.saldo = valor;
    }

    public BigDecimal getSaldo(){
        return this.saldo;
    }

    public void setCliente(String cliente){
        this.cliente = cliente;
    }

    public void setNumeroConta(String numeroConta){
        this.numeroConta = numeroConta;
    }

    public void sacar(BigDecimal valor){
        if(this.saldo.subtract(valor).compareTo(BigDecimal.ZERO) < 0){
            System.out.println("Valor indisponível no saldo. Operação não aprovada");
            System.out.println("Saldo atual: R$" + this.saldo.toString());
        }else{
            this.saldo = this.saldo.subtract(valor);
            System.out.println("Novo saldo: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
        }
    }

    public void depositar(BigDecimal valor){
        this.saldo = this.saldo.add(valor);
        System.out.println("Novo saldo: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
    }
}
