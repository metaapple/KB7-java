package test;

//import java.util.ArrayList;
//import java.util.List;

import java.util.*;

public class CastingTest {
    public static void main(String[] args) {
        //oop코딩시 2대 핵심 원칙
        //클래스 만들 때 원칙 - 하나의 클래스에는 하나의 역할만 응집되어 만들기(응집도 높게)
        //클래스로 객체 만들어서 조립할 때 원칙 - 너무 하나에 의존적인 코드를 만들지 마세요.(다른 클래로 대체 가능하게 만들기)(결합도 낮게)
        //형변환 실제 예제
        //어딘가의 저장소에 "다양한 타입"의 데이터를
        //"가변"으로 모아두고 싶음.
        //--> 부품을 사용해야함.
        //설계(인터페이스, List)
        //클래스(ArrayList, LinkedList, .....)
        List list = new ArrayList(); //--> 결합도 낮음.
        //List list = new LinkedList();
        //List list = new AdvancedList();
        //ArrayList list = new ArrayList(); --> 결합도 높음.

        list.add(new String("test"));
        list.add(new Random());
        list.add(new Date());
        list.add(new Person("클라크", 28));
        //add(Object o)라고 되어있음. 모든 클래스는 Object의 자식
        //Object이 제일 큰 클래스임. 상속받은 자식 클래스는 작은 클래스
        //Object <--- 다른클래스 (자동형변환, 업캐스팅)

        //test 문자열 넣은 것 중에서 첫글자를 추출하고 싶음. charAt(인덱스)메서드 String클래스에 있음.
        //Date()를 가지고 와서 현재 몇시인지 알고 싶음. getHours()메서드 Date클래스에 있음.

        //자식클래스의 메서드를 써주기위해서는 강제로 다시 자식클래스의 타입으로 변수를 변경해주어야함.
        //강제형변환, 다운캐스팅
        //Object s = list.get(0); --> String클래스의 메서드 사용 불가
        String s = (String)list.get(0); //강제형변환, String <--- Object
        System.out.println(s.charAt(0));
        Date date = (Date)list.get(2); //강제형변환, Date <--- Object
        System.out.println(date.getHours());
        System.out.println(date.getMinutes());
        System.out.println(date.getSeconds());


        //형변환 적용할 수 있는 곳
        //-------------------------------------------
        //매개변수 : add(Object o)
        //변수선언 : List list
        //메서드 반환 타입 : public String toString()

        //어딘가의 저장소에 "동일한 타입"의 데이터를
        //"고정"으로 모아두고 싶음. --> 배열
    }
}
