package libs;

import java.util.StringTokenizer;

public class TokenPractice {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");

        System.out.println("[split 결과]");
        for (String name : arr) {
            System.out.println(name);
        }

        System.out.println();

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/");

        System.out.println("[StringTokenizer 결과]");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}

//[split 결과]
//홍길동
//이수홍
//박연수
//
//[StringTokenizer 결과]
//홍길동
//이수홍
//박연수


