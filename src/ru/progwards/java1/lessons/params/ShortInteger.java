package ru.progwards.java1.lessons.params;

public class ShortInteger extends AbsInteger{
    public ShortInteger(short num){
        super(num);
    }

    @Override
    public String toString() {
        return Short.toString((short) num);
    }

}
