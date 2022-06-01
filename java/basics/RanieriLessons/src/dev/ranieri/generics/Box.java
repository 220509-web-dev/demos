package dev.ranieri.generics;

// generics types for a class are defined in <> in the class declaration
public class Box<T> {

    private T object;

    public Box() {
    }

    public void putInBox(T obj){
        this.object = obj;
    }

    public T getOutOfBox(){
        return this.object;
    }
}
