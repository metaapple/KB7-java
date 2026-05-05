package thread;

import java.net.Socket;

public class TCPClients2 {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int clientNo = i;

            new Thread(() -> {
                try {
                    Socket socket = new Socket("localhost", 9100);
                    System.out.println("클라이언트 " + clientNo + ": 서버와 연결성공!!!!");
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}