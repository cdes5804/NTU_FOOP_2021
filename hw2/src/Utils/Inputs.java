package Utils;

import java.util.Scanner;
import java.util.List;

public final class Inputs {
    public final static Scanner scanner = new Scanner(System.in);
    private static String currentLine;

    private static boolean isEmptyOrSpace(String string) {
        return string.trim().length() == 0;
    }

    public static boolean isTroopEnd() {
        readLine();

    }

    public static List<String> getTroop() {
        scanner.nextLine(); // consume #START-TROOP message
        String line;

        while (!(line = scanner.nextLine()).startsWith("#END-TROOP")) {
            
        }
    }
}
