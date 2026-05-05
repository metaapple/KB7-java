package inter;

public class Video implements RemoteControl {
    //구현이 된 문제가 없는 완벽한 클래스가 만들어짐.
    //new로 객체 생성 가능

    int volume; //필드, 생성자 추가 가능

    @Override
    public void turnOn() {
        System.out.println("Video ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Video OFF");
    }

    //메서드 추가 가능
    public void changeVolume(int volume) {
        this.volume = volume + 1;
        System.out.println("Change volume to " + this.volume);
    }
}
