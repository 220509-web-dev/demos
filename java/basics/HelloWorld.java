// single line comment

/*
  multi
  line
  comment
*/

import java.lang.*; // Included by default (includes String, System, and much more)
import java.util.Scanner;

public class HelloWorld {

    /**
        JavaDoc comment (used to provide an explanation/documentation to whatever
        this comment sits upon)

        The main method is the starting point* of a Java application

        * there are some subtleties to this statement (not important for now)
    */
    public static void main(String[] args) {

        // Print text to the standard output (println creates a new line after the text is printed)
        System.out.println("Hello, Java!");

        // Print text to the standard error
        System.err.println("This is an error message!");

        // Prints text to the standard output (print does not create a new line after the text)
        System.out.print("Your input: ");

        // The Scanner class can be used to read from various input streams (such as standard input)
        Scanner consoleReader = new Scanner(System.in);

        // Obtain some data from the user via the console (standard in)
        String userInput = consoleReader.nextLine();

        // Print out the data provided by the user
        System.out.println("You said: " + userInput);

    }

}

