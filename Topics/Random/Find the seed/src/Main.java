import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<Integer> listOfPseudorandomNumbers = new ArrayList<>();
        HashMap<Integer, Integer> seedsWithMaximumValues = new HashMap<>();

        for (int seed = a; seed <= b; seed++) {
            Random random = new Random(seed);

            for (int i = 0; i < n; i++) {
                listOfPseudorandomNumbers.add(random.nextInt(k));
            }

            seedsWithMaximumValues.put(seed, Collections.max(listOfPseudorandomNumbers));
            listOfPseudorandomNumbers.clear();
        }

        int minValue = Collections.min(seedsWithMaximumValues.values());

        for (Map.Entry<Integer, Integer> entry : seedsWithMaximumValues.entrySet()) {
            if (entry.getValue() == minValue) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                break;
            }
        }
    }
}