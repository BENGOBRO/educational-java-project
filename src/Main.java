import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Numbers machine = new Numbers();

        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");

        while (!machine.exit) {
            System.out.println("");
            System.out.println("Enter a request: ");
            System.out.println("");
            long num = machine.inputData();

            machine.checkNaturalNum();

            if (machine.natural && !machine.exit) {
                machine.checkEvenNum();
                machine.checkBuzzNum();
                machine.checkDuckNum();
                machine.checkPalindromicNum();

                System.out.println("Properties of " + num);
                System.out.println("even: " + machine.even);
                System.out.println("odd: " + !machine.even);
                System.out.println("buzz: " + machine.buzz);
                System.out.println("duck: " + machine.duck);
                System.out.println("palindromic: " + machine.palindromic);
            } else if (machine.exit) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
    }
}
