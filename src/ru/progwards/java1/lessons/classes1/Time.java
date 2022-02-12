package ru.progwards.java1.lessons.classes1;

public class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String toString() {
        String h, m, s;
        if (hours < 10)
            h = "0" + hours;
        else
            h = Integer.toString(hours);
        if (minutes < 10)
            m = "0" + minutes;
        else
            m = Integer.toString(minutes);
        if (seconds < 10)
            s = "0" + seconds;
        else
            s = Integer.toString(seconds);
        return h + ":" + m + ":" + s;
    }

    public int toSeconds() {
        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    public int secondsBetween(Time time) {
        return Math.abs(this.hours * 60 * 60 + this.minutes * 60 + this.seconds - time.toSeconds());
    }

    public static void main(String[] args) {
        Time t1 = new Time(3, 35, 6);
        System.out.println(t1);
        Time t2 = new Time(4, 55, 6);
        System.out.println(t1.secondsBetween(t2));
    }
}
