package encryptdecrypt;

public class EncryptUnicode implements CodeAlgorithm{

    @Override
    public StringBuilder change(String pattern, int key) {
        StringBuilder result = new StringBuilder();
        char symbolInLine;

        for (int i = 0; i < pattern.length(); i++) {
            symbolInLine = pattern.charAt(i);
            result.append(symbolInLine += key);
        }

        return result;
    }
}
