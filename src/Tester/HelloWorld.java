package Tester;

import java.util.Date;
import java.util.function.DoubleBinaryOperator;

public class HelloWorld {
    public static void main(String[] args) {
        //Integer i = 5;
        //Double d = 2.;
        //int n = Integer.parseInt("33");
        //System.out.println(toDouble("24.55"));
        //System.out.println(maxInt());
        //System.out.println(toInt("345"));
        //int[][] m = {{1,2,3}, {10,20,30}, {11,12,13}};
        //int[][] m = {{}};
        //int i = m.length;
        //System.out.println(m[0][1]);
        //int sum = arraySum2(m, 0);
        //int[] a = {1,4,5,7,2,4,5,66,78,0,11,5};
        //arrayPrint(a);
        Date d1 = new Date();
        Date d2 = new Date();
        System.out.println(timeDiff(d1,d2));
    }
    public static long timeDiff(Date date1, Date date2){
        return date1.getTime()-date2.getTime();
    }
    public static int arraySum2(int[][] m, int n){
        int res = 0;
        for(int i=0; i<m[n].length; i++){
            res += m[n][i];
        }
        return res;
    }
    public static void arrayPrint(int[] a) {
        System.out.println(a[3] + " " + a[5] + " " + a[8]);
    }
    public static int arraysSum(int[] a){
        int res = 0;
        for (int value: a){
            res +=value;
        }
        return res;
    }
    public static boolean compare3str(String str1, String str2, String str3) {
        return str1.equals(str2) && str1.equals(str3);
    }

    static long factorial(long n) {
        int i;
        long res;
        if (n == 0)
            return 1;
        else {
            res = 1;
            for (i = 1; i <= n; i++) {
                res *= i;
            }
        }
        return res;
    }

    static String textGrade(int grade) {
        String res = "";
        if (grade < 0 || grade > 100)
            res = "не определено";
        else if (grade == 0)
            res = "не оценено";
        else {
            if (grade > 0 && grade <= 20)
                res = "очень плохо";
            else if (grade > 20 && grade <= 40)
                res = "плохо";
            else if (grade > 40 && grade <= 60)
                res = "удовлетворительно";
            else if (grade > 60 && grade <= 80)
                res = "хорошо";
            else if (grade > 80 && grade <= 100)
                res = "отлично";
        }
        return res;
    }


    static int addAsStrings(int n1, int n2) {
        return Integer.parseInt(Integer.toString(n1) + Integer.toString(n2));
    }

    public static double toDouble(String str) {
        return Double.parseDouble(str);
    }

    public static int maxInt() {
        return Integer.MAX_VALUE;
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}

class Guns {
    String model;
    double caliber;

    public Guns(String model, double caliber) {
        this.model = model;
        this.caliber = caliber;
    }

    int compareTo(Guns gun) {
        return Double.compare(caliber, gun.caliber);
    }

    public static void sortGuns(Guns gun1, Guns gun2) {
        if (gun1.compareTo(gun2) < 0)
            System.out.println(gun1.model + ", " + gun2.model);
        else
            System.out.println(gun2.model + ", " + gun1.model);
    }

    public static void main(String[] args) {
        sortGuns(new Guns("colt", 7.62), new Guns("para", 6.65));
    }
}