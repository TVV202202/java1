package ru.progwards.java1.lessons.params;

public class IntInteger extends AbsInteger {
    public IntInteger(int num){
        super(num);
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }

}
