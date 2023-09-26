public class Gerente {
    private String nome;
    private double salario = 3000;

    /*
    Construtor de um Gerente, que por por padrão, recebe o nome
    "Gerente".
     */
    public void Gerente(){
        this.nome = "Gerente";
    }

    /*
    Construtor de um Gerente, que inicia com um nome passado por parametro.
     */
    public void Gerente(String nome){
        this.nome = nome;
    }

    /*
    Redefine o salário do gerente.
     */
    public void setSalario(double salario){
        this.salario = salario;
    }

    /*
    Retorna o salário do gerente.
     */
    public double getSalario(){
        return this.salario;
    }

    /*
    Retorna o nome do gerente.
     */
    public String getNome(){
        return this.nome;
    }

    /*
    Redefine o nome do gerente.
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /*
    Aumenta o salário do gerente em uma taxa fixa de 10%.
     */
    public void aumentaSalario(){
        this.salario += this.salario * 0.1;
    }

    /*
    Aumenta o salário do gerente em uma taxa vaiada passada
    por parâmetro.
     */
    public void aumentaSalario(double taxa){
        this.salario += this.salario * (taxa /100);
    }
}
