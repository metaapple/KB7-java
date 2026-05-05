package test;

public class StringTest {
    public static void main(String[] args) {
        String str = "  Hello Java World  ";
        String str2 = "  Hello Java World  ";
        System.out.println(str == str2); //true
        //String은 같은 값을 가지면 하나만 만들어서 주소를 공유함.
        //값이 변경되면 기존 값들은 그대로 놔두고
        //다른 주소에 값을 생성함.

        System.out.println(str.length());
        System.out.println(str.charAt(2));
        //코드 일부 자동 완성 : 컨트롤 + 스페이스바
        System.out.println(str.substring(2));
        System.out.println(str.substring(2, 5));
        System.out.println(str.trim());
        //뒤에 붙여줘!
        System.out.println(str.concat("java"));
        System.out.println(str.contains("java"));
    }
}
