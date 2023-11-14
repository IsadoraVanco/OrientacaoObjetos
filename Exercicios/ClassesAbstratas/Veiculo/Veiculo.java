package Exercicios.ClassesAbstratas.Veiculo;

public abstract class Veiculo {
    
    public String marca;
    public String modelo;
    public String placa;

    public void licenciar(){
        System.out.println("Veiculo " + marca + " " + modelo + " com a placa " + placa + " está licenciado!");
    }

    public abstract int obterNrEixos();

}
