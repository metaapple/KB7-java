package libs;


public class StringBuilderPractice {
    public static void main(String[] args) {
        String result = new StringBuilder()
                .append("World") //맨 끝에 추가
                .insert(0, "Hello ") //중간에 삽입
                .replace(6, 11, "Java") //일부글자대체
                .toString(); //문자열로생성

        System.out.println(result);
    }
}

//Hello Java