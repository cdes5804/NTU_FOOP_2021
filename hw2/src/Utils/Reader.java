package Utils;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Reader {
    private final static Scanner scanner = new Scanner(System.in);

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
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    public static List<Integer> readTarget() {
        String line = scanner.nextLine();
        String[] segments = line.split(", ");
        Integer[] buffer = Arrays.stream(segments).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);

        return Arrays.asList(buffer);
    }
}
