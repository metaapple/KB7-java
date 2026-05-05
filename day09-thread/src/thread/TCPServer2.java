package thread;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(9100);
        System.out.println("TCP 서버 시작");

        while (true) {
            Socket socket = server.accept(); // 연결 수락

            // 👉 핵심: 스레드 생성
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " : 클라이언트 연결됨");

                    // 간단 유지 (테스트용)
                    Thread.sleep(1000);

                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start(); // 바로 실행
        }
    }
}