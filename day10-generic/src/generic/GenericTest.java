package generic;


import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        //ArrayList는 제너릭이 적용된 클래스, 객체 생성시 타입을 정할 수 있음.
        //객체 생성시 타입을 정하지 않으면 내부에 모든 타입이 Object으로 설정됨.
        list.add("홍길동"); //Object <--- String, 업캐스팅(자동형변환)
        list.add("홍길동");
        list.add("김길동");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
        //첫번째 값이 "홍길동"인지 확인하고 싶음.
        System.out.println(list.get(0).equals("홍길동")); //Object의 equals는 주소를 비교
        //String은 같은 값이면 하나만 만들어서 그 주소를 계속 씀.
        //chatAt(0) - String도 index를 가지고 있어서 인덱스로 추출 가능
        System.out.println(((String)(list.get(0))).charAt(0));
        //Object --> String, 다운캐스팅(강제형변환), String의 메서드를 쓰기 위해서!
    }
}
