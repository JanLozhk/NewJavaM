package com.home.lozhkovoy;

    import java.util.Scanner;

    public class Calculator {
        private static int result;

        public int calculate(int num1, int num2, char sign) {
            switch(sign) {
                case '+':
                    result = Math.addExact(num1, num2);
                    break;
                case '-':
                    result = Math.subtractExact(num1, num2);
                    break;
                case '*':
                    result = Math.multiplyExact(num1, num2);
                    break;
                case '/':
                    result = Math.floorDiv(num1, num2);
                    break;
                case '^':
                    result = (int) Math.pow(num1, num2);
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            return result;
        }
    }