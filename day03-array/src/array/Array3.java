package array;

import java.util.Arrays;

public class Array3 {
    public static void main(String[] args) {
        //배열 생성시 값을 모르고 있는 경우
        //일단 초기화된 공간을 만든다.
        //1. 1차원배열의 요소 개수를 다 똑같이 맞추고 싶은 경우
        int[][] scores = new int[2][3];
        //2행 3열의 2차원 배열의 생김
        //0 0 0
        //0 0 0

        //2. 1차원배열의 요소 개수를 다르게 하고 싶은 경우
        int[][] scores2 = new int[2][];
        scores2[0] = new int[3];
        //1차원 배열 만들때 이미 만들어진 변수에 넣는 경우
        //1. 0으로 된 초기화를 넣는 경우
        //scores2[1] = new int[2];
        //2. 원하는 값으로 넣어서 만드는 경우
        scores2[1] = new int[] {1, 2};
        // scores2[1] = {1, 2}; --> XXXX
        //0 0 0
        //1 2

        //배열의 주소가 들어가는 변수가
        //미리 만들어진 경우
        int[] scores3 = null;
        //scores3 = new int[3]; 문제없음.
        //scores3 = {1, 2, 3}; 문제있음.
        scores3 = new int[] {1,2,3};

        System.out.println(Arrays.toString(scores3));

    }
}
