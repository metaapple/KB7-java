package test;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("kim");
        set.add("park");
        System.out.println(set);
        System.out.println(set.size());
        set.add("kim");
        System.out.println(set);
        System.out.println(set.size());

        /////  set : 중복된 것을 자동으로 넣어주지 않음.
        //  [kim, park]
        //  2
        //  [kim, park]
        //  2
        /////
    }
}



