package Exercicios.Listas.BancoInterface;
/*
Crie uma classe denominada ContaInvestimento. Ela deve implementar as interfaces ContaBancaria
e Tributavel. Inclua os seguintes atributos nesta classe:
• cliente: String;
• numeroConta: String;
• saldo: BigDecimal;
Na classe ContaInvestimento, crie os seguintes métodos:
• sacar (implementação do método previsto na interface ContaBancaria): só deve permitir o
saque caso o saldo resultante seja maior ou igual a zero;
• depositar (implementação do método previsto na interface ContaBancaria)
• calcularNovoSaldo: recebe como parâmetro a taxa de rendimento e atualiza o saldo;
• calcularTaxaAdministração: recebe como parâmetro a taxa de rendimento e deve retornar um
valor correspondente a 1% do lucro obtido com o rendimento;
• calcularTributo (implementação do método previsto na interface Tributavel): recebe como
parâmetro a taxa de rendimento e deve retornar um valor correspondente a 0,5% do lucro
obtido com o rendimento;
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento implements ContaBancaria, Tributavel{

    private String cliente;
    private String numeroConta;
    private BigDecimal saldo;

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

    public void calcularNovoSaldo(double taxaRendimento){
        BigDecimal novoSaldo = this.saldo.add(this.saldo.multiply(BigDecimal.valueOf(taxaRendimento)));

        this.saldo = novoSaldo;
        System.out.println("Novo saldo: R$" + this.saldo.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public BigDecimal calcularTaxaAdministracao(double taxaRendimento){
        BigDecimal rendimento = this.saldo.multiply(BigDecimal.valueOf(taxaRendimento));

        return rendimento.multiply(BigDecimal.valueOf(0.01));
    }

    public BigDecimal calcularTributo(BigDecimal taxaRendimento){
        BigDecimal rendimento = this.saldo.multiply(taxaRendimento);

        return rendimento.multiply(BigDecimal.valueOf(0.005));
    }
}
