package Tester;

public class Num implements Comparable<Num>{
    int num;
    public Num(int num){
        this.num = num;
    }
    @Override
    public int compareTo(Num o) {
        return Integer.compare(this.num, o.num);
    }

    public static void main(String[] args) {
        System.out.println(new Num(1).compareTo(new Num(5)));
    }
 }
