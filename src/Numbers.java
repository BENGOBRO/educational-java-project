public class Numbers {
    private final int TEN_DIVISOR = 10;
    private final int num;
    boolean natural;
    boolean exit;
    boolean even;
    boolean buzz;
    boolean duck;
    boolean palindromic;
    boolean gapful;

    public Numbers(int num) {
        this.num = num;
    }

    public void checkNaturalNum() {
        natural = num >= 0;
        exit = num == 0;
    }

    public void checkEvenNum() {
        int TWO_DIVISOR = 2;
        even = num % TWO_DIVISOR == 0;
    }

    public void checkBuzzNum() {
        int SEVEN_DIVISOR = 7;
        buzz = num % SEVEN_DIVISOR == 0 || (num % TEN_DIVISOR) == 7;
    }

    public void checkDuckNum() {
        duck = false;
        int duckNum = num;
        while (duckNum != 0) {
            if (duckNum % 10 == 0) {
                duck = true;
                break;
            }
            duckNum /= TEN_DIVISOR;
        }
    }

    public void checkPalindromicNum() {
        String palindromicNum = Integer.toString(num);
        StringBuilder palindromicNumReverse = new StringBuilder(palindromicNum).reverse();
        String result = palindromicNumReverse.toString();
        palindromic = palindromicNum.equals(result);
    }

    public void checkGapfulNum() {
        String gapfulNum = Integer.toString(num);
        int length = gapfulNum.length();
        if (length >= 3) {
            String dividerInString = gapfulNum.charAt(0) + gapfulNum.substring(length - 1, length);
            long divider = Long.parseLong(dividerInString);
            gapful = num % divider == 0;
        } else {
            gapful = false;
        }

    }
}
