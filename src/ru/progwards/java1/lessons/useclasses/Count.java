package ru.progwards.java1.lessons.useclasses;

public class Count {
    int count;

    public Count() {
        this.count = 0;
    }

    public Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void inc() {
        count++;
    }

    public boolean dec() {
        return --count <= 0;
    }

    public static void main(String[] args) {
        Count c1 = new Count(10);
        while (true) {
            if (c1.dec()) {
                System.out.println("count равен 0");
                break;
            }
        }
    }
}


