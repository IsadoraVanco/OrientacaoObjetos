//Aluna: Isadora Vanço
/*
Neste exercício, você deve implementar o mesmo programa que foi
desenvolvido no ListaEx4 (Interfaces). No entanto, ele deve usar
apenas classes abstratas. Além disso, você deve fazer uso de polimorfismo,
ou seja, deve haver apenas uma lista de contas bancárias.
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Principal {

    public static void imprimeMenu(){
        System.out.println("****************************************");
        System.out.println("**  BANCO DO COMPUTEIRO TRABALHADOR   **");
        System.out.println("**                                    **");
        System.out.println("** Escolha uma opção:                 **");
        System.out.println("**                                    **");
        System.out.println("** [1] Cadastrar nova conta           **");
        System.out.println("** [2] Sacar                          **");
        System.out.println("** [3] Depositar                      **");
        System.out.println("** [4] Extrato                        **");
        System.out.println("** [5] Atualizar conta poupança       **");
        System.out.println("** [6] Calcular tributos              **");
        System.out.println("** [7] Calcular taxa de administração **");
        System.out.println("** [0] Encerrar                       **");
        System.out.println("****************************************");
    }

    public static int leTipoConta(){
        int resposta = 0;

        while(resposta < 1 || resposta > 3){
            System.out.println("** Selecione o tipo da conta: ");
            System.out.println("** [1] Poupança");
            System.out.println("** [2] Corrente");
            System.out.println("** [3] De investimento");
            resposta = Tools.leInteiro("** Opção: ");
        }

        return resposta;
    }

    // Procura em uma lista o número da conta
    public static <ContaBancaria> int procuraConta(ArrayList<ContaBancaria> listaConta, int numeroConta, int tipoConta){
        int indice = -1;
        String numeroContaConvertido = ContaCorrente.converteNumeroConta(numeroConta);

        //Procura a conta na lista de contas
        for (int i = 0; i < listaConta.size(); i++) {
            ContaBancaria conta = listaConta.get(i);

            if(conta instanceof ContaPoupanca && tipoConta == 1){
                if (Objects.equals(((ContaPoupanca) conta).getNumeroConta(), numeroContaConvertido)) {
                    indice = i;
                    break;
                }
            }else if(conta instanceof ContaCorrente && tipoConta == 2){
                if (Objects.equals(((ContaCorrente) conta).getNumeroConta(), numeroContaConvertido)) {
                    indice = i;
                    break;
                }
            }else if(conta instanceof ContaInvestimento && tipoConta == 3) {
                if (Objects.equals(((ContaInvestimento) conta).getNumeroConta(), numeroContaConvertido)) {
                    indice = i;
                    break;
                }
            }
        }

        return indice;
    }

    public static void main(String[] args){
        ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();

        int comando, tipoConta, numeroConta;
        int  indice = 0;
        double rendimento = 0;

        do{
            //Imprime o menu de opções
            imprimeMenu();

            //Lê o comando
            comando = Tools.leInteiro("** Comando: ");

            tipoConta = 0;

            //Le o tipo da conta para cadastro, saque, deposito e extrato
            if(comando >= 1 && comando <= 4){
                tipoConta = leTipoConta();
            }

            // Le o numero da conta em todos comandos, exceto no cadastro
            if(comando > 1 && comando <= 7){
                if(comando == 5){
                    tipoConta = 1;
                }else if(comando == 6 || comando == 7){
                    tipoConta = 3;
                }

                numeroConta = Tools.leInteiro("** Qual o número da conta? ");

                indice = procuraConta(contas, numeroConta, tipoConta);

                if(indice < 0){
                    System.out.println(">> Conta não encontrada");
                    continue;
                }
            }

            // Le a taxa de rendimento para atualizar a conta poupança, calcular taxa e tributo
            if(comando >= 5 && comando <= 7){
                rendimento = 0;
                while(rendimento <= 0){
                    rendimento = Tools.leDouble("** Qual o rendimento (em decimal)? ");
                }
            }

            switch (comando) {
                case 0 -> {
                    //Encerra o sistema
                    System.out.println(">> Obrigada por utilizar o nosso sistema! Até a próxima :)");
                }
                case 1 -> { //Cadastrar nova conta
                    //Pergunta o nome do cliente
                    String cliente = Tools.leString("** Qual o nome para a conta? ");

                    //Verifica o tipo da conta e adiciona na lista
                    if(tipoConta == 1){ //Poupança

                        ContaPoupanca novaConta = new ContaPoupanca();
                        novaConta.cadastrar(cliente);
                        contas.add(novaConta);
                    }else if(tipoConta == 2){ //Corrente

                        ContaCorrente novaConta = new ContaCorrente();
                        novaConta.cadastrar(cliente);
                        contas.add(novaConta);
                    }else{ //Conta de investimento

                        ContaInvestimento novaConta = new ContaInvestimento();
                        novaConta.cadastrar(cliente);
                        contas.add(novaConta);
                    }
                }
                case 2 -> { //Sacar
                    double valor = Tools.leDouble("** Valor para sacar: R$");

                    contas.get(indice).sacar(valor);
                }
                case 3 -> { //Depositar
                    double valor = Tools.leDouble("** Valor para depositar: R$");

                    contas.get(indice).depositar(valor);
                }
                case 4 -> { //Extrato

                    contas.get(indice).extrato();
                }
                case 5 -> { //Atualizar conta poupança
                    ((ContaPoupanca) contas.get(indice)).calcularNovoSaldo(rendimento);
                }
                case 6 -> { //Calcular tributos
                    ((ContaInvestimento) contas.get(indice)).calcularTributo(BigDecimal.valueOf(rendimento));
                }
                case 7 -> { //Calcular taxa de administração
                    ((ContaInvestimento) contas.get(indice)).calcularTaxaAdministracao(rendimento);
                }
                default -> {
                    System.out.println(">> Comando inválido. Digite novamente!");
                }
            }

        }while(comando != 0);

    }
}
