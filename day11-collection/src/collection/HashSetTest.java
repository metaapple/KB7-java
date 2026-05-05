package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");
        set.add("Spring");

        System.out.println(set); //모음전체 프린트
        System.out.println(set.size()); //개수

        //set은 순서가 없음, index가 없음.
        //순서없이 모아놓았기 때문에 하나씩 있는지 체크하고 있으면 꺼내오고 반복
        Iterator<String> iterator = set.iterator();
        //외부 반복자를 만들어서 반복해서 있는지 체크하고 있으면 꺼내올 수 있음.

        while (iterator.hasNext()){
            String e = iterator.next();
            System.out.println("꺼낸 값은 " + e);
        }

        set.remove("JDBC");
        System.out.println(set);

        //for-each문 컬렉션에 사용 가능
        for (String s : set){
            System.out.println(s);
        }
    }
}
