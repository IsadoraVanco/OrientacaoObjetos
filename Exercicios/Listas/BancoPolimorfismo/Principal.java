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
        System.out.println("**    BANCO DO COMPUTEIRO CANSADO     **");
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
    public static <T extends ContaBancaria> int procuraConta(ArrayList<T> listaConta, int numeroConta){
        int indice = -1;

        //Procura a conta na lista de contas
        for (int i = 0; i < listaConta.size(); i++) {
            T conta = listaConta.get(i);

            if (Objects.equals(conta.getNumeroConta(), String.format("%07d", numeroConta))) {
                indice = i;
                break;
            }
        }

        return indice;
    }

    public static void main(String[] args){
        ArrayList<ContaPoupanca> poupanca = new ArrayList<ContaPoupanca>();
        ArrayList<ContaCorrente> corrente = new ArrayList<ContaCorrente>();
        ArrayList<ContaInvestimento> investimento = new ArrayList<ContaInvestimento>();

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
                if((tipoConta == 1 || comando == 5) && poupanca.isEmpty()){
                    System.out.println(">> Não existem contas poupança cadastradas");
                    continue;
                }else if(tipoConta == 2 && corrente.isEmpty()){
                    System.out.println(">> Não existem contas corrente cadastradas");
                    continue;
                }else if((tipoConta == 3 || comando == 6 || comando == 7) && investimento.isEmpty()){
                    System.out.println(">> Não existem contas de investimento cadastradas");
                    continue;
                }else{
                    numeroConta = Tools.leInteiro("** Qual o número da conta? ");
                }

                if(tipoConta == 1 || comando == 5){ //Poupança
                    indice = procuraConta(poupanca, numeroConta);
                }else if(tipoConta == 2){ //Corrente
                    indice = procuraConta(corrente, numeroConta);
                }else if(tipoConta == 3 || comando == 6 || comando == 7){ //Conta de investimento
                    indice = procuraConta(investimento, numeroConta);
                }

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

                        poupanca.add(novaConta);
                    }else if(tipoConta == 2){ //Corrente
                        ContaCorrente novaConta = new ContaCorrente();
                        novaConta.cadastrar(cliente);

                        corrente.add(novaConta);
                    }else{ //Conta de investimento
                        ContaInvestimento novaConta = new ContaInvestimento();
                        novaConta.cadastrar(cliente);

                        investimento.add(novaConta);
                    }
                }
                case 2 -> { //Sacar
                    double valor = Tools.leDouble("** Valor para sacar: R$");

                    //Verifica o tipo da conta e saca
                    if(tipoConta == 1){ //Poupança
                        poupanca.get(indice).sacar(valor);
                    }else if(tipoConta == 2){ //Corrente
                        corrente.get(indice).sacar(valor);
                    }else{ //Conta de investimento
                        investimento.get(indice).sacar(valor);
                    }
                }
                case 3 -> { //Depositar
                    double valor = Tools.leDouble("** Valor para depositar: R$");

                    //Verifica o tipo da conta e deposita
                    if(tipoConta == 1){ //Poupança
                        poupanca.get(indice).depositar(valor);
                    }else if(tipoConta == 2){ //Corrente
                        corrente.get(indice).depositar(valor);
                    }else{ //Conta de investimento
                        investimento.get(indice).depositar(valor);
                    }
                }
                case 4 -> { //Extrato

                    //Verifica o tipo da conta e mostra o saldo
                    if(tipoConta == 1){ //Poupança
                        poupanca.get(indice).extrato();
                    }else if(tipoConta == 2){ //Corrente
                        corrente.get(indice).extrato();
                    }else{ //Conta de investimento
                        investimento.get(indice).extrato();
                    }
                }
                case 5 -> { //Atualizar conta poupança
                    poupanca.get(indice).calcularNovoSaldo(rendimento);
                }
                case 6 -> { //Calcular tributos
                    investimento.get(indice).calcularTributo(BigDecimal.valueOf(rendimento));
                }
                case 7 -> { //Calcular taxa de administração
                    investimento.get(indice).calcularTaxaAdministracao(rendimento);
                }
                default -> {
                    System.out.println(">> Comando inválido. Digite novamente!");
                }
            }

        }while(comando != 0);

    }
}
