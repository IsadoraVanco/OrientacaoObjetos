/*
Classe para métodos úteis e gerais
 */
import java.util.Scanner;

public class Tools {
    public static int leInteiro(String texto){
        int input;
        Scanner scan = new Scanner(System.in);

        System.out.print(texto);
        input = scan.nextInt();

        return input;
    }

    public static double leDouble(String texto){
        double input;
        Scanner scan = new Scanner(System.in);

        System.out.print(texto);
        input = scan.nextFloat();

        return input;
    }

    public static String leString(String texto){
        String input;
        Scanner scan = new Scanner(System.in);

        System.out.print(texto);
        input = scan.nextLine();

        return input;
    }
}
