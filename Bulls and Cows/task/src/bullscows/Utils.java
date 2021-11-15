package bullscows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utils {

    public static String generateRandomNumberOfGivenLength(int length, int possibleSymbolsNumber) {
        String set = "0123456789abcdefghijklmnopqrstuvwxyz";
        List<String> selectedSet = Arrays.asList(set.substring(0, possibleSymbolsNumber).split(""));

        Random random = new Random();
        ArrayList<Character> listOfGeneratedNumbers = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(200);
            char character = (char) number;

            if (selectedSet.contains(String.valueOf(character))) {
                if (listOfGeneratedNumbers.contains(character)) {
                    i--;
                } else {
                    listOfGeneratedNumbers.add(character);
                    stringBuilder.append(character);
                }
            } else {
                i--;
            }
        }

        String outputString = "";

        if (possibleSymbolsNumber < 11) {
            outputString = String.format("The secret is prepared: * (0-%d).", possibleSymbolsNumber - 1);
        } else if (possibleSymbolsNumber == 11) {
            outputString = "The secret is prepared: * (0-9, a).";
        } else if (possibleSymbolsNumber > 11) {
            outputString = String.format("The secret is prepared: * (0-9, %s-%s).", selectedSet.get(10), selectedSet.get(possibleSymbolsNumber - 1));
        }

        String maskedSecretCode = "";

        for (int i=0; i<length; i++){
            maskedSecretCode = maskedSecretCode + "*";
        }

        outputString = outputString.replace("*", maskedSecretCode);

        System.out.println(outputString);

        return stringBuilder.toString();
    }
}
