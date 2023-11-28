package Exercicios.Listas.BancoInterface;
/*
Crie duas classes que implementam ContaBancaria: ContaCorrente e ContaPoupanca.
Na classe ContaCorrente, inclua os seguintes atributos:
• cliente: String;
• numeroConta: String;
• saldo: BigDecimal;
• limite: BigDecimal;
Na classe ContaCorrente, crie os seguintes métodos:
• sacar (implementação do método previsto na interface ContaBancaria): o valor do saque pode
ser maior que o saldo disponível, mas deve respeitar o limite previsto para a conta;
• depositar (implementação do método previsto na interface ContaBancaria
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente implements ContaBancaria{

    private String cliente;
    private String numeroConta;
    private BigDecimal saldo;
    private BigDecimal limite = new BigDecimal(1000);;
    private static int quantidadeContas = 0;

    public ContaCorrente(){
        quantidadeContas++;
    }

    public String getNumeroConta(){
        return  this.numeroConta;
    }

    public void sacar(double valor){
        BigDecimal novoSaldo = this.saldo.subtract(BigDecimal.valueOf(valor));
        BigDecimal limiteSaldo = novoSaldo.add(this.limite);

        if(limiteSaldo.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("Limite excedido. Operação não aprovada");
            System.out.println("Seu saldo atual: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
        }else{
            this.saldo = novoSaldo;
            System.out.println("Novo saldo: R$" + novoSaldo.setScale(2, RoundingMode.HALF_UP).toString());
        }
        System.out.println("Limite da conta: R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void depositar(double valor){
        if(BigDecimal.valueOf(valor).compareTo(BigDecimal.ZERO) < 0 || BigDecimal.valueOf(valor).compareTo(BigDecimal.ZERO) == 0){
            System.out.println("Valor inválido para depósito");
        }else{
            this.saldo = this.saldo.add(BigDecimal.valueOf(valor));
            System.out.println("Novo saldo: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
        }
        System.out.println("Limite da conta: R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void extrato(){
        System.out.println("Saldo atual: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("Limite da conta: R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void cadastrar(String cliente){
        int conta = quantidadeContas++;

        this.cliente = cliente;
        this.numeroConta = String.format("%07d", conta);

        System.out.println("Conta corrente de número " + String.format("%07d", conta) + "\nregistrada no titular " + cliente);
        System.out.println("Você possui um limite de R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }

}
