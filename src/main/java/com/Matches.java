package com;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;

public class Matches {
    public static void main(String[] args) {
        int result = calcMinNumberOfMatches();
        printResult(result);
    }

    public static int calcMinNumberOfMatches() {
        Scanner scanner = new Scanner(System.in);
        int input;
        int output;
        double length;
        long width;
        System.out.println("Please, enter your number >>>");
        String str = scanner.nextLine();

        while (!isNumber(str)) {
            System.out.println("Please enter correct number >>>");
            str = scanner.nextLine();
        }
        input = Integer.parseInt(str);
        length = floor(sqrt(input));
        width = (int) ceil(input / length);
        output = (int) (2 * input + length + width);
        return output;
    }

    static boolean isNumber(String str) {
        Pattern p = Pattern.compile("[0-9]?[0-9]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void printResult(int res) {
        System.out.println("\u001B[32m" + "Result of calculation >>> " + res);
    }

}
