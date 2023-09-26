/*
Representa um funcionário de uma empresa.
 */
public class Funcionario {
    private String nome;
    private double salario;
    private static double valeRefeicao = 200;

    /*
    Construtor inicializa uma nova instância.
     */
    public Funcionario(String nome){
        this.nome = nome;
        this.salario = 1500;
    }

    /*
    Recebe um valor em porcentagem para o reajuste do vale refeição;
     */
    public static void ajustaValeRefeicao(float porcentagem){
        valeRefeicao += valeRefeicao * (porcentagem / 100);
    }

    /*
    Redefine o valor do Vale Refeição.
     */
    public static void setValeRefeicao(double valor){
        valeRefeicao = valor;
    }

    /*
    Retorna o valor do Vale Refeição.
     */
    public static double getValeRefeicao(){
        return valeRefeicao;
    }

    /*
    Define o nome do funcionário.
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /*
    Retorna o nome do funcionário.
     */
    public String getNome(){
        return this.nome;
    }

    /*
    Redefine o salário do funcionário.
     */
    public void setSalario(double salario){
        this.salario = salario;
    }

    /*
    Retorna o salário do funcionário.
     */
    public double getSalario(){
        return this.salario;
    }

}
