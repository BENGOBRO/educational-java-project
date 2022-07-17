import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String pattern = scanner.nextLine();
        int count = 0;
        int i = 0;

        while (i + pattern.length() <= string.length()){
            if (string.substring(i, i + pattern.length()).equals(pattern)) {
                count++;
                i += pattern.length();
            }
            i++;
        }

        System.out.println(count);
    }
}