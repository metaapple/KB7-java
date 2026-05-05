package libs;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class DateTimeComparePractice {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

        LocalDateTime start = LocalDateTime.of(2026, 4, 1, 9, 0, 0);
        LocalDateTime end = LocalDateTime.of(2026, 12, 31, 18, 0, 0);

        System.out.println("시작: " + start.format(dtf));
        System.out.println("종료: " + end.format(dtf));

        if (start.isBefore(end)) {
            System.out.println("종료일 전입니다.");
        } else if (start.isEqual(end)) {
            System.out.println("같은 시각입니다.");
        } else {
            System.out.println("종료일이 지났습니다.");
        }

        System.out.println("남은 월: " + start.until(end, ChronoUnit.MONTHS));
        System.out.println("남은 일: " + start.until(end, ChronoUnit.DAYS));
        System.out.println("남은 시간: " + start.until(end, ChronoUnit.HOURS));
    }
}

//시작: 2026.04.01 오전 09:00:00
//종료: 2026.12.31 오후 18:00:00
//종료일 전입니다.
//남은 월: 8
//남은 일: 274
//남은 시간: 6585