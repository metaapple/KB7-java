package array;

public class Array2 {
    public static void main(String[] args) {
       //2차원 배열
        // 1차원 배열을 묶어놓은 것

        //배열생성시 값을 이미 알고 있는 경우
        int[][] scores = {
                { 80, 90, 96},
                { 76, 88}
        };

        //배열 --> 반복문(for)
        //1차원 배열 --> for문 1개
        //2차원 배열 --> for문 2개

        //2차원 배열의 전체 행수
        System.out.println(scores.length); //2
        //첫번째 행의 1차원 배열의 개수
        System.out.println(scores[0].length); //3
        //두번째 행의 1차원 배열의 개수
        System.out.println(scores[1].length); //2

        //2차원 배열내의 특정한 요소를 접근
        System.out.println(scores[0][0]);
        System.out.println(scores[0][2]);
        System.out.println(scores[1][1]);

        //2차원인덱스 증가할 for문 하나
        //1차원인덱스 증가할 for문 하나
        for (int i = 0; i < scores.length ; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println(scores[i][j]);
            }
        }
    }
}
