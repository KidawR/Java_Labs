package com.company;
import java.util.Scanner;

public class Main {
    public static void Task1() {
        System.out.println("Task 1:");
        System.out.println("min: " + Integer.MIN_VALUE + "\t\t\t max: " + Integer.MAX_VALUE);
        System.out.println("min: " + Double.MIN_VALUE + "\t\t\t\t max: " + Double.MAX_VALUE);
        System.out.println("min: " + Byte.MIN_VALUE + "\t\t\t\t\t max: " + Byte.MAX_VALUE);
        System.out.println("min: " + Long.MIN_VALUE + "\t max: " + Long.MAX_VALUE);
        System.out.println("min: " + Float.MIN_VALUE + "\t\t\t\t max: " + Float.MAX_VALUE);
        System.out.println("min: " + Short.MIN_VALUE + "\t\t\t\t\t max: " + Short.MAX_VALUE);
    }

    public static void Task2() {
        System.out.println("\n\nTask 2:");
        int[] arr = new int[]{-1, -2, -4, 7, 6};
        int count = 0;
        double res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                count++;
                res = res * arr[i];
            }
        }
        System.out.println(count);
        System.out.println(res);
        if (res < 0) {
            System.out.println(-Math.pow(-res, 1.0 / count));
        } else {
            System.out.println(Math.pow(res, 1.0 / count));
        }
    }

    public static void func34(int r, int R, int x, int y) {
        double hypotenuse = Math.sqrt((x * x) + (y * y));
        if (hypotenuse <= r) System.out.println("Тревога");
        if (hypotenuse > R) System.out.println("Не обнаружен");
        if (r < hypotenuse && hypotenuse <= R) System.out.println("Обнаружен");
    }

    public static void Task3() {
        System.out.println("\n\nTask 3:");
        int r = 10;
        int R = 20;
        int x = 2;
        int y = 8;
        func34(r, R, x, y);
    }

    public static void Task4(String num0, String num1, String num2, String num3) {
        System.out.println("\n\nTask 4:");
        Scanner scan = new Scanner(System.in);

        int r = Integer.parseInt(num0);
        System.out.print("r=" + r);
        int R = Integer.parseInt(num1);
        System.out.print("\n" + "R=" + R);
        int x =Integer.parseInt(num2);
        System.out.print("\n" + "X=" + x);
        int y =Integer.parseInt(num3);
        System.out.print("\n" + "Y=" + y + "\n");
        func34(r, R, x, y);
    }

    public static void Task5(int number) {
        System.out.println("\n\nTask 5:");
        String convert = Integer.toBinaryString(number);
        System.out.println("В двоичной системе счисления: " + convert);

        convert = Integer.toOctalString(number);
        System.out.println("В восьмеричной системе счисления: " + convert);
        convert = Integer.toHexString(number).toUpperCase();
        System.out.println("В шестнадцатиричной системе счисления: " + convert);
    }

    public static void func61(int beg, int end) {
        int begin = beg;
        System.out.print("\t");
        for (int i = 0; i < 16; i++) {
            String tempHex = Integer.toHexString(i);
            System.out.print("\t" + tempHex);
        }
        System.out.println("\n");
        for (int i = begin; i < end;i += 16 ) {
            String tempHex = Integer.toHexString(i);
            System.out.print(tempHex + "\t");
            for (int j = 0; j < 16; j++) {
                char ch = (char) (i + j);
                System.out.print("\t" + ch);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void func62(int beg, int end) {
        int begin = beg;
        System.out.print("\t");
        for (int i = 0; i < 16; i++) {
            String tempHex = Integer.toHexString(i);
            System.out.print("\t" + tempHex);
        }
        System.out.println("\n");
        for (int i = begin; i < end; ) {
            String tempHex = Integer.toHexString(i);
            System.out.printf(tempHex);
            for (int j = 0; j < 16; j++) {
                char ch = (char) i;
                System.out.print("\t" + ch);
                i++;
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void Task6() {
        System.out.println("\n\nTask 6:");
        func61(1024, 1280);

        func62(8352, 8384);
    }

    public static void Task7() {
        System.out.println("\n\nTask 7:");

        Scanner scan = new Scanner(System.in);
        System.out.print("Введити строку=");
        String string = scan.nextLine();
        int Letters = 0;
        int SmallLetters = 0;
        int BigLetters = 0;
        int Numbers = 0;
        int AnotherNumbers = 0;
        int AllSymbols = 0;
        int AnotherSymbols = 0;
        int AllNumbers = 0;
        for (int i = 0; i < string.length(); i++) {
            char str = string.charAt(i);

            if (Character.isLetter(str)) {
                Letters++;
                if (Character.isUpperCase(str)) {
                    BigLetters++;
                } else SmallLetters++;
            }
            else if (Character.isDigit(str)){
                if(str >= '0' && str <= '9')Numbers++;
                 else   AnotherNumbers++;
                }

            else AnotherSymbols++;

        }
        AllSymbols = string.length();
        AllNumbers = Numbers + AnotherNumbers;
        System.out.println("Количество букв: " + Letters);
        System.out.println("Количество строчных букв: " + BigLetters);
        System.out.println("Количество прописных букв: " + SmallLetters);
        System.out.println("Количество всех цыфар: " + AllNumbers);
        System.out.println("Количество арабских цифр: " + Numbers);
        System.out.println("Количество других цифр: " + AnotherNumbers);
        System.out.println("Количество других символов: " + AnotherSymbols);
        System.out.println("Общее количество символов: " + AllSymbols);
    }

    public static void Task9(){
        System.out.println("\n\nTask 9:");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введитe строку=");
        String string = scan.nextLine();
        System.out.print("Введитe подстроку=");
        String str = scan.nextLine();
        int temp = 0;
        int i = string.indexOf(str);
        while(i != -1){
            i = string.indexOf(str, i + 1);
            temp++;
        }
        System.out.println("Заданная подстрока встречается в указанной строке: " + temp + " раз");
    }

    public static void Task10(){
        System.out.println("\n\nTask 10:");
        Scanner scan = new Scanner(System.in);
        System.out.print("Введитe строку=");
        String str= scan.nextLine();
        char[] string = str.toCharArray();
        for (int i = 0; i < string.length; i++) {
            for (int k = i; k < string.length; k++)
                System.out.print(string[k]);
            for (int j = 0; j < i; j++)
                System.out.print(string[j]);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int number = Integer.parseInt(args[4]);
//        Task1();
//        Task2();
//        Task3();
//        Task4(args[0],args[1],args[2],args[3]);
//        Task5(number);
//        Task6();
//        Task7();
//        Task9();
        Task10();
    }
}
