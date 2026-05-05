package test;

public class SuperManUse2 {
    public static void main(String[] args) {
        //클래스간의 형변환은 상속관계에서만 가능한다.
        Man superMan = new SuperMan("클라크", 22, 100, true);
        //큰변수타입 변수 = 작은주소값들을 다 넣을 수 있음.
        //자동으로 큰변수타입으로 변경되어서 다 들어감.
        //한번 코드해놓고 수정량이 적고, 클래스를 변경가능하게 하는 코드가 좋은 코드!!
        //앞의 변수를 더 큰 타입의 변수로 선언해두면 교체가 가능한 코드가 됨.
        //Man타입의 변수이면 수퍼맨, 스파이더맨, ...다 올 수 있음.
        //자동형변환(Man <--- SuperMan), 업캐스팅
        System.out.println(superMan);

        superMan.run();
        //업캐스팅했을 때 자식클래스의 메서드를 호출할 수 없음.
        //다시 자식으로 변경해야 자식클래스의 메서드를 호출할 수 있음.
        //강제형변환(SuperMan <-- Man), 다운캐스팅
        SuperMan sm = (SuperMan)superMan;
        sm.space();
        
        superMan.eat();
    }
}
