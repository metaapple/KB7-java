package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        //1. 파일을 만들어서 내용을 넣고 싶음.
        //2. 이미지, 동영상, 문자 등 파일 --> Stream(바이트 스트림)
        //3. 출력 OutputStream --> FileOutputStream

        //2-1. 문자 파일 --> Reader, Writer(문자 스트림)
        //3-1. 출력 Writer --> FileWriter

        //파일을 만들어라.(파일 생성 + 자바프로그램과 파일간 연결통로를 만든다. 스트림 open)
        //파일에 내용을 쓰세요. write()
        //파일에 연결된 스트림 close()
        //외부 자원과 연결하는 경우 스트림open -- 스트림close
        //file, db server
        //예외처리 반드시 해주어야함. (try-catch)
        FileOutputStream os = null; //변수 선언시 반드시!! 초기값 넣어주어야함.
        try {
            os = new FileOutputStream("test.db");
            //타입명 변수명 --> 선언, 4바이트 공간 ram에 만든다.
            //선언시 주의점, 선언할 때 괄호 안에서만 사용 가능!!(scope)
            //괄호 밖에서는 인식 못함.
            //쓰는 방법, 1) byte단위, 2) byte배열, 3) byte배열(일부분)
            byte a = 10; //-128~127
            byte b = 20; //-128~127
            byte c = 30; //-128~127

            os.write(a);
            os.write(b);
            os.write(c);

        } catch (FileNotFoundException e) {
            System.out.println("파일이 없음.");
            //catch 여러개 쓸 때는 더 디테일한 예외처리부터 위에 써주세요.
        } catch (Exception e) {
            System.out.println("파일 출력시 에러 발생함. " + e.getMessage()); //간단하게 출력
            e.printStackTrace(); //자세하게 출력
        } finally {
            //에러가 발생하든 안하든 상관없이 무조건 실행하게 하고 싶은 경우
            try {
                os.close();
            } catch (IOException e) {
                System.out.println("파일 스트림 닫을 때 에러생김");
            }
        }
    }
}
