package collection;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("홍길동");
        treeSet.add("김길동");
        treeSet.add("정길동");
        treeSet.add("홍길동");
        System.out.println(treeSet);

        // 비교할 수 있는 기준이 없어서 실행되지 않음.
        // 비교할 수 있는 메서드를 만들어주어야 함.
//        TreeSet<Person> treeSet2 = new TreeSet<>(); //unique, 정렬
//        treeSet2.add(new Person("홍길동", 100));
//        treeSet2.add(new Person("김길동", 200));
//        treeSet2.add(new Person("홍길동", 100));
//        System.out.println(treeSet2);

        TreeSet<Person2> treeSet2 = new TreeSet<>(); //unique, 정렬
        treeSet2.add(new Person2("홍길동", 100));
        treeSet2.add(new Person2("김길동", 200));
        treeSet2.add(new Person2("홍길동", 100));
        System.out.println(treeSet2);
    }
}
