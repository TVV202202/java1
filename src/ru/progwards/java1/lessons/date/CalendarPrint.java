package ru.progwards.java1.lessons.date;


import java.util.Calendar;
import java.util.GregorianCalendar;


public class CalendarPrint {

    public static void printMonth(int month, int year){
        String[] monthYear = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь" ," Ноябрь", "Декабрь"};
        //String[] dayWeek = {"пн", " вт", " ср", " чт", " пт", " сб", " вс"};
        Calendar calendar = new GregorianCalendar(year, month,1);

        int monthNow = calendar.get(Calendar.MONTH); // запоминаем текущий месяц (пригодится в цикле)

        System.out.println(year + " " + monthYear[month]);
        System.out.println("пн вт ср чт пт сб вс");

        int n = calendar.get(Calendar.DAY_OF_WEEK)-1; // какой день недели начиная с пн
        int k=0; // кол-во напечатанных дат
        for (int i = 1; i<n; i++) {
            System.out.print("   "); // печатаем пустые даты
            k++;
        }

        while (true){
            int j = calendar.get(Calendar.DATE);
            if (j<10)
                System.out.print(" " + j + " "); // если дата однозначная
            else
                System.out.print(j + " "); // если дата двузначная
            calendar.add(Calendar.DATE, 1); // прибавили день
            k++; // прибавили напечатанную дату
            if (k==7){
                System.out.println();
                k = 0;
            }
            if (calendar.get(Calendar.MONTH) != monthNow)
                break;
        }
    }

    public static void main(String[] args) {
        printMonth(Calendar.FEBRUARY, 2022);
    }
}
