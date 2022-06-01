package com.revature;

public class StringDriver {

    static String s6 = "North";

    public static void main(String[] args) {
        System.out.println("Hello, IntelliJ!");

        /* Strings */
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null; // null indicates the lack of an object
        String s5; // uninitialized

        System.out.println(s4 + "test"); // warning provided since s4 is assigned a null value
        // System.out.println(s5 + "test"); // compiler error since s5 was not given any value

        /*
            When comparing values, we can use == or (if we are working with objects) .equals()
         */

        System.out.println(5 == 5); // true
        System.out.println(5 == 4); // false
        System.out.println('c' == 'c'); // true
        System.out.println('c' == 'a'); // false

        AppUser user1 = new AppUser("tester99", "test-password");
        AppUser user2 = new AppUser("tester99", "test-password");
        AppUser user3 = user1;

        // when using the == on objects, Java checks for reference equality
        System.out.println(user1 == user2); // false
        System.out.println(user1 == user3);

        // By default, on objects, the .equals method actually just uses == under the hood
        // The change this, objects must override the Object#equals method and provide
        // a new implementation that checks for value equivalence (can be generated by the IDE)
        System.out.println(user1.equals(user2));

        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s6); // true
        System.out.println(s1 == s3); // false (because s3 was instantiated using the new keyword)

        s3 = s3.intern();
        System.out.println(s1 == s3); // true
        String s7 = "".concat("North");
        System.out.println(s1 == s7);

        s1.concat("west"); // Strings are immutable (and thus, thread-safe)
        System.out.println(s1); // Still prints "North", because the result of concat was not used

        s1 = s1.concat("west");
        System.out.println(s1); // "Northwest"

        // ----------------------------------------

        /*
            StringBuilder
              - mutable
              - not thread-safe

            StringBuffer
              - mutable
              - thread-safe
         */

//        StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("Hello");
        StringBuilder sb3 = new StringBuilder("Hello");

        sb2.append(", world!"); // StringBuilder/Buffer are mutable!
        System.out.println(sb2);

        System.out.println(sb2 == sb3); // false
        System.out.println(sb2.equals(s3)); // also false, because StringBuilder does not override Object#equals

        sb2 = null; // dereferences the object instantiated on line 69
        // that object is now eligible for garbage collection

        // Garbage collection cannot be forced, but you can suggest it (though, I wouldn't)
        System.gc(); // merely, suggests to the JVM to run the garbage collector

    }

}