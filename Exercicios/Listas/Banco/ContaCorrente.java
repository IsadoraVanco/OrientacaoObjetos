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
    private BigDecimal limite = new BigDecimal(100);

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
        }else{
            this.setSaldo(novoSaldo);
            System.out.println("Novo saldo: R$" + novoSaldo.setScale(2, RoundingMode.HALF_UP).toString());
        }
    }

}
