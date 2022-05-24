package com.revature;

import java.io.*;
import java.util.Scanner;

public class FileDriver {

    // Exceptions can be propagated (aka thrown) to whatever method called this one
    // Technically, bad practice to throw exceptions from main (done so here for example purposes)
    public static void main(String[] args) throws InterruptedException {

        // unchecked exceptions
        //   - are not required (by the compiler) to be handled or propagated
        //   - but if you (as the dev) are aware that it could happen, you should still handle it
        try {
            System.out.println(args[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops, there was nothing at args[10]");
        }

        System.out.println("Welcome to our app");

        File userDataFile = new File("resources/user.csv");
        if (!userDataFile.exists()) {

        }

        Scanner consoleReader = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Please choose from the following options");
            System.out.println("1) Register\n2) Login\n3) Exit");
            System.out.print("> ");

            String userSelection = consoleReader.nextLine();
            switch (userSelection) {

                case "1":
                    System.out.println("Please provide us with some basic information to register your account");

                    System.out.print("Username: ");
                    String username = consoleReader.nextLine();

                    System.out.print("Password: ");
                    String password = consoleReader.nextLine();

                    AppUser newUser = new AppUser(username, password);
                    System.out.printf("You provided the information: %s\n", newUser);

                    // checked exceptions
                    //   - required by the compiler to be handled or propagated

                    // try-with-resources (introduced in Java 7)
                    // only allowed to instantiate things that implement AutoCloseable
                    try (FileWriter writer = new FileWriter("resources/user.csv", true)) {
                        writer.write(username + "," + password + "\n");
                        System.out.println("Successfully persisted data to file!");
                    } catch (IOException e) {
                        System.err.println("Could not get access to file.");
                        System.out.println("No data persisted to file");
                        throw new ResourcePersistenceException();
                    } catch (Exception e) {
                        System.err.println("Some unexpected exception occurred.");
                    }

                    // the finally block always runs (whether or not an exception is thrown)
//                    finally {
//                        if (writer != null) {
//                            try {
//                                writer.close();
//                            } catch (IOException e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                    }

                    break;

                case "2":
                    System.out.println("You selected Login");

                    try (BufferedReader fileReader = new BufferedReader(new FileReader("resources/user.csv"))) {
                        fileReader.readLine(); // skips the first line of the CSV file (the header)

                        String line = fileReader.readLine();
                        while (line != null) {
                            System.out.println(line);
                            line = fileReader.readLine();
                        }

                        // Wezley's syntactically shorter version of the above
//                        String line;
//                        while ((line  = fileReader.readLine()) != null) {
//                            System.out.println(line);
//                        }

                    } catch (FileNotFoundException e) {
                        System.err.println("That file was not found!");
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case "3":
                    System.out.println("Exiting application");
                    running = false;
                    break;
                default:
                    System.err.println("\u001B[31mInvalid selection made.");
                    Thread.sleep(500); // tells the main thread of the app to pause for .5 seconds
                    System.out.println("Please try again.");
            }
        }


    }

}
