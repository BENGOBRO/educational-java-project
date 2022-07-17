package numbers;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Menu.greetUser();
        Menu.getInstructions();
        while (!exit) {
            Menu.getRequest();
            String[] line = scanner.nextLine().split(" ");
            if (line.length == 1 && Checks.checkingString(line)) {
                long number = Long.parseLong(line[0]);
                if (number == 0) {
                    System.out.println("Goodbye!");
                    exit = true;
                } else {
                    Menu.getNumber(number);
                }
            } else if (line.length == 2 && Checks.checkingString(line)) {
                long number = Long.parseLong(line[0]);
                long amount = Long.parseLong(line[1]);
                Menu.getNumber(number, amount);
            } else if (line.length == 3 && Checks.checkingString(line)) {
                long number = Long.parseLong(line[0]);
                long amount = Long.parseLong(line[1]);
                String property = line[2];
                Menu.getNumber(number, amount, property);
            } else if (line.length == 4 && Checks.checkingString(line)) {
                long number = Long.parseLong(line[0]);
                long amount = Long.parseLong(line[1]);
                String property1 = line[2];
                String property2 = line[3];
                Menu.getNumber(number, amount, property1, property2);
            }
        }
    }
}
