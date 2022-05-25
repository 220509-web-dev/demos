package dev.ranieri.generics;

public class GenericPlayground {

    public static void main(String[] args) {

        String adam = "Adam Ranieri";
        Box box1 = new Box();

        box1.putInBox(adam); // A string is of type object so it can be put in the box
        //String name = box1.getOutOfBox();// returns an Object. Not all objects are strings. ERROR
        //Object name = box1.getOutOfBox();// if I refer to name as an object I can only use it like a generic object
        //Integer name = (Integer) box1.getOutOfBox();// Forcibly cast the returned object to a string
        // Casting is usually a sign that you designed the applicaiton pooring. Casting is a great way to run into errors at runtime
        // unsafe code

        // Generics are a way of delaying specifying the TYPE of something in Java until you actually need to
        // You can write your code in the Generic so you can use your code in the specific
        String bill = "Bill";

        Box<String> box2 = new Box<String>(); // Creates a box where all the generic arguments are replaced with String
        box2.putInBox(bill);

        String n = box2.getOutOfBox(); // Java knows that this is a string

        Integer i = 1000;
        Box<Integer> box3 = new Box<Integer>();
        box3.putInBox(i);

        Integer i2 = box3.getOutOfBox();

    }
}
