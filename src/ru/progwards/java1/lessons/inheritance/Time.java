package ru.progwards.java1.lessons.inheritance;

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
        final int tt = 10;
        if (hours < tt)
            h = "0" + hours;
        else
            h = Integer.toString(hours);
        if (minutes < tt)
            m = "0" + minutes;
        else
            m = Integer.toString(minutes);
        if (seconds < tt)
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

    public TimeZone getTimeZone() {
        return null;
    }

    public static void main(String[] args) {

    }
}

class ZonedTime extends Time {
    TimeZone zone;

    public ZonedTime(int hours, int minutes, int seconds) {
        super(hours, minutes, seconds);
        this.zone = getTimeZone();
    }

    public ZonedTime(int hours, int minutes, int seconds, TimeZone zone) {
        super(hours, minutes, seconds);
        this.zone = zone;
    }

    @Override
    public TimeZone getTimeZone() {
        return zone;
    }

    @Override
    public int secondsBetween(Time time) {
        TimeZone k = this.getTimeZone();
        if (k == null) {
            return super.secondsBetween(time);
        }
        return super.secondsBetween(time) + Math.abs(k.hours * 60 * 60 + k.minutes * 60);
    }

    public static void main(String[] args) {
        Time t1 = new Time(3, 35, 6);
        System.out.println(t1);
        Time t2 = new Time(4, 55, 6);
        TimeZone tz = new TimeZone(-3, 30);
        ZonedTime t3 = new ZonedTime(4, 55, 6, tz);
        System.out.println(t1.secondsBetween(t2));
        int i = t3.secondsBetween(t1);
        System.out.println(i);
    }
}
