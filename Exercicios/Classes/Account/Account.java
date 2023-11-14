// exemplo de uma Conta de Banco
public class Account {
    // O atributo name é privado, ou seja, ele não pode ser modificado por outras classes
    private String name; // instance variable
    private double saldo; // O saldo da conta

    // constructor initializes name with parameter name
    public Account(String name, double saldo) { // constructor name is class name
        this.name = name;
        this.saldo = saldo;
    }
        
    //Nome de métodos: começam com um verbo e letra minúscula e as outras palavras em CamelCase

    // method to set the name in the object
    public void setName(String name) {
        this.name = name; // store the name
    }

    // method to retrieve the name from the object
    public String getName() {
        return name; // return value of name to caller
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo(){
        return this.saldo;
    }
}