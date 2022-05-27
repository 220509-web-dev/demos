package dev.ranieri.jankunit;

import dev.ranieri.app.Calculator;

public class CalcTests {

    @AfterAll
    public void cleanup(){
        System.out.println("I run at the end");
    }

    @Test(testName = "Addition Test")
    public void add_test(){
        double result = Calculator.add(10,10);
        Assertions.equals(20,result);
    }

    @Disabled
    @Test(testName = "Subtraction Test")
    public void subtract_test(){
        double result = Calculator.subtract(30,19);
        Assertions.equals(11,result);
    }

    @Test(testName = "Multiply Test")
    public void multiply_test(){
        double result = Calculator.multiply(100, 2);
        Assertions.equals(200,result);
    }

    public void hello(){
        System.out.println("Hello");
    }
}
