package inter;

public class RemoteControlUse {
    public static void main(String[] args) {
//      RemoteControl rc = new Television();
        RemoteControl rc = new Video();
        rc.turnOn();
        rc.turnOff();
        System.out.println(RemoteControl.COMPANY);
    }
}
