package dev.ranieri.collectionsapi;

import java.util.Objects;

// Comparable is an interface that adds a compareTo Method
public class Player implements Comparable<Player>{

    private String name;
    private int salary;
    private int height;

    public Player() {
    }

    public Player(String name, int salary, int height) {
        this.name = name;
        this.salary = salary;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // A hash is a generated value based off of the fields in an object
    // A hashcode is often used to determine the uniqueness of an object.
    // If two objects have the same hash we assume that their fields must-have had the same values

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, height);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", height=" + height +
                '}';
    }

    // The compareTo method will take in another player and return one three values
    // if this player smaller than the other player return -1
    // if this player larger than the other player return 1
    // if this player is the same size as the other player return 0
    @Override
    public int compareTo(Player otherPlayer) {

        if(this.height < otherPlayer.height){
            return -1;
        }
        if(this.height > otherPlayer.height){
            return 1;
        }
        return 0;
    }
}
