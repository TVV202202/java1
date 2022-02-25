package ru.progwards.java1.lessons.date;

import java.util.Date;

public class DateDiff {

    public static long msecBetween(long time){  return time % 1000;}
    public static long secBetween(long time){  return (time / 1000) % 60;}
    public static long minBetween(long time){  return (time / 1000 / 60) % 60; }
    public static long hourBetween(long time){  return (time / 1000 / 60 / 60) % 24; }
    public static long yearBetween(long time){  return time / 1000 / 60 / 60 / 24 / 365; }
    public static long monthBetween(long time){  return (time / 1000 / 60 / 60 / 24 / 30) % 12; }
    public static long dayBetween(long time){
        return (time / 1000 / 60 / 60 / 24) - yearBetween(time) * 365 - monthBetween(time) * 30;
    }

    public static void timeBetween(Date date1, Date date2){
        long time = date1.getTime()-date2.getTime();

        System.out.print("Между " + date1 + " и " + date2 + " ");
        System.out.print(yearBetween(time) + " лет, " + monthBetween(time) +" месяцев, ");
        System.out.print(dayBetween(time) + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");
    }

    public static void timeToBirthday(Date now, Date birthday){
        long time = birthday.getTime()-now.getTime();

        System.out.print("До дня рождения ");
        System.out.print(monthBetween(time) +" месяцев, ");
        System.out.print(dayBetween(time) + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");
    }
    public static void averageTime(Date[] events){
        long time = 0;
        for (int i=0; i< events.length; i++)
            time += events[i].getTime();
        time /= events.length;
        System.out.print("Среднее время между событиями ");
        System.out.print(yearBetween(time) + " лет, " + monthBetween(time) +" месяцев, ");
        System.out.print(dayBetween(time) + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");
    }

    public static void main(String[] args) {
        Date d1 = new Date(4444444444l);
        Date d2 = new Date(3333333333l);
        Date d3 = new Date();
        Date d4 = new Date(1660165200000l);
        System.out.println(d4);
        timeBetween(d1, d2);
        timeToBirthday(d3, d4);
    }
}
