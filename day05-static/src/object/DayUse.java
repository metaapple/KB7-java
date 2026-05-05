package object;

public class DayUse {
    public static void main(String[] args) {
        Day day1 = new Day("자바코드", 4, "세종대");
        System.out.println(day1); //참조형 변수
        System.out.println(Day.count);
        Day day2 = new Day("상속", 4, "세종대");
        System.out.println(day2);
        System.out.println(Day.count);
        Day day3 = new Day("인터페이스", 4, "세종대");
        System.out.println(day3);
        System.out.println(Day.count);

        System.out.println(Day.getCount());

        System.out.println(day1.getDoing());
        //참조형 변수를 출력해보니 패키지명.클래스명@주소 문자열 형태로 프린트됨.
        //이 문자열을 만들어주는 메서드가 자동호출하게 되어있음.
        //toString()임. 이것을 수정하면 변수가 가르키는 인스턴스 변수들을 출력하게 할 수 있음.
//        System.out.println(day1.doing);
//        System.out.println(day1.time);
//        System.out.println(day1.location);
    }
}
