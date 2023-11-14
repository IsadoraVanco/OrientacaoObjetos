import java.util.Scanner;

/*
Adicionar na classe o atributo saldo.
*/
public class AccountTest {
    public static void main(String[] args) {
        // create a Scanner object to obtain input from the command window
        Scanner input = new Scanner(System.in);

        // create an Account object and assign it to myAccount
        Account myAccount = new Account("Jane", 0);

        // display initial value of name (null)
        System.out.printf("Initial name is: %s%n%n", myAccount.getName());
        System.out.printf("Initial saldo is: %s%n%n", myAccount.getSaldo());

        // prompt for and read name
        System.out.println("Please enter the name:");
        String theName = input.nextLine(); // read a line of text
        
        myAccount.setName(theName); // put theName in myAccount
        System.out.println(); // outputs a blank line

        System.out.print("Enter the value: ");
        double saldo = input.nextDouble();
        myAccount.setSaldo(saldo);
        
        // display the name stored in object myAccount
        System.out.printf("Name in object myAccount is:%n%s%n", myAccount.getName());
        System.out.printf("Saldo in object myAccount is:%n%s%n", myAccount.getSaldo());
    }
}