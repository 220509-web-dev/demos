package dev.ranieri.jankunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JankRunner {

    public static void main(String[] args) {
        CalcTests tests = new CalcTests();
        runTestSuite(tests);
        // prints out a bunch of information

    }

    public static void runTestSuite(Object o){
        Object instance = o.getClass();
        Class c = o.getClass();
        Method[] methods = c.getDeclaredMethods();

        for(Method m : methods){
            try {
                if(m.isAnnotationPresent(AfterAll.class)){
                    continue;
                }
                if(m.isAnnotationPresent(Test.class) && !m.isAnnotationPresent(Disabled.class)){
                    m.invoke(o);
                    String testName = m.getDeclaredAnnotation(Test.class).testName();
                    System.out.println("Test Passed  =) " + testName);
                }
            }catch (Throwable throwable){
                String testName = m.getDeclaredAnnotation(Test.class).testName();
                System.err.println("Test Failed =( " + testName);
                throwable.printStackTrace();
            }
        }

        // run afterall method at the very end
        for( Method m: methods){
            if(m.isAnnotationPresent(AfterAll.class)){
                try {
                    m.invoke(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
