package dev.ranieri.app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws IllegalAccessException {
        // The Class class holds an instance of a class Object
        // not AN instance of the calculator class. But the actual blueprint/schematic for the calculator class
        Class calcClass = Calculator.class;

        // read the methods
//        Method[] methods = calcClass.getDeclaredMethods();
//        for(Method m : methods){
//            System.out.println(m.getName());
//            System.out.println(m.getReturnType());
//        }

        // read the fields
        Field[] fields = calcClass.getDeclaredFields();
        for(Field f: fields){
  //          System.out.println(f.getName());
   //         System.out.println(f.get(null)); // get the value from a static field
            // Annotations are a way to highlight sections of our code to make it easier to read via reflection

            if(f.isAnnotationPresent(MathConstant.class)){
                System.out.println(f.getName());
            }
        }



    }
}
