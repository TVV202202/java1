package Tester;

public class Base1 {
    public static void main(String[] args) {
        printJava();
        printJava("Чтобы Java понимать", "Надо функции писать");
        printJava("Буду, буду программистом", "Код пишу я чисто, чисто");
        String str=plusJava("самый популярный");
        System.out.println(str);
        str=plusJava("объектно-ориентированный");
        System.out.println(str);
        System.out.println(plusJava("очень интересный"));
        int a = 5;
        int b = 3;
        System.out.println("jgd"+a+b);
        System.out.println("jgd"+(a+b));
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
