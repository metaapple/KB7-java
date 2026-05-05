package test;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Student("1", "홍길동"));
        set.add(new Student("2", "김길동"));
        System.out.println(set);
        System.out.println(set.size());
        set.add(new Student("1", "홍길동"));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains(new Student("1", "홍길동")));

        /////  set : 중복된 것을 자동으로 넣어주지 않음.
        //  [Student(id=2, name=김길동), Student(id=1, name=홍길동)]
        //  2
        //  [Student(id=2, name=김길동), Student(id=1, name=홍길동)]
        //  2
        //  true
        /////
    }
}



