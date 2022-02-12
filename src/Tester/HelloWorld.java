package Tester;

import java.util.function.DoubleBinaryOperator;

public class HelloWorld {
    public static void main(String[] args) {
        //Integer i = 5;
        //Double d = 2.;
        //int n = Integer.parseInt("33");
        //System.out.println(toDouble("24.55"));
        //System.out.println(maxInt());
        //System.out.println(toInt("345"));
        /*
        double k=26.941684955104225;
        double pp = pp = k * 3/ 2.0;
        double res1 = Math.sqrt(pp * (pp - k) * (pp - k) * (pp - k));
        double res2 = Math.sqrt(pp * Math.pow((pp - k) ,3));
        System.out.println(res1-res2);
         */
        long a=5;
        int b=18537754;
        int c=1;
        System.out.println(factorial(a));
        System.out.println(2);
    }
    static long factorial(long n){
        int i;
        long res;
        if (n==0)
            return 1;
        else {
            res = 1;
            for (i = 1; i <= n; i++){
                res *=i;
            }
        }
        return res;
    }

    static String textGrade(int grade){
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



    static int addAsStrings(int n1, int n2){
        return Integer.parseInt(Integer.toString(n1) + Integer.toString(n2));
    }
    public static double toDouble(String str){
        return Double.parseDouble(str);
    }
    public static int maxInt(){
        return Integer.MAX_VALUE;
    }
    public static int toInt(String str){
        return Integer.parseInt(str);
    }
}
