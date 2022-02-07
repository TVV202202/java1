public class Test {


    public static String sayHello(String greeting, String name) {
        return greeting + ", " + name + "!";
    }
    static void add(int x, int y) {
        System.out.println(x+y);
    }

    static void add(int x, int y, int z) {
        System.out.println(x+y+z);
    }
    static void add(double x, double y) {
        System.out.println(x+y);
    }
    static void add(String x, String y) {
        System.out.println(x+y);
    }
    public static void main(String[] args) {
        printJava();
        printJava("Чтобы Java понимать", "Надо функции писать");
        printJava("Буду, буду программистом", "Код пишу я чисто, чисто");
        String str=plusJava("самый популярный");
        System.out.println(str);
        str=plusJava("объектно-ориентированный");
        System.out.println(str);
        System.out.println(plusJava("очень интересный"));
    }

    public static void printJava() {
        String s1="Хорошо идут дела";
        String s2="Изучаю Java я!";
        String s3=" ";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1+" "+s2);
        System.out.println(s2+" "+s1);
    }
    public static void printJava(String java1, String java2) {
        System.out.println(java1);
        System.out.println(java2+"!");
        System.out.println(java1+", "+java2+"!");
        System.out.println(java2+", "+java1+"!");
    }
    public static String plusJava(String message) {
        return "Java - " + message + " язык программирования";
    }


}