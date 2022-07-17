package numbers;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    static Numbers number;

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
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println("");
    }

    public static void getRequest() {
        System.out.println("Enter a request: ");
    }

    private static void getCharacteristics(Numbers number) {
        System.out.println("Properties of " + number.getNumber());
        System.out.println("buzz: " + number.isBuzz());
        System.out.println("duck: " + number.isDuck());
        System.out.println("palindromic: " + number.isPalindromic());
        System.out.println("gapful: " + number.isGapful());
        System.out.println("spy: " + number.isSpy());
        System.out.println("square: " + number.isSquare());
        System.out.println("sunny: " + number.isSunny());
        System.out.println("even: " + number.isEven());
        System.out.println("odd: " + !number.isEven());
    }

    public static void getNumber(long num) {
        number = new Numbers(num);
        getCharacteristics(number);
    }

    public static void getNumber(long num, long amount) {
        for (int i = 0; i < amount; i++) {
            String result = (num + i) + " is ";
            List<String> types = new ArrayList<>();
            number = new Numbers(i + num);
            if (number.isBuzz()) {
                types.add("buzz");
            }
            if (number.isDuck()) {
                types.add("duck");
            }
            if (number.isPalindromic()) {
                types.add("palindromic");
            }
            if (number.isGapful()) {
                types.add("gapful");
            }
            if (number.isEven()) {
                types.add("even");
            } else {
                types.add("odd");
            }
            if (number.isSpy()) {
                types.add("spy");
            }
            if (number.isSquare()) {
                types.add("square");
            }
            if (number.isSunny()) {
                types.add("sunny");
            }
            result += String.join(", ", types);
            System.out.println(result);
        }
    }

    public static void getNumber(long num, long amount, String property) {
        Properties userProperty = Properties.valueOf(property.toLowerCase());
        int i = 0;
        while (amount > 0) {
            number = new Numbers(num + i);
            switch (userProperty) {
                case buzz:
                    if (number.isBuzz()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
                case duck:
                    if (number.isDuck()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
                case palindromic:
                    if (number.isPalindromic()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
                case gapful:
                    if (number.isGapful()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
                case spy:
                    if (number.isSpy()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
                case even:
                    if (number.isEven()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
                case odd:
                    if (!number.isEven()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
                case square:
                    if (number.isSquare()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
                case sunny:
                    if (number.isSunny()) {
                        amount--;
                        getNumber(num + i, 1);
                    }
                    break;
            }
            i++;
        }
    }

    public static void getNumber(long num, long amount, String property1, String property2) {
        Properties userProperty1 = Properties.valueOf(property1.toLowerCase());
        Properties userProperty2 = Properties.valueOf(property2.toLowerCase());
        Properties[] userProperties = {userProperty1, userProperty2};

        int i = 0;
        while (amount > 0) {
            int count = 0;
            number = new Numbers(num + i);
            for (Properties userProperty: userProperties) {
                switch (userProperty) {
                    case buzz:
                        if (number.isBuzz()) {
                            count++;
                        }
                        break;
                    case duck:
                        if (number.isDuck()) {
                            count++;
                        }
                        break;
                    case palindromic:
                        if (number.isPalindromic()) {
                            count++;
                        }
                        break;
                    case gapful:
                        if (number.isGapful()) {
                            count++;
                        }
                        break;
                    case spy:
                        if (number.isSpy()) {
                            count++;
                        }
                        break;
                    case even:
                        if (number.isEven()) {
                            count++;
                        }
                        break;
                    case odd:
                        if (!number.isEven()) {
                            count++;
                        }
                        break;
                    case square:
                        if (number.isSquare()) {
                            count++;
                        }
                        break;
                    case sunny:
                        if (number.isSunny()) {
                            count++;
                        }
                        break;
                }
            }
            if (count == 2) {
                amount--;
                getNumber(num + i, 1);
            }
            i++;
        }

    }
}
