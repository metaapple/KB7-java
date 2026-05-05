package test;

import java.util.HashSet;
import java.util.Set;

public class SetTest3 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Student2("1", "홍길동"));
        set.add(new Student2("2", "김길동"));
        System.out.println(set);
        System.out.println(set.size());
        set.add(new Student2("1", "홍길동"));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains(new Student2("1", "홍길동")));

        /////  set : 필드가 들어있는 주소와 값들이 동일한지 오버라이드해주지 않고
        //           객체의 주소만 비교하면 의도와는 다르게 처리됨.
        //  [1 홍길동, 2 김길동]
        //  2
        //  [1 홍길동, 1 홍길동, 2 김길동]
        //  3
        //  false


        //equals()와 hashcode() 오버라이드 후 -------------------------------
        /////  set : 필드가 들어있는 주소와 값들이 동일한지 오버라이드해주면
        //           중복체크를 제대로 해줌.
        // [2 김길동, 1 홍길동]
        // 2
        // [2 김길동, 1 홍길동]
        // 2
        // true

    }
}



