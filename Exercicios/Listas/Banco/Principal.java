package Exercicios.Listas.Banco;

//Aluna: Isadora Vanço
/*
Faça uma classe Principal que permita ao usuário realizar as seguintes tarefas:
• Cadastrar a conta (poupança ou corrente) de um cliente;
• Sacar um valor da sua conta (poupança ou corrente);
• Atualizar uma conta poupança com o seu rendimento;
• Depositar um determinado valor na conta (poupança ou corrente);
• Mostrar o saldo de uma conta (poupança ou corrente);

Desafio: implementar busca de uma conta pelo seu número usando o método
indexOf(Object o) do LinkedList (Dica: olhar na documentação do Java como o
indexOf(Object o) é implementado).
 */
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class Principal {

    public static void imprimeMenu(){
        System.out.println("***********************************");
        System.out.println("**   BANCO DO COMPUTEIRO FELIZ   **");
        System.out.println("**                               **");
        System.out.println("**  Escolha uma opção:           **");
        System.out.println("**                               **");
        System.out.println("** [0] Cadastrar nova conta      **");
        System.out.println("** [1] Sacar                     **");
        System.out.println("** [2] Extrato                   **");
        System.out.println("** [3] Depositar                 **");
        System.out.println("** [4] Atualizar conta poupança  **");
        System.out.println("** [5] Encerrar                  **");
        System.out.println("***********************************");
    }

    public static int leInteiro(String texto){
        int input;
        Scanner scan = new Scanner(System.in);

        System.out.print(texto);
        input = scan.nextInt();

        return input;
    }

    public static double leDouble(String texto){
        double input;
        Scanner scan = new Scanner(System.in);

        System.out.print(texto);
        input = scan.nextFloat();

        return input;
    }

    public static String leString(String texto){
        String input;
        Scanner scan = new Scanner(System.in);

        System.out.print(texto);
        input = scan.nextLine();

        return input;
    }

    public static boolean ehPoupanca(){
        String resposta;

        Scanner scan = new Scanner(System.in);

        System.out.print("**  É conta Poupança? (S/N): ");
        resposta = scan.nextLine();

        return Objects.equals(resposta, "S");
    }

    public static void main(String[] args){
        ContaBancaria poupanca = new ContaPoupanca();
        ContaBancaria corrente = new ContaCorrente();
        ContaBancaria tipoConta = poupanca;

        int comando = 0;

        do{
            //Imprime o menu de opções
            imprimeMenu();

            //Lê o comando
            comando = leInteiro("**  Comando: ");

            //Verifica se é conta Poupança ou Corrente
            if(comando == 0 || comando == 2 || comando == 3){
                if(ehPoupanca()){
                    tipoConta = poupanca;
                }else{
                    tipoConta = corrente;
                }
            }

            switch (comando) {
                case 0 -> { //Cadastrar nova conta
                    //Pergunta o nome do cliente e número da conta
                    String cliente = leString("** Qual o nome para a conta? ");
                    String conta = leString("** Qual o número da conta? ");

                    tipoConta.setCliente(cliente);
                    tipoConta.setNumeroConta(conta);

                    System.out.println("Conta " + conta + " cadastrada com o titular " + cliente);
                }
                case 1 -> { //Sacar

                    if(ehPoupanca()){
                        double valor = leDouble("** Valor para sacar: R$");

                        poupanca.sacar(new BigDecimal(valor));
                    }else{
                        double valor = leDouble("** Valor para sacar: R$");

                        corrente.sacar(new BigDecimal(valor));
                    }
                }
                case 2 -> { //Extrato
                    System.out.println("Saldo da conta: R$" + tipoConta.getSaldo().toString());
                }
                case 3 -> { //Depositar
                    double valor = 0;
                    while(valor <= 0){
                        valor = leDouble("** Valor para depósito: R$");
                    }

                    tipoConta.depositar(new BigDecimal(valor));
                }
                case 4 -> { //Atualizar conta poupança
                    double rendimento = 0.02;

                    ((ContaPoupanca) poupanca).calcularNovoSaldo(rendimento);
                }
                case 5 -> {
                    //Encerra o sistema
                    System.out.println(">> Obrigada por utilizar o nosso sistema! Até a próxima :)");
                }
                default -> {
                    System.out.println(">> Comando inválido. Digite novamente!");
                }
            }

        }while(comando != 5);

    }
}
