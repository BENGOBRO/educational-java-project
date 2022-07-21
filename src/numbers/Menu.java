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
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println("");
    }

    public static void getRequest() {
        System.out.println("Enter a request: ");
    }

    private static void getCharacteristics(Numbers number) {
        System.out.printf("Properties of %d \n", number.getNumber());
        System.out.printf("buzz: %s \n", number.isBuzz());
        System.out.printf("duck: %s \n", number.isDuck());
        System.out.printf("palindromic: %s \n", number.isPalindromic());
        System.out.printf("gapful: %s \n", number.isGapful());
        System.out.printf("spy: %s \n", number.isSpy());
        System.out.printf("square: %s \n", number.isSquare());
        System.out.printf("sunny: %s \n", number.isSunny());
        System.out.printf("even: %s \n", number.isEven());
        System.out.printf("odd: %s \n", !number.isEven());
        System.out.printf("jumping: %s \n", number.isJumping());
        System.out.printf("happy: %s \n", number.isHappy());
        System.out.printf("sad: %s \n", !number.isHappy());
        System.out.println("");
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
            if (number.isJumping()) {
                types.add("jumping");
            }
            if (number.isHappy()) {
                types.add("happy");
            } else {
                types.add("sad");
            }
            result += String.join(", ", types);
            System.out.println(result);
        }
    }

    public static void getNumber(String[] line) {
        long num = Long.parseLong(line[0]);
        long amount = Long.parseLong(line[1]);
        List<Properties> allProperties = new ArrayList<>();
        List<Boolean> isDeletedProperties = new ArrayList<>();

        Properties property;
        int amountOfDeletedProperties = 0;
        for (int i = 2; i < line.length; i++) {
            isDeletedProperties.add(line[i].contains("-"));
            if (isDeletedProperties.get(i - 2)) {
                property = Properties.valueOf(line[i].substring(1).toLowerCase());
                amountOfDeletedProperties++;
            } else {
                property = Properties.valueOf(line[i].toLowerCase());
            }
            allProperties.add(property);
        }

        int i = 0;
        while (amount > 0) {
            boolean exit = false;
            int count = 0;
            number = new Numbers(num + i);
            for (int j = 0; j < allProperties.size(); j++) {
                if (exit) {
                    break;
                }
                Properties userProperty = allProperties.get(j);
                boolean isDeleted = isDeletedProperties.get(j);
                switch (userProperty) {
                    case buzz:
                        if (number.isBuzz()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isBuzz()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case duck:
                        if (number.isDuck()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isDuck()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case palindromic:
                        if (number.isPalindromic()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isPalindromic()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case gapful:
                        if (number.isGapful()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isGapful()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case spy:
                        if (number.isSpy()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isSpy()){
                            exit = true;
                            count = -100;
                        }
                        break;
                    case even:
                        if (number.isEven()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isEven()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case odd:
                        if (!number.isEven()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && number.isEven()){
                            exit = true;
                            count = -100;
                        }
                        break;
                    case square:
                        if (number.isSquare()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isSquare()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case sunny:
                        if (number.isSunny()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isSunny()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case jumping:
                        if (number.isJumping()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isJumping()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case happy:
                        if (number.isHappy()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && !number.isHappy()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                    case sad:
                        if (!number.isHappy()) {
                            if (!isDeleted) {
                                count++;
                            } else {
                                exit = true;
                                count = -100;
                            }
                        } else if (!isDeleted && number.isHappy()) {
                            exit = true;
                            count = -100;
                        }
                        break;
                }
            }
            if (count == allProperties.size() - amountOfDeletedProperties) {
                amount--;
                getNumber(num + i, 1);
            }
            i++;
        }

    }
}
