package test;

import java.io.FileWriter;
import java.io.IOException;

public class FileExport {
    public static void main(String[] args) throws IOException {
        try  {
            FileWriter fileWriter = new FileWriter("test.txt");
            System.out.println("파일이 성공적으로 열렸습니다.");
            fileWriter.write("test\n");
            fileWriter.write("test\n");
            fileWriter.close();
            System.out.println("파일이 성공적으로 닫혔습니다.");
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류가 발생했습니다: " + e.getMessage());
        }

        System.out.println("-----------------------------");

        FileWriter fileWriter = null;
        try  {
            fileWriter = new FileWriter("test2.txt");
            fileWriter.write("test\n");
            fileWriter.write("test\n");
            System.out.println("파일이 성공적으로 열렸습니다.");
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류가 발생했습니다: " + e.getMessage());
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
                System.out.println("파일이 성공적으로 닫혔습니다.");
            }
        }

        System.out.println("-----------------------------");

        try (FileWriter fileWriter2 = new FileWriter("test.txt")) {
            fileWriter2.write("test\n");
            fileWriter2.write("test\n");
            System.out.println("파일이 성공적으로 열렸습니다.");
            //fileWriter.close(); --> 불필요, try-with-resources 구문이 자동으로 닫아줌
            System.out.println("파일이 성공적으로 닫혔습니다.");
        }catch (IOException e) {
            System.out.println("파일 쓰기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}