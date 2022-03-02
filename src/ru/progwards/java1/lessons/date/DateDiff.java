package ru.progwards.java1.lessons.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDiff {
    static final int[] MONTH= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static long msecBetween(long time){  return time % 1000;}
    public static long secBetween(long time){  return (time / 1000) % 60;}
    public static long minBetween(long time){  return (time / 1000 / 60) % 60; }
    public static long hourBetween(long time){  return (time / 1000 / 60 / 60) % 24; }
    public static long yearBetween(Date date){  return date.getYear() - 70; }
    public static long monthBetween(Date date){  return date.getMonth(); }
    public static long dayBetween(Date date){
        long time = date.getTime();
        long k = yearBetween(date) / 4; // кол-во високосных
        long n = yearBetween(date) * 365 + k;
        return ((time / 1000 / 60 / 60 / 24) - n) % 30;
    }
    public static long dayBetween2(LocalDate date1, LocalDate date2){
        return Period.between(date1, date2).getDays();
    }
    public static long yearBetween2(LocalDate date1, LocalDate date2){
        return Period.between(date1, date2).getYears();
    }
    public static long monthBetween2(LocalDate date1, LocalDate date2){
        return Period.between(date1, date2).getMonths();
    }

    public static boolean yearVysok(Date date) { //проверка года на високосность
        int year = date.getYear() + 1900;
        return year % 4 == 0 && year % 100 != 0 && year % 400 == 0;
    }


    public static void timeBetween(Date date1, Date date2){
        LocalDate lD1;
        LocalDate lD2;

        long time;
        if (date2.getTime() > date1.getTime()) {
            lD1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            lD2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            time = date2.getTime()-date1.getTime();
        }
        else {
            lD2 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            lD1 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            time = date1.getTime()-date2.getTime();
        }

        Date d0 = new Date(time);

        System.out.print("Между date1 и  date2 ");
        System.out.print(yearBetween2(lD1, lD2) + " лет, " + monthBetween2(lD1, lD2) +" месяцев, ");
        System.out.print(dayBetween2(lD1, lD2) + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");
    }

    public static void timeToBirthday(Date now, Date birthday){
        LocalDate lD1;
        LocalDate lD2;
        long time;
        if (birthday.getMonth() > now.getMonth()){
            lD1 = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            lD2 = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            time = birthday.getTime()-now.getTime();
        }
        else{
            lD2 = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            lD1 = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            time = now.getTime()-birthday.getTime();
        }
        Date d0 = new Date(time);


        System.out.print("До дня рождения ");
        System.out.print(monthBetween2(lD1, lD2) +" месяцев, ");
        System.out.print(dayBetween(d0) + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");
    }
    public static void averageTime(Date[] events){
        long time = 0;
        long years = 0;
        long months = 0;
        long days = 0;
        for (int i=0; i< events.length-1; i++) {
            LocalDate lD1 = events[i].toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate lD2 = events[i + 1].toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            years += yearBetween2(lD1, lD2);
            months += monthBetween2(lD1,lD2);
            days += dayBetween2(lD1, lD2);
            time += Math.abs(events[i].getTime() - events[i + 1].getTime());
        }
        years /= (events.length-1);
        months /= (events.length-1);
        days /= (events.length-1);
        time /= (events.length-1);

        Date d0 = new Date(time);
        System.out.print("Среднее время между событиями ");
        System.out.print(years + " лет, " + months +" месяцев, ");
        System.out.print(days + " дней, " + hourBetween(time) + " часов, ");
        System.out.println(minBetween(time) + "минут, " + secBetween(time) + " секунд, " + msecBetween(time) + " миллисекунд");
    }

    public static void main(String[] args) {
        Date d1 = new Date(4444444444l);
        Date d2 = new Date(3333333333l);
        Date d3 = new Date();
        Date d4 = new Date(1660165200000l);


        System.out.println(d4);
        //timeBetween(d1, d2);
        timeToBirthday(d3, d4);

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
