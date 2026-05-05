package test;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        //배열
        //힙영역에 무더기로 연속된 값들을 넣어두고 변수에 "주소"를 저장해둠.
        //많은 데이터, 같은 타입, 고정길이
        //for문과 함께 쓰임.

        //만드는 방법
        //1. 배열 생성시 값들을 알고 있을 때
        int[] age = {10, 20, 30};

        //c타입 for문(배열에 읽기/쓰기 가능)
        for (int i = 0; i < age.length; i++) {
            System.out.println(age[i]);
        }
        System.out.println("----------------");

        //for-each문(배열에서 읽기만 가능)
        //자바에서 배열은 인덱스가 있어야 쓰기 가능
        //자바스크립트는 가변이어서 중간에 넣어도 되고, 끝에 더 붙여도 되고, 삭제도 가능
        //자바는 고정이어서 중간/끝에 값 삽입 불가, 삭제 불가, 수정만 가능
        for (int x: age){
            System.out.println(x);
        }

        System.out.println("====================");


        //2. 배열 생성시 값들을 모르고 있다가 나중에 넣을 때
        int[] age2 = new int[3];
        age2[0] = 10;
        age2[1] = 20;
        age2[2] = 30;

        //쉽게 배열의 내용을 출력해서 확인하고자 하는 경우
        //Arrays.toString(배열명) --> 배열에 들어있는 요소들을 문자열(String)으로 만들어줌
        System.out.println(Arrays.toString(age2));

        System.out.println("====================");
        //3. 복사
        //1)기본형 변수의 값 복사
        byte b = 100;
        int i = b; //b == i(값동일, 크기는 다름), 큰(int) <-- 작(byte), 자동형변환
        System.out.println(b == i);

        byte b2 = (byte)i; // b == b2 == i
        System.out.println(b2 == i);
        System.out.println(b2 == b);

        //2)참조형 변수의 주소/값 복사
        //얕은 복사(주소 복사)
        int[] age3 = age2;
        System.out.println(Arrays.toString(age2));
        System.out.println(Arrays.toString(age3));
        age3[0] = 999;
        System.out.println(Arrays.toString(age2));
        System.out.println(Arrays.toString(age3));
        System.out.println("----------------------");
        //깊은 복사(주소사 가르키는 값 복사)
        int[] age4 = age2.clone();
        age2[0] = 555;
        System.out.println(Arrays.toString(age2));
        System.out.println(Arrays.toString(age4));
    }
}
