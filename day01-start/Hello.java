package test;
//자바 파일 하나는 클래스파일이라고 함.
//파일명 첫글자는 무조건 대문자로 시작해야함.
//파일확장자는 무조건 .java가 붙어야함.

public class Hello {
    //시작되는 메서드를 지정해주어야 함.
    //jvm에서 public static void main()메서드를
    //시작 메서드로 인식함.
    public static void main(String[] args) {
        //컴퓨터에 출력으로 메시지를 보여라.
        //문자열은 반드시 "(이중 따옴표) 를 써야함.
        System.out.println("hello world");
        System.out.println("자동 완성함.");
    }
}
