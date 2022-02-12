package Tester;

public class Variables {

    protected static int iii = 12;
    int i = 0;
    final static String xs = "String";


    public static void main (String[] args) {
        byte b1=123;
        short s1=32023;
        int i1=65432;
        long l1=123456789012345L;
        float fl=1.22278f;
        double pi=3.1415926535d;
        double koe=1.5e7;
        String message="Вы уверены, что хотите удалить файл?";


    }

    static int sum = 0;

    public static void increment(int n) {
        sum = sum + n;
    }
    public static void decrement(int n) {
        sum = sum - n;
    }
    public static void printSum() {
        System.out.println("sum = " + sum);
    }

    public static void calculation() {
        increment(12);
        printSum();
        decrement(8);
        printSum();
        increment(-7);
        printSum();
    }

    public static void roomParameters(String room, int length, int width) {
        int floor = length * width;
        int perimeter = 2 * ( length + width);
        int height = 3;
        int walls = height * perimeter;
        System.out.println("Комната "+room+", нужно линолеума "+floor+" м2, обоев "+walls+" м2, при высоте потолков "+height+" м");

    }
    public static void apartment() {
        roomParameters("гостинная", 4, 5);
        roomParameters("кухня", 3, 3);
        roomParameters("спальня", 3, 4);
        roomParameters("прихожая", 2, 2);
    }

    public static String getFirst() {
        return "Не тот велик, ";
    }
    public static String getSecond() {
        return "кто никогда не падал, ";
    }
    public static String getThird() {
        return "а тот велик — ";
    }
    public static String getForth() {
        return "кто падал и вставал!. ";
    }
    public static String getFifth() {
        return "Конфуций";
    }
    public static void printText() {
        String text;
        text=getFirst();
        System.out.println(text);
        text=text+getSecond();
        System.out.println(text);
        String text2;
        text2=getThird()+getForth();
        System.out.println(text2);
        System.out.println( getFifth());
        System.out.println(text+text2+getFifth());
    }

}
