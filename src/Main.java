import java.util.Scanner;

public class Main {
    static Numbers machine;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exit = false;
        greetUser();
        getInstructions();

        while (!exit) {
            getRequest();
            String[] line = scanner.nextLine().split(" ");
            int num = Integer.parseInt(line[0]);

            if (line.length > 1) {
                int amount = Integer.parseInt(line[1]);
                machine = new Numbers(amount);
                machine.checkNaturalNum();

                if (!machine.natural) {
                    notNaturalSecondNumber();
                    continue;
                }
                for (int i = 0; i < amount; i++) {
                    String result = (num + i) + " is ";
                    machine = new Numbers(i + num);
                    machine.checkNaturalNum();
                    if (machine.natural) {
                        checkCharacteristics();
                        if (machine.buzz) {
                            result += "buzz";
                        }
                        if (machine.duck && !machine.buzz) {
                            result += "duck";
                        } else {
                            result += ", duck";
                        }
                        if (machine.palindromic) {
                            result += ", palindromic";
                        }
                        if (machine.gapful) {
                            result += ", gapful";
                        }
                        if (machine.even) {
                            result += ", even";
                        } else {
                            result += ", odd";
                        }
                    } else {
                        notNaturalFirstNumber();
                        break;
                    }
                    System.out.println(result);
                }
                System.out.println("");
            } else {
                machine = new Numbers(num);
                machine.checkNaturalNum();

                if (machine.natural && !machine.exit) {
                    checkCharacteristics();
                    System.out.println("Properties of " + num);
                    getCharacteristics();
                } else if (machine.exit) {
                    exit = true;
                    System.out.println("Goodbye!");
                } else {
                    notNaturalFirstNumber();
                }
            }
        }
    }

    public static void greetUser() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("");
    }

    public static void getInstructions() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println("");
    }

    public static void getRequest() {
        System.out.println("Enter a request: ");
    }

    public static void getCharacteristics() {
        System.out.println("buzz: " + machine.buzz);
        System.out.println("duck: " + machine.duck);
        System.out.println("palindromic: " + machine.palindromic);
        System.out.println("gapful: " + machine.gapful);
        System.out.println("even: " + machine.even);
        System.out.println("odd: " + !machine.even);
        System.out.println("");
    }

    public static void checkCharacteristics() {
        machine.checkEvenNum();
        machine.checkBuzzNum();
        machine.checkDuckNum();
        machine.checkPalindromicNum();
        machine.checkGapfulNum();
    }

    public static void notNaturalFirstNumber() {
        System.out.println("The first parameter should be a natural number or zero.");
        System.out.println("");
    }

    public static void notNaturalSecondNumber() {
        System.out.println("The second parameter should be a natural number.");
        System.out.println("");
    }
}
