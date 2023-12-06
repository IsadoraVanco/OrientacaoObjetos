import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente extends ContaBancaria{

    private BigDecimal limite = new BigDecimal(1000);;
    private static int quantidadeContas = 0;

    // *** MÉTODOS BÁSICOS ***

    public ContaCorrente(){
        quantidadeContas++;
    }

    @Override
    public void sacar(double valor){
        BigDecimal novoSaldo = this.getSaldo().subtract(BigDecimal.valueOf(valor));
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

    @Override
    public void depositar(double valor){
        super.depositar(valor);
        System.out.println("Limite da conta: R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }

    @Override
    public void extrato(){
        super.extrato();
        System.out.println("Limite da conta: R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void cadastrar(String cliente){
        this.cadastrar(cliente, quantidadeContas);

        System.out.println("Conta corrente de número " + this.getNumeroConta() + "\nregistrada no titular " + cliente);
        System.out.println("Você possui um limite de R$" + this.limite.setScale(2, RoundingMode.HALF_UP).toString());
    }
}
