import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ContaBancaria {

    private String numeroConta;
    private String cliente;
    private BigDecimal saldo = BigDecimal.ZERO;

    // *** MÉTODOS BÁSICOS ***

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

    public void cadastrar(String cliente, int numeroConta){
        this.cliente = cliente;
        this.numeroConta = String.format("%07d", numeroConta);
    }

    // *** GETTERS E SETTERS ***

    public String getNumeroConta(){
        return this.numeroConta;
    }

    public BigDecimal getSaldo(){
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo){
        this.saldo = saldo;
    }

    public void setCliente(String cliente){
        this.cliente = cliente;
    }

    public void setNumeroConta(String numeroConta){
        this.numeroConta = numeroConta;
    }
}
