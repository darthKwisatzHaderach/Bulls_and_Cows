package bullscows;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SecretCode implements Comparable<SecretCode> {
    private ArrayList<String> secretCodeAsArray;

    public SecretCode(String secretCode) {
        secretCodeAsArray = new ArrayList<>();

        for (int i = 0; i < secretCode.length(); i++) {
            secretCodeAsArray.add(secretCode.substring(i, i + 1));
        }
    }

    @Override
    public int compareTo(SecretCode otherSecretCode) {
        int bulls = 0;
        int cows = 0;
        ArrayList<String> bullsList = new ArrayList<>();
        ArrayList<String> cowsList = new ArrayList<>();

        for (int i = 0; i < secretCodeAsArray.size(); i++) {
            if (otherSecretCode.secretCodeAsArray.get(i).compareTo(this.secretCodeAsArray.get(i)) == 0) {
                bullsList.add(otherSecretCode.secretCodeAsArray.get(i));
            }

            if (this.secretCodeAsArray.contains(otherSecretCode.secretCodeAsArray.get(i))) {
                cowsList.add(otherSecretCode.secretCodeAsArray.get(i));
            }
        }

        cowsList.removeAll(bullsList);
        cows = cowsList.stream().distinct().collect(Collectors.toList()).size();
        bulls = bullsList.size();

        if (bulls > 0 & cows > 0) {
            System.out.println(String.format("Grade: %d bull(s) and %d cow(s)", bulls, cows));
        } else if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None");
        } else if (bulls == 0) {
            System.out.println(String.format("Grade: %d cow(s)", cows));
        } else if (cows == 0) {
            System.out.println(String.format("Grade: %d bull(s)", bulls));
        }

        if (bulls == this.secretCodeAsArray.size()) {
            System.out.println("Congratulations! You guessed the secret code.");
            return 0;
        }

        return 1;
    }
}
