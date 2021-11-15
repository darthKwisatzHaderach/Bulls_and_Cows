package bullscows;

import java.util.Scanner;

import static bullscows.Utils.generateRandomNumberOfGivenLength;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        int possibleSymbolsNumber = 0;
        boolean finish = false;

        do {

            do {
                System.out.println("Input the length of the secret code:");

                try {
                    length = scanner.nextInt();
                } catch (Exception e) {
                    String lengthAsString = scanner.nextLine();
                    System.out.println(String.format("Error: \"%s\" isn't a valid number.", lengthAsString));
                    finish = true;
                    break;
                }

                if (length > 36) {
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    finish = true;
                    break;
                }

                if (length == 0) {
                    System.out.println("Error: length must be greater than 0");
                    finish = true;
                    break;
                }

            } while (length > 36);

            if (finish == false) {
                System.out.println("Input the number of possible symbols in the code:");
                possibleSymbolsNumber = scanner.nextInt();

                if (possibleSymbolsNumber < length) {
                    System.out.println(String.format("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", length, possibleSymbolsNumber));
                    finish = true;
                    break;
                }

                if (possibleSymbolsNumber > 36) {
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    finish = true;
                    break;
                }
            }

        } while (length > possibleSymbolsNumber);

        if (finish == false) {
            SecretCode secretCode = new SecretCode(generateRandomNumberOfGivenLength(length, possibleSymbolsNumber));

            System.out.println("Okay, let's start a game!");
            int i = 1;
            SecretCode otherSecretCode = null;

            do {
                System.out.println(String.format("Turn %d:", i));
                scanner = new Scanner(System.in);
                String guessOfSecretCode = scanner.nextLine();
                otherSecretCode = new SecretCode(guessOfSecretCode);
                i++;
            } while (secretCode.compareTo(otherSecretCode) > 0);
        }
    }
}
