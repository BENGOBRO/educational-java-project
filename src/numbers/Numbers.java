package numbers;

import java.util.ArrayList;

public class Numbers {
    private final long num;
    private final long TEN_DIVISOR = 10;
    private final boolean even;
    private final boolean buzz;
    private final boolean duck;
    private final boolean palindromic;
    private final boolean gapful;
    private final boolean spy;
    private final boolean sunny;
    private final boolean square;
    private final boolean jumping;
    private final boolean happy;

    public Numbers(long num) {
        this.num = num;
        even = isEven(num);
        buzz = isBuzz(num);
        duck = isDuck(num);
        palindromic = isPalindromic(num);
        gapful = isGapful(num);
        spy = isSpy(num);
        sunny = isSunny(num);
        square = isSquare(num);
        jumping = isJumping(num);
        happy = isHappy(num);
    }

    private boolean isEven(long num) {
        long TWO_DIVISOR = 2;
        return num % TWO_DIVISOR == 0;
    }

    private boolean isBuzz(long num) {
        long SEVEN_DIVISOR = 7;
        return num % SEVEN_DIVISOR == 0 || (num % TEN_DIVISOR) == 7;
    }

    private boolean isDuck(long num) {
        long duckNum = num;
        while (duckNum != 0) {
            if (duckNum % 10 == 0) {
                return true;
            }
            duckNum /= TEN_DIVISOR;
        }
        return false;
    }

    private boolean isPalindromic(long num) {
        String palindromicNum = Long.toString(num);
        StringBuilder palindromicNumReverse = new StringBuilder(palindromicNum).reverse();
        String result = palindromicNumReverse.toString();
        return palindromicNum.equals(result);
    }

    private boolean isGapful(long num) {
        String gapfulNum = Long.toString(num);
        int length = gapfulNum.length();
        if (length >= 3) {
            String dividerInString = gapfulNum.charAt(0) + gapfulNum.substring(length - 1, length);
            long divider = Long.parseLong(dividerInString);
            return num % divider == 0;
        } else {
            return false;
        }
    }

    private boolean isSpy(long num) {
        long sum = 0;
        long product = 1;
        long localNum = num;
        while (localNum > 0) {
            sum += localNum % 10;
            product *= localNum % 10;
            localNum /= 10;
        }
        return sum == product;
    }

    private boolean isSquare(long num) {
        double rootOfNum = Math.sqrt(num);
        return rootOfNum == (int) rootOfNum;
    }
    private boolean isSunny(long num) {
        return isSquare(num + 1);
    }

    private boolean isJumping(long num) {
        long localNum = num;
        long previousDigit = 0;
        boolean firstStep = true;
        while (localNum > 0) {
            if (!firstStep && Math.abs(localNum % 10 - previousDigit) == 1) {
                previousDigit = localNum % 10;
                localNum /= 10;
            } else if (firstStep) {
                previousDigit = localNum % 10;
                localNum /= 10;
                firstStep = false;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isHappy(long num) {
        long localNum = num;
        long digitSum = 0;
        while (localNum > 0) {
            long digit = localNum % 10;
            digitSum += digit * digit;
            localNum /= 10;
        }
        if (digitSum == 1) {
            return true;
        } else if (digitSum == getNumber() || digitSum == 4) {
            return false;
        } else {
            return isHappy(digitSum);
        }
    }

    public long getNumber() {return num;}
    public boolean isEven() {return even;}
    public boolean isBuzz() {return buzz;}
    public boolean isDuck() {return duck;}
    public boolean isGapful() {return gapful;}
    public boolean isPalindromic() {return palindromic;}
    public boolean isSpy() {return spy;}
    public boolean isSquare() {return square;}
    public boolean isSunny() {return sunny;}
    public boolean isJumping() {return  jumping;}
    public boolean isHappy() {return happy;}

}
