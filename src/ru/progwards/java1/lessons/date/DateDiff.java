package ru.progwards.java1.lessons.date;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDiff {

    public static long msecBetween(long time){  return time % 1000;}
    public static long secBetween(long time){  return (time / 1000) % 60;}
    public static long minBetween(long time){  return (time / 1000 / 60) % 60; }
    public static long hourBetween(long time){  return (time / 1000 / 60 / 60) % 24; }
    public static long yearBetween(Date date){  return date.getYear() - 70; }
    public static long monthBetween(Date date){  return date.getMonth(); }
    public static long dayBetween(long time){
        return ((time / 1000 / 60 / 60 / 24) % 365 % 30);
    }

    public static void timeBetween(Date date1, Date date2){
        long time = Math.abs(date2.getTime()-date1.getTime());
        Date d0 = new Date(time);
        //System.out.println(d0);
        long sec = d0.getSeconds();
        long min = d0.getMinutes();
        long hour = d0.getHours();
        long day = d0.getDay();
        long month = d0.getMonth();
        long year = d0.getYear() - 70;
        /*
        System.out.println(sec);
        System.out.println(secBetween(time));
        System.out.println(min);
        System.out.println(minBetween(time));
        System.out.println(hour);
        System.out.println(hourBetween(time));
        System.out.println(day);
        System.out.println(dayBetween(time));
        System.out.println(month);
        System.out.println(monthBetween(d0));
        System.out.println(year);
        System.out.println(yearBetween(d0));

         */

        System.out.print("Между " + date1 + " и " + date2 + " ");
        System.out.print(yearBetween(d0) + " лет, " + monthBetween(d0) +" месяцев, ");
        System.out.print(dayBetween(time) + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");


    }

    public static void timeToBirthday(Date now, Date birthday){
        long time = Math.abs(birthday.getTime()-now.getTime());
        Date d0 = new Date(time);
        System.out.print("До дня рождения ");
        System.out.print(monthBetween(d0) +" месяцев, ");
        System.out.print(dayBetween(time) + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");
    }
    public static void averageTime(Date[] events){
        long time = 0;
        for (int i=0; i< events.length-1; i++)
            time += Math.abs(events[i].getTime() - events[i+1].getTime());
        time /= (events.length-1);
        Date d0 = new Date(time);
        System.out.print("Среднее время между событиями ");
        System.out.print(yearBetween(d0) + " лет, " + monthBetween(d0) +" месяцев, ");
        System.out.print(dayBetween(time) + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");
    }

    public static void main(String[] args) {
        Date d1 = new Date(4444444444l);
        Date d2 = new Date(3333333333l);
        Date d3 = new Date();
        Date d4 = new Date(1660165200000l);


        //System.out.println(d4);
        //timeBetween(d1, d2);
        //timeToBirthday(d3, d4);

        Calendar calendar = new GregorianCalendar(2007,1,3,11,33,43);
        Date d11 = calendar.getTime();
        Date d111 = new Date(d11.getTime() + 806);
        //System.out.println(d111.getTime());
        Calendar calendar1 = new GregorianCalendar(2019,2,12,9,5,55);
        Date d21 = calendar1.getTime();
        Date d211 = new Date(d21.getTime() + 228);
        //System.out.println(d211.getTime());
        timeBetween(d111, d211);
    }
}
