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
        TimeZone k1 = this.getTimeZone();
        TimeZone k2 = time.getTimeZone();
        int sdvigk1, sdvigk2;

        if (k1 == null)
            sdvigk1 = 0;
        else
            sdvigk1 = Math.abs(k1.hours * 60 * 60 + k1.minutes * 60);
        if (k2 == null)
            sdvigk2 = 0;
        else
            sdvigk2 = Math.abs(k2.hours * 60 * 60 + k2.minutes * 60);

        return super.secondsBetween(time) + Math.abs(sdvigk1 - sdvigk2);
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
        ZonedTime zt1 = new ZonedTime(11, 14, 52, new TimeZone(2));
        ZonedTime zt2 = new ZonedTime(22, 50, 1, new TimeZone(-1));
        int j = zt1.secondsBetween(zt2);
        System.out.println(j);

    }
}
