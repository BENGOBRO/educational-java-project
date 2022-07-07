import java.util.Scanner;

public class Numbers {
    private final int TWO_DIVISOR = 2;
    private final int SEVEN_DIVISOR = 7;
    private final int TEN_DIVISOR = 10;
    static final Scanner scanner = new Scanner(System.in);
    private long num;
    boolean natural;
    boolean exit;
    boolean even;
    boolean buzz;
    boolean duck;
    boolean palindromic;

    public long inputData() {
        num = scanner.nextLong();
        return num;
    }

    public void checkNaturalNum() {
        natural = num >= 0;
        exit = num == 0;
    }

    public void checkEvenNum() {
        even = num % TWO_DIVISOR == 0;
    }

    public void checkBuzzNum() {
        buzz = num % SEVEN_DIVISOR == 0 || (num % TEN_DIVISOR) == 7;
    }

    public void checkDuckNum() {
        duck = false;
        long duckNum = num;
        while (duckNum != 0) {
            if (duckNum % 10 == 0) {
                duck = true;
                break;
            }
            duckNum /= TEN_DIVISOR;
        }
    }

    public void checkPalindromicNum() {
        String palindromicNum = Long.toString(num);
        StringBuilder palindromicNumReverse = new StringBuilder(palindromicNum).reverse();
        String result = palindromicNumReverse.toString();
        palindromic = palindromicNum.equals(result);
    }
}
