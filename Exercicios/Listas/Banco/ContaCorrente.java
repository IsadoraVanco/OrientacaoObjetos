package Exercicios.Listas.Banco;

/*
Crie duas subclasses de ContaBancaria: ContaCorrente e ContaPoupanca.
Na classe ContaCorrente, inclua o seguinte atributo:
• limite: BigDecimal;
Na classe ContaCorrente, redefina o método sacar, permitindo saldos negativos desde que não
superem o limite;
 */
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente extends ContaBancaria{
    private static int quantidadeContas = 0;
    private BigDecimal limite = new BigDecimal(1000);

    public void ContaCorrente(){
        quantidadeContas++;
    }
    public void ContaCorrente(String cliente){
        setCliente(cliente);
        quantidadeContas++;
    }

    public void setLimite(BigDecimal limite){
        this.limite = limite;
    }

    public BigDecimal getLimite(){
        return this.limite;
    }

    @Override
    public void sacar(BigDecimal valor){
        BigDecimal novoSaldo = this.getSaldo().subtract(valor);
        BigDecimal limiteSaldo = novoSaldo.add(this.limite);

        if(limiteSaldo.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("Limite excedido. Operação não aprovada");
            System.out.println("Seu saldo atual: R$" + this.getSaldo().setScale(2, RoundingMode.HALF_UP).toString());
        }else{
            this.setSaldo(novoSaldo);
            System.out.println("Novo saldo: R$" + novoSaldo.setScale(2, RoundingMode.HALF_UP).toString());
        }
        System.out.println("Limite da conta: R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void cadastrar(String cliente){
        // De 0 a 5555555
        int conta = quantidadeContas;

        if(conta > 5555555){
            System.out.println("Limite de contas poupança atingido");
        }else{
            this.setCliente(cliente);
            this.setNumeroConta(String.format("%07d", conta));

            System.out.println("Conta corrente de númmero " + String.format("%07d", conta) + "\nregistrada no titular " + cliente);
            System.out.println("Você possui um limite de R$" + this.getLimite().setScale(2, RoundingMode.HALF_UP).toString());
        }
    }

    @Override
    public void extrato(){
        System.out.println("Saldo atual: R$" + this.getSaldo().setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("Limite da conta: R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }

}
