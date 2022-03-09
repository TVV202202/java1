package ru.progwards.java1.lessons.params;

public class ByteInteger extends AbsInteger {
    public ByteInteger(byte num) {
        super(num);
    }

    @Override
    public String toString() {
        return Byte.toString((byte) num);
    }

    public static void main(String[] args) {
        ByteInteger b1 = new ByteInteger((byte) 125);
        System.out.println(b1.num);
    }
}
