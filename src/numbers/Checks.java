package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.printf("The property [%s] is wrong.\n", property.toUpperCase());
        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
        System.out.println("");
    }

    private static void raisePropertiesError(String properties) {
        System.out.printf("The properties [%s] are wrong.\n", properties.toUpperCase());
        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
        System.out.println("");
    }

    private static void raiseImpossibleCombination(String properties) {
        System.out.printf("The request contains mutually exclusive properties: [%s]\n", properties.toUpperCase());
        System.out.println("There are no numbers with these properties.");
        System.out.println("");
    }
    public static boolean checkingString(String[] input) {
        String[] properties = {"buzz", "duck", "palindromic", "gapful", "spy", "even", "odd", "square", "sunny", "jumping", "happy", "sad"};
        String[] impossibleCombinations = {"even, odd", "duck, spy", "sunny, square", "happy, sad"};
        List<String> wrongProperties = new ArrayList<>();
        List<String> addedProperties = new ArrayList<>();
        List<String> removedProperties = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            try {
                if (i < 2) {
                    long number = Long.parseLong(input[i]);
                    if (number < 0 && i == 0) {
                        raiseFirstParameterError();
                        return false;
                    } else if (number < 0) {
                        raiseSecondParameterError();
                        return false;
                    }
                } else {
                    String property;
                    boolean isDeleted = input[i].contains("-");
                    if (isDeleted) {
                        property = input[i].substring(1);
                    } else {
                        property = input[i];
                    }

                    if (!Arrays.stream(properties).anyMatch(property.toLowerCase()::equals)) {
                        wrongProperties.add(property);
                    } else {
                        if (isDeleted && !removedProperties.contains(String.format("-%s", property))) {
                            removedProperties.add(String.format("-%s", property));
                        } else if (!isDeleted && !addedProperties.contains(property)) {
                            addedProperties.add(property);
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

        //Check wrong properties
        if (wrongProperties.size() > 1) {
            String lineOfWrongProperties = "";
            lineOfWrongProperties += String.join(", ", wrongProperties);
            raisePropertiesError(lineOfWrongProperties);
            return false;
        } else if (wrongProperties.size() == 1) {
            raisePropertyError(wrongProperties.get(0));
            return false;
        }

        //Check in removed and added properties the same
        for (String removedProperty: removedProperties) {
            for (String addedProperty: addedProperties) {
                if (addedProperty.equals(removedProperty.substring(1))) {
                    String lineOfWrongProperties = String.format("%s, %s", addedProperty, removedProperty);
                    raiseImpossibleCombination(lineOfWrongProperties);
                    return false;
                }
            }
        }

        //Check in added properties impossible combination
        for (String combination : impossibleCombinations) {
            int count = 0;
            for (String addedProperty : addedProperties) {
                if (combination.contains(addedProperty)) {
                    count++;
                }
                if (count == 2) {
                    raiseImpossibleCombination(combination);
                    return false;
                }
            }
        }

        //Check in removed properties impossible combination
        for (String impossibleCombination : impossibleCombinations) {
            int count = 0;
            List<String> justForDeletedProperties = new ArrayList<>();
            for (String removedProperty : removedProperties) {
                if (impossibleCombination.contains(removedProperty.substring(1)) && !impossibleCombination.equals("sunny, square")) {
                    count++;
                    justForDeletedProperties.add(removedProperty);
                }
                if (count == 2) {
                    String lineOfWrongDeletedProperties = "";
                    lineOfWrongDeletedProperties += String.join(", ", justForDeletedProperties);
                    raiseImpossibleCombination(lineOfWrongDeletedProperties);
                    return false;
                }
            }
        }
        return true;
    }
}
