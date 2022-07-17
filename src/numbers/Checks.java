package numbers;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Checks {

    private static void raiseFirstParameterError() {
        System.out.println("The first parameter should be a natural number or zero.");
        System.out.println("");
    }

    private static void raiseSecondParameterError() {
        System.out.println("The second parameter should be a natural number.");
        System.out.println("");
    }

    private static void raisePropertyError(String property) {
        System.out.println("The property [" + property.toUpperCase() + "] is wrong.");
        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
        System.out.println("");
    }

    private static void raisePropertyError(String property1, String property2) {
        System.out.println("The properties [" + property1.toUpperCase() + ", " + property2.toUpperCase() + "] are wrong.");
        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
        System.out.println("");
    }

    private static void raiseImpossibleCombination(String property1, String property2) {
        System.out.println("The request contains mutually exclusive properties: [" + property1.toUpperCase() + ", " + property2.toUpperCase() + "] is wrong.");
        System.out.println("There are no numbers with these properties.");
        System.out.println("");
    }
    public static boolean checkingString(String[] input) {
        String[] properties = {"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd", "square", "sunny"};
        String[] impossibleCombinations = {"evenodd", "oddeven", "duckspy", "spyduck", "sunnysquare", "squaresunny"};

        for (int i = 0; i < input.length; i++) {
            try {
                if (i < 2) {
                    long number = Long.parseLong(input[i]);
                    if (number < 0 && i == 0) {
                        raiseFirstParameterError();
                        return false;
                    } else if (number < 0 && i == 1) {
                        raiseSecondParameterError();
                        return false;
                    }
                } else {
                    String property = input[i];
                    if (!Arrays.stream(properties).anyMatch(property.toLowerCase()::equals)) {
                        if (input.length == 3) {
                            raisePropertyError(property);
                        } else if (input.length == 4) {
                            if (!Arrays.stream(properties).anyMatch(input[2].toLowerCase()::equals) && !Arrays.stream(properties).anyMatch(input[3].toLowerCase()::equals)) {
                                raisePropertyError(input[2], input[3]);
                            } else {
                                raisePropertyError(property);
                            }
                        }
                        return false;
                    }
                    if (i == 3) {
                        for (String impossibleCombination: impossibleCombinations) {
                            if ((input[2].toLowerCase() + input[3].toLowerCase()).equals(impossibleCombination)) {
                                raiseImpossibleCombination(input[2], input[3]);
                                return false;
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                if (i == 0) {
                    raiseFirstParameterError();
                    return false;
                } else if (i == 1) {
                    raiseSecondParameterError();
                    return false;
                }
            }
        }
        return true;
    }
}
