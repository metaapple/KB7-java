package inter;

public class CameraUse {
    public static void main(String[] args) {
        //Phone phone = new Phone(); --> 인터페이스 객체 생성
        //ApplePhone phone = new ApplePhone(); --> 추상클래스 객체 생성
//        Phone phone = new ApplePhone1();
        ApplePhone phone = new ApplePhone1();
        phone.call();
        phone.kakao();
        phone.camera();
    }
}

