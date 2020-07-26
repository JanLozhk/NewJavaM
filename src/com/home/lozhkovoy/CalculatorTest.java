package com.home.lozhkovoy;

import java.util.Arrays;
import java.util.Scanner;

public class CalculatorTest {
    private static char sign;
    private static int minNum = 1;
    private static int maxNum = 10;
    private static int[] arab = {10 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9};
    private static String[] rome = {"X","I","II","III","IV","V","VI","VII","VIII","IX"};

    public static void main(String[] args) {
        String num1;
        int romano;
        int result;
        Scanner reader = new Scanner(System.in);
        Calculator calc = new Calculator();
        RomanArabConvrt convrtRomArbConvrt = new RomanArabConvrt();
        String text = "";

        try {
            System.out.println("Введите арифметическую операцию:");
            num1 = reader.nextLine();
            text = num1.replaceAll("\\s","");
            String[] blocks = text.split("[+-/*]");
            romano = 0;
            if (text.indexOf("+") != -1) {
                sign = '+';
            } else if (text.indexOf("-") != -1) {
                sign = '-';
            } else if (text.indexOf("*") != -1) {
                sign = '*';
            } else if (text.indexOf("/") != -1) {
                sign = '/';
            } else {
                System.out.println("Арифметические операции только со знаками: /, *, +, -");
                throw new IllegalArgumentException();
            }
            for (int i = 0; i <= 9; i++) {
                if (rome[i].equals(blocks[0])) {
                    blocks[0] = Integer.toString(arab[i]);
                    romano++;
                }
                if (rome[i].equals(blocks[1])) {
                    blocks[1] = Integer.toString(arab[i]);
                    romano++;
                }
            }
            if (romano == 1) {
                System.out.println("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно! ");
                throw new IllegalArgumentException();
            }
            if ((isNumsInRange(Integer.parseInt(blocks[0]))) && (isNumsInRange(Integer.parseInt(blocks[1])))) {
                result = calc.calculate(Integer.parseInt(blocks[0]), Integer.parseInt(blocks[1]), sign);
            } else {
                System.out.println("Введенные числа должны быть только >=1 и <=10");
                throw new IllegalArgumentException();
            }
            if (romano == 2) {
                convrtRomArbConvrt.arabicToRoman(result);
            } else {
                System.out.println(result);
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Неверный формат данных");
        }
    }

    private static boolean isNumsInRange(int number) {
        return (number >= minNum && number <= maxNum);
    }
}
