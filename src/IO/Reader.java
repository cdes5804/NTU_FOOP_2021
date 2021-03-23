package IO;

import java.util.Scanner;

public class Reader {
    private final static Scanner _scanner = new Scanner(System.in);

    private static boolean isEmptyOrSpace(String string) {
        return string.trim().length() == 0;
    }

    public static String readPlayerName() {
        String name = "";

        while (isEmptyOrSpace(name)) {
            name = _scanner.nextLine();
        }

        return name;
    }

    public static String readCard() {
        String card = "";

        while (isEmptyOrSpace(card)) {
            card = _scanner.next();
        }

        return card;
    }
}
