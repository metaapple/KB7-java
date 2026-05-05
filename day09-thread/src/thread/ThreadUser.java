package thread;

public class ThreadUser {
    public static void main(String[] args) {
        //1. thread클래스를 만들자.
        //2. 객체를 만들자.
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        //스레드 이름은 start순서에 따라 Thread1, Thread2 이렇게 자동으로 이름이 만들어짐.
        thread1.setName("증가 스레드"); //스레드 이름을 임의로 지정할 수 있음.
        thread2.setName("감소 스레드"); //스레드 이름을 임의로 지정할 수 있음.
        //3. cpu대기줄에 넣자.
        thread1.start();
        thread2.start();
    }
}
