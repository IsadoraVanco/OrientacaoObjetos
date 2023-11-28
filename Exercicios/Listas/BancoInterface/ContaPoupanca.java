package Exercicios.Listas.BancoInterface;
/*
Na classe ContaPoupanca, inclua os seguinte atributos:
• cliente: String;
• numeroConta: String;
• saldo: BigDecimal;
• diaRendimento: int;
Na classe ContaPoupanca, crie os seguintes métodos:
• sacar (implementação do método previsto na interface ContaBancaria): só deve permitir o
saque caso o saldo resultante seja maior ou igual a zero;
• depositar (implementação do método previsto na interface ContaBancaria)
• calcularNovoSaldo: recebe como parâmetro a taxa de rendimento e atualiza o saldo;
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaPoupanca implements ContaBancaria {

    private String cliente;
    private String numeroConta;
    private BigDecimal saldo = BigDecimal.ZERO;
    private int diaRendimento = 0;

    private static int quantidadeContas = 0;

    public ContaPoupanca(){
        quantidadeContas++;
    }

    public String getNumeroConta(){
        return this.numeroConta;
    }

    public void sacar(double valor){
        if(this.saldo.subtract(BigDecimal.valueOf(valor)).compareTo(BigDecimal.ZERO) < 0){
            System.out.println("Valor indisponível no saldo. Operação não aprovada");
            System.out.println("Saldo atual: R$" + this.saldo.toString());
        }else{
            this.saldo = this.saldo.subtract(BigDecimal.valueOf(valor));
            System.out.println("Novo saldo: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
        }
    }

    public void depositar(double valor){
        //valor <= 0
        if(BigDecimal.valueOf(valor).compareTo(BigDecimal.ZERO) < 0 || BigDecimal.valueOf(valor).compareTo(BigDecimal.ZERO) == 0){
            System.out.println("Valor inválido para depósito");
        }else{
            this.saldo = this.saldo.add(BigDecimal.valueOf(valor));
            System.out.println("Novo saldo: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
        }
    }

    public void extrato(){
        System.out.println("Saldo atual: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
    }

    // Recebe a taxa em decimal
    public void calcularNovoSaldo(double taxaRendimento){
        BigDecimal novoSaldo = this.saldo.add(this.saldo.multiply(BigDecimal.valueOf(taxaRendimento)));

        this.saldo = novoSaldo;
        System.out.println("Novo saldo: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void cadastrar(String cliente){
        int conta = quantidadeContas;

        this.cliente = cliente;
        this.numeroConta = String.format("%07d", conta);

        System.out.println("Conta poupança de número " + String.format("%07d", conta) + "\nregistrada no titular " + cliente);
    }

}

