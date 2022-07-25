package encryptdecrypt;

interface CodeAlgorithm {
    StringBuilder change(String pattern, int key);
}
