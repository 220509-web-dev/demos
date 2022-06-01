package dev.ranieri.app;

public class UserApp {

    public static void main(String[] args) {
//        User adam = new User("adam@revature.net", "Adam", "Ranieri");
//        User steve = new User("steve@gmail.com", "Steve", "Smith");

        Employee employee = new Employee(101,"Kim","White");

        employee.setFname(null);// throws error

    }
}
