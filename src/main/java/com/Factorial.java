package com;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Factorial {
    public static void main(String[] args) {
        int reversFactorial = calcReverseFactorial();
        printResult(reversFactorial);
    }


    private static int calcReverseFactorial() {
        Scanner scanner = new Scanner(System.in);
        int reverseFact = 1;
        int denominator = 1;

        System.out.println("Please, enter your number >>>");
        String str = scanner.nextLine();

        while (!isNumber(str)) {
            System.out.println("Please enter correct number >>>");
            str = scanner.nextLine();
        }

        int factorial = Integer.parseInt(str);
        while (isFactorial(factorial) == false) {
            System.out.println("Please enter correct factorial >>>");
            str = scanner.nextLine();
            while (!isNumber(str)) {
                System.out.println("Please enter correct number >>>");
                str = scanner.nextLine();
            }
            factorial = Integer.parseInt(str);
        }
        while (factorial > 1) {
            reverseFact++;
            factorial /= ++denominator;
            if (factorial < 1) {
                reverseFact--;
            }
        }
        return reverseFact;
    }

    private static boolean isFactorial(int factorial) {
        int denominator = 1;
        boolean res = true;
        while (factorial > 1) {
            if (factorial % denominator != 0) {
                res = false;
            }
            factorial /= denominator++;
        }
        return res;
    }

    static boolean isNumber(String str) {
        Pattern p = Pattern.compile("[0-9]?[0-9]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void printResult(int res) {
        System.out.println("\u001B[32m" + "Reverse factorial of your number = " + res);
    }

}
