package Exercicios.Listas.BancoInterface;
/*
Crie uma interface ContaBancaria.
Inclua os seguintes métodos:
• sacar;
• depositar;
 */

public interface ContaBancaria {

    public void sacar(double valor);

    public void depositar(double valor);

    public void extrato();

    public String getNumeroConta();
}
