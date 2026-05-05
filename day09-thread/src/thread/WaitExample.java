package thread;

public class WaitExample {
    private static final Object lock = new Object();
    private static boolean ready = false;

    public static void main(String[] args) throws Exception {
        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                while (!ready) {
                    try {
                        System.out.println("waiter: ready=false, wait()로 대기");
                        lock.wait(); // notify/notifyAll 될 때까지 대기
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println("waiter: 깨어남! ready=true, 작업 진행");
            }
        });

        Thread notifier = new Thread(() -> {
            try {
                Thread.sleep(1000); // 일부러 1초 뒤에 깨워보기
            } catch (InterruptedException ignored) {
            }

            synchronized (lock) {
                ready = true;
                System.out.println("notifier: ready=true, notify()");
                lock.notify(); // 대기 중인 스레드 1개 깨움
            }
        });

        waiter.start();
        notifier.start();

        waiter.join();
        notifier.join();
        System.out.println("main: 종료");
    }
}

