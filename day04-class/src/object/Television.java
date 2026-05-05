package object;

public class Television {
    //우리 클래스 하나 만들어보자.
    //특성을 찾아서 클래스를 만들어야함.
    //특성
    //정적인 성질(속성)
    //사이즈, 가격, 제조회사, 색
    //사이즈, 가격만 선택함.
    //변수로 만들어 놓으면 됨.
    //멤버변수라고 함.
    //추상화
    //컴파일할 때 멤버변수는 자동 초기화됨.
    //클래스 전역변수(글로벌 변수)
    String size; //null
    int price; //0

    //동적인 기능(동작)
    //끄다, 켜다, 채널바꾸다, 유투브연결하다, 볼륨조절하다.
    //메서드로 만들어 놓으면 됨.
    //멤버메서드라고 함.
    //끄다, 켜다만 선택함.
    public void powerOn() {
        int bonus = 10000; //지역변수
        System.out.println("tv를 켜다.");
        System.out.println(price + 10000);
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            System.out.println(bonus);
        }
        //System.out.println(i);
    }

    public void powerOff() {
        System.out.println("tv를 끄다.");
    }

    public int getPrice() {
        return price;
    }

    public int getPrice(int sale) {
        return price - sale;
    }

    //자바는 메서드이름 동일해도 된다.
    //단, 입력값이 달라야함.
    //타입, 개수, 순서


}
