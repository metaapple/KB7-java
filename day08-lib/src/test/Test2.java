package test;

import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        try {
            //파일을 만들어서 글자들을 쓰고 싶다.
            FileWriter file = new FileWriter("test.txt");
            //파일을 만들고 스트림(연결통로를 만들었음.)
            file.write("오늘은 목요일 \n");
            file.write("내일은 깃특강 \n");
            file.write("다음주에 만나요. \n");
            file.close(); //스트림을 열었으면 다쓰고 나서 반드시 닫아줘야 램에서 없어짐.
            //안닫아주면 램에 남아있음.
            System.out.println(10 / 0);
        } catch (IOException e) {
            System.out.println("파일 쓰기 에러 : " + e.getMessage());
            //담당자들에게 문자/이메일 보내는 처리
            //에러 내용 + 에러 발생 시간 --> 파일이나 db에 누적 --> 분석 --> 에러 원인 제거
        } catch (ArithmeticException e) {
            System.out.println("수학 에러 : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("위 catch에서 지정하지 않은 예외상황 : " + e.getMessage());
        } finally {
            System.out.println("예외 발생 여부와 상관없이 무조건 실행하는 코드는 여기에 넣어주세요.");
        }
    }
}
