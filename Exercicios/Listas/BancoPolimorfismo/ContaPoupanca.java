import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaPoupanca extends ContaBancaria {

    private int diaRendimento = 0;
    private static int quantidadeContas = 0;

    // *** MÉTODOS BÁSICOS ***

    public ContaPoupanca(){
        quantidadeContas++;
    }

    public void cadastrar(String cliente){
        this.cadastrar(cliente, quantidadeContas);

        System.out.println("Conta poupança de número " + this.getNumeroConta() + "\nregistrada no titular " + cliente);
    }

    // *** MÉTODOS POUPANÇA ***

    public void calcularNovoSaldo(double taxaRendimento){
        // Recebe a taxa em decimal
        BigDecimal saldoAtual = this.getSaldo();
        BigDecimal novoSaldo = saldoAtual.add(saldoAtual.multiply(BigDecimal.valueOf(taxaRendimento)));

        this.setSaldo(novoSaldo);
        System.out.println("Novo saldo: R$" + novoSaldo.setScale(2, RoundingMode.HALF_UP).toString());
    }

}