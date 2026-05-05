package test;

//자바파일하나 == class
//class이름은 파일명과 동일해야함.
//파일이름은 무조건 대문자로 시작
//낙타표기법
//클래스 첫줄은 무조건 패키지이름
//문장의 끝은 무조건 ;을 붙여야함.
public class Primitive {
    public static void main(String[] args) {
        //기본형 4가지
        //변수하나에 값하나 저장됨.
        //정수, 실수, 문자1, 논리
        //정수
        int age = 100; //정적타입핑, 정수말고는 다른 것 넣으면 에러
        //실수
        double height = 122.2; //소수점 15자리까지
        //문자1
        char gender = '남'; //무조건 홑따옴표
        //논리
        boolean food = true; //false

        //주의점.
        //정수는 byte --> short --> int --> long
        long money = 3333333333L; //L, l
        //실수는 float --> double
        float weight = 88.8F;
        //88.80000000000000 처럼 인식함.

        //추가
        //사람은 문자1글자보다 문자를 여러개를 많이 씀(문자열)
        String name = "홍길동"; //이중따옴표를 써야함.

        System.out.println("나이는 " + age + "세");
        System.out.println("성별은 " + gender + "임");
    }
}
