package ru.progwards.java1.lessons.wrappers;

public class StringConverter {
    public static String fromByte(byte number) {
        return Byte.toString(number);
    }

    public static String fromShort(short number) {
        return Short.toString(number);
    }

    public static String fromInt(int number) {
        return Integer.toString(number);
    }

    public static String fromLong(long number) {
        return Long.toString(number);
    }

    public static String fromFloat(float number) {
        return Float.toString(number);
    }

    public static String fromDouble(double number) {
        return Double.toString(number);
    }

    public static void main(String[] args) {
        /*
        byte a=125;
        short b=-30000;
        System.out.println(fromByte(a));
        System.out.println(fromShort(b));
        System.out.println(fromInt(500000));
        System.out.println(fromLong(87589357203L));
        System.out.println(fromFloat(355.67F));
        System.out.println(fromDouble(987987.854));
        */
    }

}
