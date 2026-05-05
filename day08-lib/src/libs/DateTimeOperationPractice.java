package libs;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationPractice {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

        System.out.println("현재 시간: " + now.format(dtf));
        System.out.println("1년 후: " + now.plusYears(1).format(dtf));
        System.out.println("2개월 전: " + now.minusMonths(2).format(dtf));
        System.out.println("7일 후: " + now.plusDays(7).format(dtf));
    }
}


//현재 시간: 2026.04.26 오후 18:07:45
//1년 후: 2027.04.26 오후 18:07:45
//2개월 전: 2026.02.26 오후 18:07:45
//7일 후: 2026.05.03 오후 18:07:45
