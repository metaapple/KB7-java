package array;

//import java.lang.*;
//컴파일할 때 자동으로 넣어줌.
//안써도 됨.

public class Array1 {
    public static void main(String[] args) {
        System.out.println("테스트");

        //배열 만들기 --> 고정크기, 같은 타입만 넣음.
        //방법 1) 배열 생성시기에 값을 모르고 있다가 나중에 넣는 경우

        int[] jumsu = new int[10]; //자동초기화
        System.out.println(jumsu[0]); //0
        //한 줄 복사(ctrl + d)
        System.out.println(jumsu[1]); //0
        System.out.println(jumsu.length); //10
        System.out.println(jumsu[jumsu.length - 1]);

        jumsu[0] = 100;
        jumsu[1] = 200;

        System.out.println(jumsu[0] + " " + jumsu[1]);


        //방법 2) 배열 생성시기에 값을 알고 있는 경우
        int[] jumsu2 = {100, 200, 300};
        //변수의 개수 -->
        //지역변수(local, 로컬변수) : jumsu2(참조형변수, 4바이트)
        //힙영역의 변수(값저장) : 0, 1, 2인덱스, 3개(12바이트)
        //힙영역의 변수(length) : 3이 저장(4바이트)

        //첫번째 위치값, 두번째 위치값 프린트
        System.out.println(jumsu2[0]);
        System.out.println(jumsu2[1]);

        //배열과 항상 함께 사용되는 구문!! --> 반복문(for문)
        //c타입의 for문
        for (int i = 0; i < jumsu2.length; i++) {
            System.out.println(jumsu2[i]);
        }

        //인덱스 필요없이 반복해서 꺼내주는 iterator(반복자)가 내장
        //for-each문
        for ( int x : jumsu2){
            System.out.print(x + " ");
        }

        System.out.println();

        String[] names = {"홍길동", "김길동", "박길동", "송길동", "정길동"};
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }

        System.out.println();
        //for-each문도 추가해보세요.
        for ( String s : names){
            System.out.println(s);
        }
    }
}
