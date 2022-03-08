package ru.progwards.java1.lessons.params;

public abstract class AbsInteger {
    int num;
    public AbsInteger (int num){
        this.num = num;
    }
    public abstract String toString();

    public int toAbsInteger(){
        return Integer.parseInt(this.toString());
    }

    public static AbsInteger add(AbsInteger num1, AbsInteger num2){
        int n1 = num1.toAbsInteger();
        int n2 = num2.toAbsInteger();
        int n3 = n1 + n2;
        if (n3 >= -128 & n3 <= 127){
            return new ByteInteger((byte) n3);
        }
        if (n3 >= -32768 & n3 <= 32767){
            return new ShortInteger((short) n3);
        }
        else
            return new IntInteger(n3);
    }

    public static void main(String[] args) {
        ByteInteger b1 = new ByteInteger((byte) 125);
        System.out.println(b1);
        IntInteger i1 = new IntInteger(33800);
        ShortInteger s1 = new ShortInteger((short) 32767);
        System.out.println(add(b1, s1));
        System.out.println(add(b1, s1).getClass());
    }


}
