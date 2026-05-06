package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample2 {
    public static void main(String[] args) {
        //FileOutputStream만 넣을 수 있음. 결합도 100%
        //왼쪽 변수를 더 크게 해두면. 결합도 10%미만을 떨어짐.
        try (OutputStream os = new FileOutputStream("test.db")) {
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
        }
    }
}
