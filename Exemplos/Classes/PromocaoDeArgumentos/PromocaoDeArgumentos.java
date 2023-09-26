import java.lang.Math;

public class PromocaoDeArgumentos{
    public double retornaMinimo(double a, double b){
        return Math.min((int) a, (int) b);
    }

    public static void main(String[] args){
        int a = 3, b = 5;

        System.out.printf("a ^2: %d %nb ^2: %d %n", Math.pow(a, 2), Math.pow(b, 2)));

        System.out.printf("O menor número é %d %n", retornaMinimo(a, b));
        System.out.printf("O menor número é %d %n", retornaMinimo(10.3, 0.5));
    }
}