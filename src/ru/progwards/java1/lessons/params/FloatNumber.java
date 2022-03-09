package ru.progwards.java1.lessons.params;

public class FloatNumber {
    boolean sign; // знак (+/-)
    long mantissa; // мантиса (всегда положительная)
    int exp; // порядок - 10 в степени exp

    public FloatNumber(boolean sing, long mantissa, int exp){
        this.sign = sing;
        this.mantissa = mantissa;
        /*String tmp = Long.toString(mantissa);
        char[] chars = tmp.toCharArray();
        this.exp = chars.length - exp-1;

         */
        this.exp = exp;
    }

    public FloatNumber(String num){
        char[] chars = num.toCharArray();
        if (chars[0] != '-'){ // положительное число
            this.sign = true;
            int dot = num.indexOf(".");
            int ex = num.indexOf("E");
            if (ex!=-1) { //есть степень e
                exp = Integer.parseInt(num.substring(ex + 1));
                if (dot != -1) { // есть точка
                    String tmp = num.substring(0, dot);
                    mantissa = Integer.parseInt(tmp + num.substring(dot + 1, ex) );
                }
                else{ // есть е и нет точки
                    mantissa = Integer.parseInt(num.substring(0, ex));
                }
            }
            else { // нет е
                if (dot != -1){ // нет е, но есть точка
                    if (chars[0] == '0')
                        exp = - 1 ; // сдвиг точки вправо
                    else
                        exp =  dot; // длина строки минус 1 цифра и точка
                    String tmp = num.substring(0, dot);
                    mantissa = Integer.parseInt(tmp + num.substring(dot + 1));
                }
                else { // нет е и нет точки
                    exp = chars.length-1;
                    mantissa = Integer.parseInt(num);
                }
            }
        }
        else{ // отрицательное число
            this.sign = false;
            int dot = num.indexOf(".");
            int ex = num.indexOf("E");
            if (ex!=-1) { //есть степень e
                exp = Integer.parseInt(num.substring(ex + 1));
                if (dot != -1) { // есть точка
                    String tmp = num.substring(1, dot);
                    mantissa = Integer.parseInt(tmp + num.substring(dot + 1, ex) );
                }
                else{ // есть е и нет точки
                    mantissa = Integer.parseInt(num.substring(1, ex));
                }
            }
            else { // нет е
                if (dot != -1){ // нет е, но есть точка
                    if (chars[1] == '0')
                        exp = - 1 ; // сдвиг точки вправо
                    else
                        exp = dot - 1 ; // точка минус знак
                    String tmp = num.substring(1, dot);
                    mantissa = Integer.parseInt(tmp + num.substring(dot + 1));
                }
                else { // нет е и нет точки
                    exp = chars.length-2;
                    mantissa = Integer.parseInt(num.substring(1));
                }
            }
        }
    }

    static private byte firstDigit(long num){
        while (num /10 != 0){
            num = num / 10;
        }
        return (byte) num;
    }

    public String toString() {
        String tmp = Long.toString(mantissa);
        String mantStr = tmp.charAt(0) + "." + tmp.substring(1);
        char[] chars = tmp.toCharArray();
        if (sign){
            if (exp == 0)
                return mantStr;
            else
                return mantStr + "E" + (chars.length - exp - 1);
        }
        else{
            if (exp == 0)
                return "-" + mantStr;
            else
                return "-" + mantStr + "E" + (chars.length - exp - 1);
        }
    }

    public double toDouble(){
        return Double.parseDouble(this.toString());
    }

    public void fromDouble(double num){
        FloatNumber fn = new FloatNumber(Double.toString(num));
        sign = fn.sign;
        mantissa = fn.mantissa;
        exp = fn.exp;
    }

    public void negative(){
        sign = !sign;
    }

    public FloatNumber add(FloatNumber num){
        return new FloatNumber(Double.toString(this.toDouble() + num.toDouble()));
    }
    public FloatNumber sub(FloatNumber num){
        num.negative();
        return new FloatNumber(Double.toString(this.toDouble() + num.toDouble()));
    }

    public static void main(String[] args) {
        FloatNumber fn1 = new FloatNumber(true, 55474, 2);
        FloatNumber fn2 = new FloatNumber(false, 489341, 3);
        FloatNumber fn3 = new FloatNumber("-361146E2");
        //System.out.println(fn1 + " fn1");
        //System.out.println(fn1.toDouble());
       // System.out.println(fn1.toString());
        //System.out.println(fn2 + " fn2");
        //System.out.println(fn2.toDouble());
        System.out.println(fn3 + " fn3");
        System.out.println(fn3.toDouble());
        //fn2.negative();
        //System.out.println(fn2 + " fn2");
        //System.out.println(fn1.add(fn3));
        //System.out.println(fn1.sub(fn3));
        FloatNumber fn4 = new FloatNumber("0");
        fn4.fromDouble(-694.691);
        System.out.println(fn4.toDouble());
        System.out.println(new FloatNumber("-694.691"));

    }
}