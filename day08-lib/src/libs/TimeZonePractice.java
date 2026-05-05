package libs;


import java.util.Calendar;
import java.util.TimeZone;

public class TimeZonePractice {
    public static void main(String[] args) {
        // 대한민국 시간대
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Seoul");
        Calendar now = Calendar.getInstance(timeZone);

        String amPm = now.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후";

        System.out.println("대한민국 현재 시간");
        System.out.println(amPm + " " +
                now.get(Calendar.HOUR) + "시 " +
                now.get(Calendar.MINUTE) + "분 " +
                now.get(Calendar.SECOND) + "초");
    }
}

//대한민국 현재 시간
//오후 6시 8분 48초