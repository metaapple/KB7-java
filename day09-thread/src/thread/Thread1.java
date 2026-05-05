package thread;

//1. 스레드 클래스를 만드세요. 1) 이름클래스 2) 익명클래스
public class Thread1 extends Thread{
    @Override
    public void run() {
        //동시에 처리되는 코드
        for (int i = 0; i < 10000; i++) {
            System.out.println("++ 증가: " + i);
            System.out.println("스레드 이름: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("에러정보 "  + e);
            }
        }
    }
}
