package Utils;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Reader {
    private final static Scanner scanner = new Scanner(System.in);

    private static boolean isEmptyOrSpace(String string) {
        return string.trim().length() == 0;
    }

    public static List<String> readUnit() {
        String line;
        line = scanner.nextLine();
        if (line.startsWith("#END-TROOP")) {
            return null;
        } else if (line.startsWith("#START-TROOP")) {
            line = scanner.nextLine();
        }

        String[] segments = line.trim().split(" ");
        return Arrays.asList(segments);
    }

    public static int readAction() {
        return scanner.nextInt();
    }

    public static List<Integer> readTarget() {

    }
}
