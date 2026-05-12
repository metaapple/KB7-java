package test;

import java.io.*;

public class WriteExample {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("test2.db")) {
            byte[] array = {10, 20, 30, 40, 50};
            os.write(array, 1, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("test2.db")) {
            while (true) {
                int data = is.read();
                if (data == -1) break; // 1byte씩 읽기
                // 파일 끝에 도달했을 경우
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}