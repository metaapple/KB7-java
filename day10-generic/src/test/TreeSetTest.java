package test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("홍길동");
        treeSet.add("김길동");
        treeSet.add("정길동");
        System.out.println(treeSet);

        //자동 정렬해주는 기능이 있는데, 주소를 가지고 대소를 비교할 수 없으므로
        //내부적으로 정렬기능 수행못함. 에러
        //비교할 수 있는 메서드를 구현해주어야함.
        //Comparable 인터페이스 구현
//        TreeSet<Person> treeSet2 = new TreeSet<>();
//        treeSet2.add(new Person("홍길동", 100));
//        treeSet2.add(new Person("김길동", 200));
//        treeSet2.add(new Person("홍길동", 100));
//        System.out.println(treeSet2);

//        Exception in thread "main" java.lang.ClassCastException: class test.Person cannot be cast to class java.lang.Comparable (test.Person is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
//        at java.base/java.util.TreeMap.compare(TreeMap.java:1569)
//        at java.base/java.util.TreeMap.addEntryToEmptyMap(TreeMap.java:776)
//        at java.base/java.util.TreeMap.put(TreeMap.java:785)
//        at java.base/java.util.TreeMap.put(TreeMap.java:534)
//        at java.base/java.util.TreeSet.add(TreeSet.java:255)
//        at test.TreeSetTest.main(TreeSetTest.java:16)


        TreeSet<Person2> treeSet3 = new TreeSet<>();
        treeSet3.add(new Person2("홍길동", 100));
        treeSet3.add(new Person2("김길동", 200));
        //정렬의 대상인 age가 100으로 동일하므로 들어가지 않음.
        treeSet3.add(new Person2("홍길동", 100));
        System.out.println(treeSet3);

        Set<Person2> set = new HashSet<>();
        set.add(new Person2("홍길동", 100));
        set.add(new Person2("김길동", 200));
        set.add(new Person2("홍길동", 100));
        System.out.println(set);


//[김길동, 정길동, 홍길동]
//[Person2{name='홍길동', age=100}, Person2{name='김길동', age=200}]
// equals(), hashcode()를 재정의해주지 않으면 new로 생성한 주소가 모두 다르므로
// 중복이 되지 않았다고 봄.
//[Person2{name='김길동', age=200}, Person2{name='홍길동', age=100}, Person2{name='홍길동', age=100}]
//equals(), hashcode()를 재정의후
//[Person2{name='김길동', age=200}, Person2{name='홍길동', age=100}]
    }
}
