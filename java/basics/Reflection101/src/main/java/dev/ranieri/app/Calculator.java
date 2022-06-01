package dev.ranieri.app;


public class Calculator {

    @MathConstant
    public static final double PI = 3.14;

    @MathConstant
    public static final double e = 2.718;

    public static int counter = 0;

    public static double add(double num1, double num2){
        counter++;
        return  num1 + num2;
    }

    public static double subtract(double num1, double num2){
        counter++;
        return  num1 - num2;
    }
}
