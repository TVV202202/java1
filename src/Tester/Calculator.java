package Tester;

public class Calculator {
    private int result;

    public Calculator(){
        this.result = 0;
    }
    public void set(int num){
        this.result = num;
    }
    public int add(int num){
        return result += num;
    }
    public int sub(int num){
        return result -= num;
    }
    public int getResult() {
        return result;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(10));
    }
}
