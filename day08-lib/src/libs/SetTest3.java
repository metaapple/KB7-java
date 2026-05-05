package libs;

import java.util.HashSet;
import java.util.Set;

public class SetTest3 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Student2("1", "홍길동")); //해시코드(주소1)
        set.add(new Student2("2", "김길동")); //해시코드(주소2)
        System.out.println(set);
        System.out.println(set.size());
        set.add(new Student2("1", "홍길동")); //해시코드(주소3)
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains(new Student2("1", "홍길동")));
    }
}
