package Exercicios.Listas.BancoInterface;

//Aluna: Isadora Vanço
/*
Faça uma classe Principal que permita ao usuário realizar as seguintes tarefas:
• Cadastrar a conta de um cliente;
• Sacar um valor da sua conta;
• Atualizar uma conta poupança com o seu rendimento;
• Depositar um determinado valor na conta;
• Mostrar o saldo de uma conta;
• Calcular os tributos de uma conta;
• Calcula a taxa de administração de uma conta investimento
 */
import java.util.ArrayList;
import java.util.Objects;

public class Principal {

    public static void imprimeMenu(){
        System.out.println("****************************************");
        System.out.println("**     BANCO DO COMPUTEIRO FELIZ      **");
        System.out.println("**                                    **");
        System.out.println("**  Escolha uma opção:                **");
        System.out.println("**                                    **");
        System.out.println("** [0] Cadastrar nova conta           **");
        System.out.println("** [1] Sacar                          **");
        System.out.println("** [2] Extrato                        **");
        System.out.println("** [3] Depositar                      **");
        System.out.println("** [4] Atualizar conta poupança       **");
        System.out.println("** [5] Calcular tributos              **");
        System.out.println("** [6] Calcular taxa de administração **");
        System.out.println("** [7] Encerrar                       **");
        System.out.println("****************************************");
    }

    public static boolean ehPoupanca(){
        String resposta = Tools.leString("**  É conta Poupança? (S/N): ");

        return Objects.equals(resposta.toUpperCase(), "S");
    }

    public static void main(String[] args){
        ArrayList<ContaPoupanca> poupanca = new ArrayList<ContaPoupanca>();
        ArrayList<ContaCorrente> corrente = new ArrayList<ContaCorrente>();

        int comando = 0;
        int numeroConta = 0;
        int indice;

        do{
            //Imprime o menu de opções
            imprimeMenu();

            //Lê o comando
            comando = Tools.leInteiro("**  Comando: ");

            indice = -1;

            //Procura o número da conta
            if(comando >= 1 && comando < 4){
                numeroConta = Tools.leInteiro("** Qual o número da conta? ");

                if(numeroConta > 5555555){ //Poupança
                    //Procura a conta na lista de contas poupança
                    for (int i = 0; i < poupanca.size(); i++) {
                        String conta = poupanca.get(i).getNumeroConta();

                        if (Objects.equals(conta, String.format("%07d", numeroConta))) {
                            indice = i;
                            break;
                        }
                    }
                }else{ //Corrente
                    //Procura a conta na lista de contas corrente
                    for (int i = 0; i < corrente.size(); i++) {
                        String conta = corrente.get(i).getNumeroConta();

                        if (Objects.equals(conta, String.format("%07d", numeroConta))) {
                            indice = i;
                            break;
                        }
                    }
                }

                if(indice == -1){
                    System.out.println(">> Conta não encontrada");
                    continue;
                }
            }

            switch (comando) {
                case 0 -> { //Cadastrar nova conta
                    //Pergunta o nome do cliente
                    String cliente = Tools.leString("** Qual o nome para a conta? ");

                    //Verifica se é conta Poupança ou Corrente
                    if(ehPoupanca()){
                        ContaPoupanca novaConta = new ContaPoupanca();
                        novaConta.cadastrar(cliente);

                        poupanca.add(novaConta);
                    }else{
                        ContaCorrente novaConta = new ContaCorrente();
                        novaConta.cadastrar(cliente);

                        corrente.add(novaConta);
                    }
                }
                case 1 -> { //Sacar
                    // Apenas número da conta

                    double valor = Tools.leDouble("** Valor para sacar: R$");

                    if(numeroConta > 5555555){ //Poupança
                        poupanca.get(indice).sacar(valor);
                    }else { //Corrente
                        corrente.get(indice).sacar(valor);
                    }
                }
                case 2 -> { //Extrato
                    // Apenas número da conta

                    if(numeroConta > 5555555){ //Poupança
                        poupanca.get(indice).extrato();
                    }else { //Corrente
                        corrente.get(indice).extrato();
                    }
                }
                case 3 -> { //Depositar
                    // Número e tipo da conta

                    double valor;

                    if(ehPoupanca()){ //Apenas para fins de simulação
                        valor = Tools.leDouble("** Valor para depósito (poupança): R$");
                        poupanca.get(indice).depositar(valor);
                    }else{
                        valor = Tools.leDouble("** Valor para depósito (corrente): R$");
                        corrente.get(indice).depositar(valor);
                    }
                }
                case 4 -> { //Atualizar conta poupança
                    // Apenas o número da conta

                    numeroConta = Tools.leInteiro("** Qual o número da conta? ");

                    //Procura a conta na lista de contas poupança
                    for (int i = 0; i < poupanca.size(); i++) {
                        String conta = poupanca.get(i).getNumeroConta();

                        if (Objects.equals(conta, String.format("%07d", numeroConta))) {
                            indice = i;
                            break;
                        }
                    }

                    if(indice == -1){
                        System.out.println(">> Conta poupança não encontrada");
                        continue;
                    }

                    double rendimento = Tools.leDouble("** Qual o rendimento (em decimal)? ");

                    poupanca.get(indice).calcularNovoSaldo(rendimento);
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
