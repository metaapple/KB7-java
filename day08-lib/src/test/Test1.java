package test;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("1. 나는 프린트될 예정");
        try {
            System.out.println("2. 실행에러 있는 코드 " + 10 / 0);
        } catch (Exception e) {
            //System.out.println(e.getMessage()); //에러메시지만 리턴
            //e.printStackTrace(); //에러메시지 자세하게 프린트
        }
        System.out.println("3. 나는 프린트될까요???");
    }
}
