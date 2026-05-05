package inter;

public class Television implements RemoteControl {
    //구현이 된 문제가 없는 완벽한 클래스가 만들어짐.
    //new로 객체 생성 가능
    @Override
    public void turnOn() {
        System.out.println("Television ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Television OFF");
    }
}
