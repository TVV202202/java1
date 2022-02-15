package ru.progwards.java1.lessons.inheritance;

public class TimeZone {
    int hours; //часовой сдвиг, может быть отрицательным
    int minutes; //сдвиг в минутах
    public TimeZone(int hours){
        this.hours = hours;
        this.minutes = 0;
    }
    public TimeZone(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }

}
