package dev.ranirei.science;

public class AbsoluteZeroException extends RuntimeException {

    public AbsoluteZeroException(){
        super("The input temperature was below absoulte zero");
    }
}
