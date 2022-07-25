package encryptdecrypt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String operation = "enc";
        String pattern = "";
        String pathInputFile = "";
        String pathOutputFile = "";
        String algorithm = "shift";
        int key = 0;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < args.length - 1; i += 2) {
            if (args[i].equals("-mode")) {
                operation = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                pattern = args[i + 1];
            } else if (args[i].equals("-in")) {
                pathInputFile = args[i + 1];
            } else if (args[i].equals("-out")) {
                pathOutputFile = args[i + 1];
            } else if (args[i].equals("-alg")) {
                algorithm = args[i + 1];
            }
        }

        if (!pathInputFile.equals("")) {
            try {
                pattern = new String(Files.readAllBytes(Paths.get(pathInputFile)));
            } catch (IOException e) {
                System.out.println("Cannot read file error: " + e.getMessage());
            }
        }

        LineChanger changer = new LineChanger();
        if (operation.equals("enc") && algorithm.equals("shift")) {
            changer.setAlgorithm(new EncryptShift());
        } else if (operation.equals("enc") && algorithm.equals("unicode")) {
            changer.setAlgorithm(new EncryptUnicode());
        } else if (operation.equals("dec") && algorithm.equals("unicode")) {
            changer.setAlgorithm(new DecryptUnicode());
        } else if (operation.equals("dec") && algorithm.equals("shift")) {
            changer.setAlgorithm(new DecryptShift());
        }
        result = changer.change(pattern, key);

        if (!pathOutputFile.equals("")) {
            try (PrintWriter printWriter = new PrintWriter(pathOutputFile)) {
                printWriter.print(result);
            } catch (IOException e) {
                System.out.println("Error");
            }
        } else {
            System.out.println(result);
        }
    }
}

