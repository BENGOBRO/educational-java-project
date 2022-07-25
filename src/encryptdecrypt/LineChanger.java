package encryptdecrypt;

public class LineChanger {
    private CodeAlgorithm algorithm;

    public void setAlgorithm(CodeAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public StringBuilder change(String line, int key) {
        return this.algorithm.change(line, key);
    }
}
