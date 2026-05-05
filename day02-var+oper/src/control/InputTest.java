package control;

import java.util.Scanner;
//import java.lang.System;
//import java.lang.String;
//
//import java.lang.*;

//코드하고 나서 저장한 후 컴파일하면 자동으로 import java.lang.*;를 넣어줌.

public class InputTest {
    public static void main(String[] args) {
        //컴퓨터에 출력하는 것은 많이 씀.
        //대문자로 바로 쓸 수 있음.
        System.out.println("모니터에 출력");

        //입력하는 것은 잘쓰지 않음.
        //램에 새롭게 넣어주어야함.
        //--> new 넣고싶은클래스명();
        //금요일 자세히 나온다.!!!
        Scanner scanner = new Scanner(System.in);
        System.out.println("참조형 변수 출력(주소)>> " + scanner);

        //System: 컴퓨터
        //. : 접근연산자
        //System.in : 컴퓨터의 기본 input장치(키보드)
        //System.out : 컴퓨터의 기본 output창지(모니터, 터미널/콘솔)
        //어디에 새롭게 넣어주었는지 변수를 만들어서
        //주소(위치) 넣어주어야함.
        //변수명 앞에는 반드시 그 주소에 어떤
        //유형이 들어있는지 써주어야함.
        String data = scanner.nextLine(); //여러분이 터미널/콘솔에서 입력한 한줄을 자바 코드로 가지고 들어온다.(입력)
        //가지고 들어와서 변수에 저장해두자.
        //사용자가 입력한 데이터들은 모두 무슨 타입??? 문자열타입(String)
        System.out.println("입력값은 " + data);

        String data2 = scanner.nextLine(); //숫자를 입력해보자.
        System.out.println("입력값은 " + (data2 + 1));
    }
}
