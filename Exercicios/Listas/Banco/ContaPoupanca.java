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

    private static int quantidadeContas = 0;

    public void ContaPoupanca(){
        quantidadeContas++;
    }

    public void atualizarSaldo(double taxaRendimento){
        BigDecimal novoSaldo = this.getSaldo().add(this.getSaldo().multiply(BigDecimal.valueOf(taxaRendimento)));

        this.setSaldo(novoSaldo);
        System.out.println("Novo saldo: R$" + this.getSaldo().setScale(2, RoundingMode.HALF_UP).toString());
    }

    public void cadastrar(String cliente){
        // De 5555556 a 9999999
        int conta = 5555556 + quantidadeContas;

        if(conta > 9999999){
            System.out.println("Limite de contas poupança atingido");
        }else{
            this.setCliente(cliente);
            this.setNumeroConta(String.format("%07d", conta));

            System.out.println("Conta poupança de númmero " + String.format("%07d", conta) + "\nregistrada no titular " + cliente);
        }
    }

}

