package thread;

public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        try {
            sumThread.join();
        } catch (InterruptedException e) {
        }
        System.out.println("1~100 합: " + sumThread.getSum());
    }
}

//join은 해당 스레드가 끝날 때 까지 기다리는 기능
//join()안했을 때
//1~100 합: 0
//합을 다 구해야 프린트 가능함.
//join()넣어줬을 때
//1~100 합: 5050
