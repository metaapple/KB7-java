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

        //배열은 인덱스가 있어야 쓰기가 가능
        //읽기/쓰기 가능
        for (int i = 0; i < age.length; i++) {
            System.out.println(age[i]);
        }

        //읽기만 가능
        for (int x: age){
            System.out.println(x);
        }

        //2. 배열 생성시 값들을 모르고 있다가 나중에 넣을 때
        int[] age2 = new int[3]; //{0, 0, 0}
        //모든 저장소(변수)는 초기화를 해주세요.!
        //배열은 초기화까지 자동으로 해줌.
        //기본형 초기화
        //int --> 0, double --> 0.0, boolean --> false, char --> 유니코드값
        //참조형 초기화 --> all "주소가 없다"로 초기화(null)
        age2[0] = 10;
        age2[1] = 20;
        age2[2] = 30;

        System.out.println(Arrays.toString(age2));

        //3. 복사
        //기본형 복사
        byte b = 100;
        int i = b;
        //i == b, 값은 동일함.
        //큰 <-- 작, 자동으로 큰 타입으로 타입이 변환이 됨.
        //자동형변환

        byte b2 = (byte)i;
        //작 <-- 큰, 강제로 타입을 변환해서 넣어주어야함.
        //강제형변환(casting)

        //참조형 복사
        //변수(주소) ---> 값들
        //주소를 복사 : 얕은 복사
        int[] age3 = age2;
        System.out.println(Arrays.toString(age2));
        System.out.println(Arrays.toString(age3));
        age2[0] = 999;
        System.out.println(Arrays.toString(age2));
        System.out.println(Arrays.toString(age3));
        System.out.println(age2 == age3); //주소 비교

        //값들을 복사 : 깊은 복사(***)
        int[] age4 = age2.clone();
        System.out.println(age2);
        System.out.println(age4);
        System.out.println(age2 == age4);
        age2[0] = 555;
        System.out.println(Arrays.toString(age2));
        System.out.println(Arrays.toString(age4));
    }
}
