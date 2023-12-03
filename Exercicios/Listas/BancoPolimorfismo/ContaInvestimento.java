import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento extends Tributavel{

    private static int quantidadeContas = 0;

    // *** CONSTRUTOR E MÉTODOS BÁSICOS ***

    public ContaInvestimento(){
        quantidadeContas++;
    }

    public void cadastrar(String cliente){
        int conta = quantidadeContas;

        this.cadastrar(cliente, conta);

        System.out.println("Conta de investimento de número " + this.getNumeroConta() + "\nregistrada no titular " + cliente);
    }

    // *** MÉTODOS DE INVESTIMENTO ***

    public void calcularNovoSaldo(double taxaRendimento){
        BigDecimal saldoAtual = this.getSaldo();
        BigDecimal novoSaldo = saldoAtual.add(saldoAtual.multiply(BigDecimal.valueOf(taxaRendimento)));

        this.setSaldo(novoSaldo);
        System.out.println("Novo saldo: R$" + this.getSaldo().setScale(2, RoundingMode.HALF_UP).toString());
    }

    public BigDecimal calcularTaxaAdministracao(double taxaRendimento){
        BigDecimal rendimento = this.getSaldo().multiply(BigDecimal.valueOf(taxaRendimento));
        rendimento = rendimento.multiply(BigDecimal.valueOf(0.01));
        System.out.println("A Taxa Administração (1%) é correspondente a R$" + rendimento.setScale(2, RoundingMode.HALF_UP).toString());

        return rendimento;
    }

    public BigDecimal calcularTributo(BigDecimal taxaRendimento){
        BigDecimal rendimento = this.getSaldo().multiply(taxaRendimento);
        rendimento = rendimento.multiply(BigDecimal.valueOf(0.005));
        System.out.println("O Tributo (0,5%) é correspondente a R$" + rendimento.setScale(2, RoundingMode.HALF_UP).toString());

        return rendimento;
    }
}
