package ru.progwards.java1.lessons.params;

public class FloatNumber {
    boolean sign; // знак (+/-)
    long mantissa; // мантиса (всегда положительная)
    int exp; // порядок - 10 в степени exp

    public FloatNumber(boolean sing, long mantissa, int exp){
        this.sign = sing;
        String tmp = Long.toString(mantissa);
        while (mantissa % 10 == 0)
            mantissa /= 10;
        this.mantissa =mantissa;
        char[] chars = tmp.toCharArray();
        this.exp = chars.length - exp - 1;

    }

    public FloatNumber(String num){
        char[] chars = num.toCharArray();
        if (chars[0] != '-'){ // положительное число
            this.sign = true;
            int dot = num.indexOf(".");
            int ex = num.indexOf("E");
            if (ex!=-1) { //есть степень e

                if (dot != -1) { // есть точка
                    exp = Integer.parseInt(num.substring(ex + 1));
                    String tmp = num.substring(0, dot);
                    mantissa = Long.parseLong(tmp + num.substring(dot + 1, ex) );
                }
                else{ // есть е и нет точки
                    exp = Integer.parseInt(num.substring(ex + 1))+1;
                    mantissa = Long.parseLong(num.substring(0, ex));
                }
            }
            else { // нет е
                if (dot != -1){ // нет е, но есть точка
                    if (chars[0] == '0')
                        exp = - 1 ; // сдвиг точки вправо
                    else
                        exp =  dot-1; // длина строки минус 1 цифра и точка
                    String tmp = num.substring(0, dot);
                    mantissa = Long.parseLong(tmp + num.substring(dot + 1));
                }
                else { // нет е и нет точки
                    exp = chars.length-1;
                    mantissa = Long.parseLong(num);
                }
            }
        }
        else{ // отрицательное число
            this.sign = false;
            int dot = num.indexOf(".");
            int ex = num.indexOf("E");
            if (ex!=-1) { //есть степень e

                if (dot != -1) { // есть точка
                    exp = Integer.parseInt(num.substring(ex + 1));
                    String tmp = num.substring(1, dot);
                    mantissa = Long.parseLong(tmp + num.substring(dot + 1, ex) );
                }
                else{ // есть е и нет точки
                    exp = Integer.parseInt(num.substring(ex + 1)) + 1;
                    mantissa = Long.parseLong(num.substring(1, ex));
                }
            }
            else { // нет е
                if (dot != -1){ // нет е, но есть точка
                    if (chars[1] == '0')
                        exp = - 1 ; // сдвиг точки вправо
                    else
                        exp = dot - 2 ; // точка минус знак
                    String tmp = num.substring(1, dot);
                    mantissa = Long.parseLong(tmp + num.substring(dot + 1));
                }
                else { // нет е и нет точки
                    exp = chars.length-2;
                    mantissa = Long.parseLong(num.substring(1));
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
                return mantStr + "E" +  exp;
        }
        else{
            if (exp == 0)
                return "-" + mantStr;
            else
                return "-" + mantStr + "E" + exp;
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

        int precision = Math.max(Long.toString(mantissa).length() - exp, Long.toString(num.mantissa).length() - num.exp);
        double scale = Math.pow(10, precision-1);
        //System.out.println(precision-1);
        //System.out.println(this.toDouble() + num.toDouble());
        double tmp = Math.round((this.toDouble() + num.toDouble()) * scale) / scale;
        return new FloatNumber(Double.toString(tmp));
    }
    public FloatNumber sub(FloatNumber num){
        num.negative();
        return add(num);
    }

    public static void main(String[] args) {
        FloatNumber fn1 = new FloatNumber(true, 201320714986000l, 3);
        FloatNumber fn2 = new FloatNumber(true, 1887692982805l, 3);
        FloatNumber fn3 = new FloatNumber("-361146E2");
        System.out.println(fn1 + " fn1");
        System.out.println(fn1.toDouble());
        //System.out.println(fn1.toString());
        //System.out.println(fn2 + " fn2");
        //System.out.println(fn2.toDouble());
        //System.out.println(fn3 + " fn3");
        //System.out.println(fn3.toDouble());
        fn1.negative();
        System.out.println(fn1.toString() + " fn1");
        //FloatNumber fn5 = fn1.add(fn2);
       // System.out.println(fn5);
        //System.out.println(fn5.toDouble());
        //System.out.println(fn1.sub(fn2).toDouble());

        //FloatNumber fn4 = new FloatNumber("0");
        //fn4.fromDouble(Double.parseDouble("1324252919129"));
        //System.out.println(fn4.toDouble());
        //FloatNumber fn5 = new FloatNumber("1324252919129");
        //System.out.println(fn5);

    }
}
