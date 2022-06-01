package dev.ranieri.jankunit;

// An Assertion should throw an error if the condition we are checking for fails
public class Assertions {


    public static void equals(Object expected, Object actual ){

        if(!expected.equals(actual)){
            throw new AssertionError("Values are not equal expected " + expected +" was " + actual);
        }
    }

    public  static  void equals( Number num1, Number num2){

        if(!(num1.doubleValue() == num2.doubleValue())){
            throw new AssertionError("Values are not equal expected " + num1 +" was " + num2);
        }
    }
}
