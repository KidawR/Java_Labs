package com.Java2;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static  void point1(){
        double pi = Math.PI;
        System.out.println("|     x      |      sin(x)     |      F(x)       |");
        for(double i = pi/15; i <= pi; i += pi/15){
            double sin = Math.sin(i);
            double func = Math.exp(i)/(i*Math.log(i));
            String sinFormat = String.format("%.7f " , sin);
            String funcFormat = String.format("%.7f " , func);
            String argumentFormat = String.format("%.5f " , i);
            String text = String.format("| %10s | %15s | %15s |" , argumentFormat, sinFormat, funcFormat);
            System.out.println(text);
        }
    }

    public static void point2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ширина равна: ");
        int s = scanner.nextInt();
        int [][] arr = new int[s][];
        int count;
        for( int i = 0; i < s; i++){
            count = i + 1;
            System.out.print("Введите размер строки "+ count +" : ");
            int f = scanner.nextInt();
            arr[i] = new int[f];
            for( int j = 0; j < f;j++){
              arr[i][j] = ((int)(Math.random() * 40) - 30);
            }
        }
        for( int i = 0; i < arr.length; i++){
            for( int j = 0; j < arr[i].length;j++){
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.print("\n");
        }
        int temp = Integer.MIN_VALUE;
        for( int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 0 && temp < arr[i][j])
                    temp = arr[i][j];
            }
        }
        if(temp == Integer.MIN_VALUE) System.out.println("Отрицательные элементы отсутствут");

        System.out.println("Наибольший отрицательный элемент= " + temp);
    }

    public static void point3() {
        int[][] arr = new int[3][3];
        int count;
        for (int i = 0; i < 3; i++) {
            count = i + 1;
            for (int j = 0; j < 3; j++) {
                arr[i][j] = ((int) (Math.random() * 40) - 30);
            }
        }
        System.out.println("Матрица 3x3:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.print("\n");
        }
        int temp;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for(int k =3 - 1; k>j;k--){
                if (arr[i][k-1] > arr[i][k]) {
                    temp = arr[i][k];
                    arr[i][k] = arr[i][k-1];
                    arr[i][k-1] = temp;
                }
                }
            }
        }
        System.out.println("Отсортированая матрица 3x3:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.print("\n");
        }


    }

    public static class point4 {
        public int pressKeyboard(){
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите x1 ");
            double x1 = scan.nextDouble();
            System.out.print("Введите y1 ");
            double y1 = scan.nextDouble();
            System.out.print("Введите r1 ");
            double r1 = scan.nextDouble();
            System.out.print("Введите x2 ");
            double x2 = scan.nextDouble();
            System.out.print("Введите y2 ");
            double y2 = scan.nextDouble();
            System.out.print("Введите r2 ");
            double r2 = scan.nextDouble();
            return metod(x1,y1,r1,x2,y2,r2);
        }

        public int metod(double x1,double y1,double r1,double x2,double y2,double r2) {
            double length = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            double r2length = length + r1;
            double r1length = length + r2;
            int temp;
            if (x1 == x2 && y1 == y2 && r1 == r2) {
               temp = 40; //System.out.println("Совпадают");
            }else {
                if (r1length == r1 || r2length == r2 || length == r1 + r2)
                    temp = 10;//System.out.println("Пересекаются в одной точке");
                else if (length < r1 + r2) temp = 20;//System.out.println("Пересекаются в двух точках");
                else temp = 30;//System.out.println("Не пересекаются")

                if (r2length <= r2) temp = temp + 1; //System.out.println("Первая окружность вложена в первую");
                else if (r1length <= r1) temp = temp + 2;//System.out.println("Bторая окружность вложена в первую");
                else temp = temp + 3; //System.out.println("Ни одна из окружностей не является вложенной в другую");

            }
            return temp;
        }
    }

    public static class point5 {
        public void pressKeyboard(){
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите x1 ");
            double x1 = scan.nextDouble();
            System.out.print("Введите y1 ");
            double y1 = scan.nextDouble();
            System.out.print("Введите r1 ");
            double r1 = scan.nextDouble();
            System.out.print("Введите x2 ");
            double x2 = scan.nextDouble();
            System.out.print("Введите y2 ");
            double y2 = scan.nextDouble();
            System.out.print("Введите r2 ");
            double r2 = scan.nextDouble();
            metod(x1,y1,r1,x2,y2,r2);
        }

        public void metod(double x1,double y1,double r1,double x2,double y2,double r2) {
            double length = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            double r2length = length + r1;
            double r1length = length + r2;
            int temp;
            enum Circle { Match, oneDot, twoDot, notIntersect,FerstCircleinSecond ,SecondCircleinFerst, notNested}
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(Circle.Match);
            } else {
                if (r1length == r1 || r2length == r2 || length == r1 + r2)
                    System.out.println(Circle.oneDot);//System.out.println("Пересекаются в одной точке");
                else if (length < r1 + r2) System.out.println(Circle.twoDot);//System.out.println("Пересекаются в двух точках");
                else System.out.println(Circle.notIntersect);//System.out.println("Не пересекаются")

                if (r2length <= r2) System.out.println(Circle.FerstCircleinSecond); //System.out.println("Первая окружность вложена в первую");
                else if (r1length <= r1) System.out.println(Circle.SecondCircleinFerst);//System.out.println("Bторая окружность вложена в первую");
                else System.out.println(Circle.notNested); //System.out.println("Ни одна из окружностей не является вложенной в другую");
            }
        }
    }

    public static void point6(int x1, int x2,int dots) {
        System.out.print("Task6\n\n");
        double argument = x1;
        double area = 0;
        double [] Arguments = new double[dots];
        double [] Values = new double[dots];
        double steep = (double) (x2-x1)/dots;

        System.out.print("    X         Y(X)\n");

        for (int i = 0; i < dots; i++) {
            Arguments[i] = argument;
            Values[i] = Math.exp(argument) - Math.pow(argument, 3);
            String funRound = String.format("%.7f", Values[i]);
            String argRound = String.format("%.5f", argument);
            String result = String.format(" %-10s | %-25s\n", argRound, funRound);
            System.out.print(result);
            argument = argument + steep;
        }
        for (int i = 0; i < Arguments.length; i++) {
            area += Values[i];
        }
        area = area* steep;
        System.out.print("Площадь: " + area);
    }

    public static void point7(int number, int base) {
        System.out.println("\n\nTask7");
        String numberToBase = "";
        int baseTemp;
        int NumberForDivide = number;
        ArrayList<Integer> numbersToBase = new ArrayList<Integer>();
        while (NumberForDivide >= 1) {
            baseTemp = NumberForDivide % base;
            NumberForDivide = NumberForDivide / base;
            numbersToBase.add(0, baseTemp);
        }
        for (int num : numbersToBase) numberToBase += num;
        System.out.println("Ответ: " + numberToBase);
        System.out.println("Проверка ответа: " + Integer.toString(number, base));
    }

    public static void point8(int n, int x) { //n размер, x значение
        int[] a = new int[n + 1];

        for (int i = 0; i < a.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите целое число: ");
            if (!scanner.hasNextInt()) {
                System.out.println("error");
                break;
            } else a[i] = scanner.nextInt();
        }
        int P = a[n] * x + a[n-1];
        for (int i = n - 2; i >= 0; i--){
            P = P * x + a[i];

        }
        System.out.println(P);


    }

    public static void point9() {
        Pattern p = Pattern.compile("(([+]7|8)(([ -]?[(]\\d{3}[)][ -]?)|([ -]?\\d{3}[ -]?))\\d{3}[ -]?\\d{2}[ -]?\\d{2})|(\\d{3}[ -]?\\d{2}[ -]?\\d{2})");
        String text = "+79043781661 +7 904 378 1661 +7 904 378 16 61 \n" +
                "+7-904-378-16-61 +7(904)3781661 +7(904) 378-16 61 \n" +
                "89043781661 8 904 378-16-61 \n" +
                "Круглыми скобками могут быть выделены тол";
        Matcher m = p.matcher(text);
        while (m.find()) {
            int begin = m.start();
            int end = m.end();
            System.out.println(text.substring(begin, end));
        }
        String text2 ="Мои номера 220-30-40 и 8904-378-16-61 не считая служебных";
        Matcher n = p.matcher(text2);
        while (n.find()) {
            int begin = n.start();
            int end = n.end();
            System.out.println(text2.substring(begin, end));
        }

    }
    public static void main(String[] args) {

//        point1();
//        point3();
//        point4 circly = new point4();
//        System.out.println(circly.metod(0,0,5,0,0,5));
//        System.out.println(circly.pressKeyboard());
//        point6(1, 4, 1000);
//        point8(2, 2);
//
//        point2();
//
//        point5 circle = new point5();
//        circle.metod(0,0,5,0,0,5);
//        cccc.pressKeyboard();

//        point7(29, 5);
//        point9();
    }

}
