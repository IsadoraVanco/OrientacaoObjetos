package Exercicios.Listas.Banco;

/*
Crie duas subclasses de ContaBancaria: ContaCorrente e ContaPoupanca.
Na classe ContaPoupanca, inclua o seguinte atributo:
• diaRendimento: int;
Na classe ContaPoupanca, inclua o seguinte método:
• calcularNovoSaldo: recebe como parâmetro a taxa de rendimento e atualiza o saldo;
 */
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaPoupanca extends ContaBancaria {
    private int diaRendimento = 0;

    public void calcularNovoSaldo(double taxaRendimento){
        BigDecimal novoSaldo = this.getSaldo().add(this.getSaldo().multiply(BigDecimal.valueOf(taxaRendimento)));

        this.setSaldo(novoSaldo);
        System.out.println("Novo saldo: R$" + this.getSaldo().setScale(2, RoundingMode.HALF_UP).toString());
    }
}

