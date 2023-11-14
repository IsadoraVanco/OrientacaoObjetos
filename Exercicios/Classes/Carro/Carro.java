/*
Construa um programa com os seguintes requisitos:

– O programa deve ter uma classe “Carro” com os seguintes
atributos: marca e modelo;
– A classe Carro deve ter um método que recebe como
parâmetro a velocidade atual do carro e retorna qual deve
ser a marcha utilizada;
– o programa deve conter uma classe main na qual o usuário
vai informar os dados do carro (marca e modelo) e a
velocidade. O programa vai imprimir na tela os dados do
carro e a marcha adequada.
*/
public class Carro{
    private String marca, modelo;

    /*
    Recebe a velocidade atual do carro e retorna qual deve 
    ser a marcha a ser utilizada.    
    */
    public int defineMarcha(int velocidade){
        int marcha = 0;

        if(velocidade >= 100){
            marcha = 5;
        }else if(velocidade >= 80){
            marcha = 4;
        }else if(velocidade >= 60){
            marcha = 3;
        }else if(velocidade >= 40){
            marcha = 2;
        }else{
            marcha = 1;
        }

        return marcha;
    }

    /*
    Define o valor do atributo marca do objeto Carro.
    */
    public void setMarca(String marca){
        this.marca = marca;
    }

    /*
    Retorna o valor do atributo marca do objeto Carro.
    */
    public String getMarca(){
        return this.marca;
    }

    /*
    Define o valor do atributo modelo do objeto Carro.
    */
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    /*
    Retorna o valor do atributo marca do objeto Carro.
    */
    public String getModelo(){
        return this.modelo;
    }
}