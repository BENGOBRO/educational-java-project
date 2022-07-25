package encryptdecrypt;

public class DecryptShift implements CodeAlgorithm {

    @Override
    public StringBuilder change(String pattern, int key) {
        StringBuilder result = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < pattern.length(); i++) {
            char symbolInLine = pattern.charAt(i);
            if (Character.isUpperCase(symbolInLine)) {
                symbolInLine = Character.toLowerCase(symbolInLine);
            }

            if (alphabet.indexOf(symbolInLine) != -1) {
                int indexOfSymbol = alphabet.indexOf(symbolInLine);
                int indexOfNewSymbol = indexOfSymbol - key;
                if (indexOfNewSymbol < 0) {
                    indexOfNewSymbol += alphabet.length();
                }

                if (Character.isUpperCase(symbolInLine)) {
                    symbolInLine = Character.toUpperCase(alphabet.charAt(indexOfNewSymbol));
                } else {
                    symbolInLine = alphabet.charAt(indexOfNewSymbol);
                }
            }
            result.append(symbolInLine);
        }

        return result;
    }
}
