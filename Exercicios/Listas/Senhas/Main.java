package Exercicios.Listas.Senhas;

import java.util.Objects;
import java.util.Scanner;

public class Main{

    public static void imprimeMenu(){
        System.out.println("***********************************");
        System.out.println("**     GERENCIADOR DE SENHAS     **");
        System.out.println("**                               **");
        System.out.println("**  Escolha uma opção:           **");
        System.out.println("**                               **");
        System.out.println("** [0] Emitir nova senha         **");
        System.out.println("** [1] Retira senha da fila      **");
        System.out.println("** [2] Atender senha             **");
        System.out.println("** [3] Buscar senha na fila      **");
        System.out.println("** [4] Imprimir fila             **");
        System.out.println("** [5] Encerrar atendimento      **");
        System.out.println("***********************************");

    }

    public static int leComando(){
        int comando;
        Scanner scan = new Scanner(System.in);

        System.out.print("**  Comando: ");
        comando = scan.nextInt();

        return comando;
    }

    public static int leSenha(){
        int senha;
        Scanner scan = new Scanner(System.in);

        System.out.print("**  Senha: ");
        senha = scan.nextInt();

        return senha;
    }

    public static boolean ehPreferencial(){
        String resposta;

        Scanner scan = new Scanner(System.in);

        System.out.print("**  É preferencial? (S/N): ");
        resposta = scan.nextLine();

        return Objects.equals(resposta, "S");
    }

    public static void main(String[] args){
        //Número de atendimentos preferenciais sequenciais
        int sequenciaPreferencial = 0;
        int comando, senha;

        Senhas filaComum = new Senhas();
        Senhas filaPreferencial = new Senhas();
        //Um ponteiro para a fila que será atendida
        Senhas filaAtendimento;

        do{
            //Imprime o menu de opções
            imprimeMenu();

            //Lê o comando
            comando = leComando();

            switch (comando) {
                case 0 -> {
                    //Verifica se é fila preferencial
                    if(ehPreferencial()){
                        filaAtendimento = filaPreferencial;
                    }else{
                        filaAtendimento = filaComum;
                    }

                    //Emite nova senha
                    filaAtendimento.emitir();
                }case 1 -> {
                    //Verifica se é fila preferencial
                    if(ehPreferencial()){
                        filaAtendimento = filaPreferencial;
                    }else{
                        filaAtendimento = filaComum;
                    }

                    //Lê a senha a ser retirada
                    senha = leSenha();

                    //Desiste da fila
                    filaAtendimento.apagar(senha);
                }case 2 -> {
                    if(filaComum.retornaTamanho() == 0 && filaPreferencial.retornaTamanho() == 0){
                        System.out.println(">> Não há filas para atender");
                    }else{
                        //Verifica se vai atender a fila preferencial
                        if ((sequenciaPreferencial < 2 && filaPreferencial.retornaTamanho() > 0)
                                || (filaComum.retornaTamanho() == 0)) {
                            System.out.println(">> Fila preferencial sendo atendida");
                            filaAtendimento = filaPreferencial;
                            sequenciaPreferencial++;
                        } else {
                            System.out.println(">> Fila comum sendo atendida");
                            sequenciaPreferencial = 0;
                            filaAtendimento = filaComum;
                        }

                        //Atende a primeira senha da fila
                        filaAtendimento.atender();
                    }
                }case 3 -> {
                    //Verifica se é fila preferencial
                    if(ehPreferencial()){
                        filaAtendimento = filaPreferencial;
                    }else{
                        filaAtendimento = filaComum;
                    }

                    //Lê a senha a ser retirada
                    senha = leSenha();

                    //Busca a posição que a senha está
                    filaAtendimento.busca(senha);
                }
                case 4 -> {
                    //Verifica se é fila preferencial
                    if(ehPreferencial()){
                        filaAtendimento = filaPreferencial;
                    }else{
                        filaAtendimento = filaComum;
                    }

                    //Imprime a fila
                    filaAtendimento.imprime();
                }
                case 5 -> {
                    //Mostra o total de senhas atendidas
                    System.out.printf(">> Total de senhas atendidas na preferencial: %d%n", filaPreferencial.retornaAtendidas());
                    System.out.printf(">> Total de senhas atendidas na comum: %d%n%n", filaComum.retornaAtendidas());

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