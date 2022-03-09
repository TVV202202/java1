package ru.progwards.java1.lessons.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDiff {
    static final int[] MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static long msecBetween(long time) {
        return time % 1000;
    }

    public static long secBetween(long time) {
        return (time / 1000) % 60;
    }

    public static long minBetween(long time) {
        return (time / 1000 / 60) % 60;
    }


    public static long hourBetween(long time) {
        return (time / 1000 / 60 / 60) % 24;
    }

    /*
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
     */
    public static int[] inTime(Date date1, Date date2) {
        Calendar cD1 = Calendar.getInstance();
        cD1.setTime(date1);
        Calendar cD2 = Calendar.getInstance();
        cD2.setTime(date2);
        int[] timeDiff = new int[7];
        int multi = 1;
        if ((cD2.get(Calendar.YEAR) < cD1.get(Calendar.YEAR))) {
            multi = -1;
        }
        timeDiff[6] = (cD2.get(Calendar.MILLISECOND) - cD1.get(Calendar.MILLISECOND)) * multi; // ms
        if (timeDiff[6] < 0) {
            timeDiff[6] += 1000;
            timeDiff[5] = -1;
        }
        timeDiff[5] += (cD2.get(Calendar.SECOND) - cD1.get(Calendar.SECOND)) * multi; // sec
        if (timeDiff[5] < 0) {
            timeDiff[5] += 60;
            timeDiff[4] = -1;
        }
        timeDiff[4] += (cD2.get(Calendar.MINUTE) - cD1.get(Calendar.MINUTE)) * multi; // min
        if (timeDiff[4] < 0) {
            timeDiff[4] += 60;
            timeDiff[3] = -1;
        }
        timeDiff[3] += (cD2.get(Calendar.HOUR_OF_DAY) - cD1.get(Calendar.HOUR_OF_DAY)) * multi; // hour
        if (timeDiff[3] < 0) {
            timeDiff[3] += 24;
            timeDiff[2] = -1;
        }
        timeDiff[2] += (cD2.get(Calendar.DATE) - cD1.get(Calendar.DATE)) * multi; // day
        if (timeDiff[2] < 0) {
            timeDiff[2] += 30;
            timeDiff[1] = -1;
        }
        timeDiff[1] += (cD2.get(Calendar.MONTH) - cD1.get(Calendar.MONTH)) * multi; // month
        if (timeDiff[1] < 0) {
            timeDiff[1] += 12;
            timeDiff[0] = -1;
        }
        timeDiff[0] += (cD2.get(Calendar.YEAR) - cD1.get(Calendar.YEAR)) * multi; // year
        return timeDiff;
    }

    public static void timeBetween(Date date1, Date date2) {
/*
        LocalDate lD1;
        LocalDate lD2;
        long time;
        if (date2.getTime() > date1.getTime()) {
            lD1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            lD2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            time = date2.getTime() - date1.getTime();
        } else {
            lD2 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            lD1 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            time = date1.getTime() - date2.getTime();
        }
        Date d0 = new Date(time);

 */
        int[] timeDiff = inTime(date1, date2);
        System.out.print("Между date1 и  date2 ");
        System.out.print(timeDiff[0] + " лет, " + timeDiff[1] + " месяцев, ");
        System.out.print(timeDiff[2] + " дней, " + timeDiff[3] + " часов, ");
        System.out.println(timeDiff[4] + " минут, " + timeDiff[5] + " секунд, " + timeDiff[6] + " миллисекунд");
    }

    public static void timeToBirthday(Date now, Date birthday) {
        /*LocalDate lD1;
        LocalDate lD2;
        long time;
        if (birthday.getMonth() > now.getMonth()) {
            lD1 = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            lD2 = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            time = birthday.getTime() - now.getTime();
        } else {
            lD1 = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            lD2 = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            time = now.getTime() - birthday.getTime();
        }
        Date d0 = new Date(time);

         */

        int[] timeDiff = inTime(now, birthday);
        System.out.print("До дня рождения ");
        System.out.print(timeDiff[1] + " месяцев, ");
        System.out.print(timeDiff[2] + " дней, " + timeDiff[3] + " часов, ");
        System.out.println(timeDiff[4] + " минут, " + timeDiff[5] + " секунд, " + timeDiff[6] + " миллисекунд");
    }

    public static void averageTime(Date[] events) {
        long years = 0, months = 0, days = 0;
        long hours = 0, mins=0, sec = 0, msec = 0;
        for (int i = 0; i < events.length - 1; i++) {
            int[] timeDiff = inTime(events[i], events[i + 1]);
            years += timeDiff[0];
            months += timeDiff[1];
            days += timeDiff[2];
            hours +=timeDiff[3];
            mins += timeDiff[4];
            sec += timeDiff[5];
            msec += timeDiff[6];
            //LocalDate lD2 = events[i + 1].toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //time += Math.abs(events[i].getTime() - events[i + 1].getTime());
        }
        years /= (events.length - 1);
        months /= (events.length - 1);
        days /= (events.length - 1);
        hours /= (events.length - 1);
        mins /= (events.length - 1);
        sec /= (events.length - 1);
        msec /= (events.length - 1);

        //Date d0 = new Date(time);
        System.out.print("Среднее время между событиями ");
        System.out.print(years + " лет, " + months + " месяцев, ");
        System.out.print(days + " дней, " + hours + " часов, ");
        System.out.println(mins + " минут, " + sec + " секунд, " + msec + " миллисекунд");
    }

    public static void main(String[] args) {
        Date d1 = new Date(4444444444l);
        Date d2 = new Date(3333333333l);
        Date d3 = new Date();
        Date d4 = new Date(1660165200000l);
        Date[] ev = {d1, d2, d3, d4};
        averageTime(ev);

        System.out.println(d4);
        //timeBetween(d1, d2);
        timeToBirthday(d3, d4);

        Calendar calendar = new GregorianCalendar(2007, 1, 3, 11, 33, 43);
        Date d11 = calendar.getTime();
        Date d111 = new Date(d11.getTime() + 806);
        //System.out.println(d111.getTime());
        Calendar calendar1 = new GregorianCalendar(2019, 2, 12, 9, 5, 55);
        Date d21 = calendar1.getTime();
        Date d211 = new Date(d21.getTime() + 228);
        //System.out.println(d211.getTime());
        timeBetween(d111, d211);
        System.out.println(d111);
        System.out.println(d211);
    }
}
