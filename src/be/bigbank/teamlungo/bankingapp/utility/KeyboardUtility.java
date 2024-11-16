package be.bigbank.teamlungo.bankingapp.utility;

import java.util.Scanner;

public class KeyboardUtility {
    private static final Scanner KEYBOARD = new Scanner(System.in);

    public static String askForString(String msg) {
        System.out.print(msg);
        return KEYBOARD.nextLine();
    }

    public static int askForInt(String msg) {
        return Integer.parseInt(askForString(msg));
    }

    public static double askForDouble(String msg) {
        return Double.parseDouble(askForString(msg));
    }
}
