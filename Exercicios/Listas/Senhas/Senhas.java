package Exercicios.Listas.Senhas;

import java.util.ArrayList;
import java.security.SecureRandom;

public class Senhas{
    //Fila de senhas
    private ArrayList<Integer> fila;
    //Número de senhas atendidas no total
    private int senhasAtendidas = 0;

    public Senhas(){
        this.fila = new ArrayList<Integer>();
    }

    public void emitir(){
        SecureRandom sorteador = new SecureRandom();

        //Sorteia uma senha
        int senha = sorteador.nextInt(0, 999);

        //Verifica se já existe na fila e sorteia denovo
        while(this.fila.contains(senha)){
            senha = sorteador.nextInt(0, 999);
        }

        //Adiciona na fila
        this.fila.add(senha);

        //Mostra a senha gerada
        System.out.printf("=> A nova senha é: %s%n", String.format("%03d", senha));
    }

    public void apagar(int senha){
        if(this.fila.isEmpty()){
            System.out.println("!!  A fila está vazia");
            return;
        }else if(!this.fila.contains(senha)){
            System.out.println("!! A senha não está na fila");
            return;
        }

        //Procura a senha na fila e apaga
        this.fila.remove((Integer) senha);
        System.out.println("=> Senha Removida com sucesso!");
    }

    public void atender(){
        if(this.fila.isEmpty()){
            System.out.println("!! A fila está vazia");
            return;
        }

        //Primeira senha da fila
        int senha = this.fila.get(0);

        System.out.printf("=> Senha a ser atendida: %s%n", String.format("%03d", senha));

        //Atende (retira) da fila a primeira senha
        this.fila.remove(0);
        senhasAtendidas++;
    }

    public void busca(int senha){
        if(this.fila.isEmpty()){
            System.out.println("!! A fila está vazia");
            return;
        }

        //Procura pela senha na fila
        int posicao = this.fila.indexOf((Integer) senha);

        if(posicao < 0){
            System.out.println("!! A senha não está na fila");
            return;
        }

        //Imprime a posição da senha na fila
        System.out.printf("=> A senha solicitada está na %da posição%n", posicao + 1);
    }

    public void imprime(){
        if(this.fila.isEmpty()){
            System.out.println("!! A fila está vazia ");
            return;
        }

        //Imprime toda a fila de senhas
        System.out.println("=> Fila completa:");
        for(Integer i : this.fila){
            System.out.printf("%s ", String.format("%03d", i));
        }
        System.out.println();
    }

    public int retornaTamanho(){
        //Retorna o tamanho da fila
        return this.fila.size();
    }

    public int retornaAtendidas(){
        //Retorna o número de senhas atendidas na fila
        return this.senhasAtendidas;
    }
}