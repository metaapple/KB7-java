package file;

import java.io.*;

public class FileImport {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("test.txt")) {
            while (true){
                int data = reader.read();
                //while 무한루프에는 반드시 끝나는 지점을 써주어야함.
                if (data == -1) {
                    System.out.println("읽기 종료");
                    //System.exit(0); //프로그램 종료
                    break; //반복문 종료하고 while문 아래있는 것 계속 실행
                }
                System.out.println((char)data);
            }
        } catch (Exception e) {
            System.out.println("에러발생");
        }


        //BufferReader를 이용해서 buffer(읽어온 데이터를 모으는 큰 공간)에 넣는 경우
        //Reader에서 읽어온 것만 넣을 수 있음.
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            while (true){
                String s = br.readLine(); //buffer에 넣어야 한줄씩 읽어올 수 있음.
                if (s == null) {
                    break;
                }
                System.out.println("읽어온 문자열: " + s);
            }
        } catch (Exception e) {
            System.out.println("파일 한글자씩 읽어서 버퍼라는 큰 공간에 다 넣다가 에러");
        }

        //네트워크로 전송되는 데이터는 바이트스트림처리됨. --> Bufferdreader에 넣을 수 없음.
        //바이트스트림을 문자스트림으로 바꾸어서 Bufferdreader에 넣을 수 있음.
        //보조스트림(브릿지 스트림)
        try(
                //네트워크로 읽어온 바이트스트림
                FileInputStream stream = new FileInputStream("test.txt");
                //바이트스트림 --> 문자스트림
                InputStreamReader transfer = new InputStreamReader(stream);
                //문자스트림으로 버퍼에 넣음. --> 한줄씩 읽어올 수 있음.
                BufferedReader buffer = new BufferedReader(transfer);

                //BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")))
        ){
            //읽는 처리 코드 들어감.
            while (true){
                String s = buffer.readLine(); //buffer에 넣어야 한줄씩 읽어올 수 있음.
                if (s == null) {
                    break;
                }
                System.out.println("읽어온 문자열: " + s);
            }
        } catch (Exception e) {
            System.out.println("바이트스트림으로 버퍼에 넣는 중 에러생김");
        }





        
    }
}
