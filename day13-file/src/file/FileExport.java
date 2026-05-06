package file;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FileExport {
    public static void main(String[] args) {
        //파일, db연결시 반드시!!!! 예외처리해주어야함.
        //try ~ catch ~ finally
        //try catch with resources(close 기능 내장)

        try (Writer writer = new FileWriter("test.txt")) { //파일생성 + 스트림open + close

            String s = "점심시간";
            writer.write(s + "\n");
            writer.write(s, 0, s.length()); //***제일 많이 씀.!
            writer.write("\n");

            writer.write("수요일", 0, 2);
            char[] chars = {'월', '화', '수'};
            writer.write(chars);
            writer.write("\n");
            writer.write(chars, 0, 2);

            writer.flush();
        } catch (Exception e) {
            System.out.println("파일 출력시 예외 발생 : " + e.getMessage());
        }
    }
}
