package IO;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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

    public static List<Integer> readPlay() {
        List<Integer> play = new ArrayList<Integer>();
        String line = "";

        while (isEmptyOrSpace(line)) {
            line = _scanner.nextLine();
        }
        
        String[] nums = line.trim().split("\\s+");

        for (int i = 0; i < nums.length; ++i) {
            play.add(Integer.parseInt(nums[i]));
        }

        return play;
    }
}
