package array;

import java.util.Arrays;

public class Array4 {
    public static void main(String[] args) {
        int[] num3 = {100, 200, 300};
        //1. 얕은 복사(주소만 복사)
        //--> 지역변수의 주소가 복사
        int[] num4 = num3;

        System.out.println("num3주소>> " + num3);
        System.out.println("num4주소>> " + num4);

        num3[0] = 999;
        System.out.println(Arrays.toString(num3));
        System.out.println(Arrays.toString(num4));

        //2. 깊은 복사(주소가 가르키고 있는 배열값들 복사)
        //--> 힙영역의 데이터들이 복사가 됨.
        //--> 새로운 주소가 만들어짐.

        int[] num5 = num3.clone();
        num3[0] = 555;
        System.out.println(Arrays.toString(num3));
        System.out.println(Arrays.toString(num5));

        //특별한 경우를 제외하고는
        //일반적으로 배열은 깊은 복사를 많이 쓴다.
        System.out.println(num3);
        System.out.println(num5);
    }
}
