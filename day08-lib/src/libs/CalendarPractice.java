package libs;

import java.util.Calendar;

public class CalendarPractice {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int week = now.get(Calendar.DAY_OF_WEEK);
        int amPm = now.get(Calendar.AM_PM);
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);

        String weekName;
        switch (week) {
            case Calendar.MONDAY -> weekName = "월";
            case Calendar.TUESDAY -> weekName = "화";
            case Calendar.WEDNESDAY -> weekName = "수";
            case Calendar.THURSDAY -> weekName = "목";
            case Calendar.FRIDAY -> weekName = "금";
            case Calendar.SATURDAY -> weekName = "토";
            default -> weekName = "일";
        }

        String amPmText = (amPm == Calendar.AM) ? "오전" : "오후";

        System.out.println(year + "년 " + month + "월 " + day + "일");
        System.out.println("요일: " + weekName);
        System.out.println(amPmText + " " + hour + "시 " + minute + "분");
    }
}

//2026년 4월 26일
//요일: 일
//오후 6시 7분

