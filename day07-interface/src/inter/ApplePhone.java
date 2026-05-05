package inter;

public abstract class ApplePhone implements MegaPhone{
// ==> 클래스안에 하나라도 abstract붙어있는 메서드가 있으면
//     해당 클래스는 무조건 abstract이 붙어야한다.

    //여기까지 인터페이스 규격에 따라서 틀을 만들고
    //일부 필요한 기능은 추상적으로 정의만 해두어도 괜찮음.
    public abstract void camera(); //추상메서드로 기능 명세

    @Override
    public void siri() {
        System.out.println("음성 인식 기능");
    }

    @Override
    public void map() {
        System.out.println("지도 기능");
    }

    @Override
    public void internet() {
        System.out.println("인터넷 기능");
    }

    @Override
    public void call() {
        System.out.println("전화통화 기능");
    }

    @Override
    public void text() {
        System.out.println("문자 기능");
    }

    @Override
    public void kakao() {
        System.out.println("카카오 기능");
    }
}
