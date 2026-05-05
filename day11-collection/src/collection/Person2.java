package collection;

import java.util.Objects;

public class Person2 implements Comparable<Person2>{
    public String name;
    public int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //객체를 비교할 일이 있을 때, TreeSet, TreeMap는 무조건 비교할 수 있는 메서드를 찾아서 비교함.
    //객체비교(동일 --> equals(), hashCode(), 객체내의 필드의 값, 위치를 비교하는 코드를 넣어주어야함.)
    //객체비교(크기 --> compareTo(), 객체내의 필드로 비교 코드를 넣어주어야함.)

    @Override
    public boolean equals(Object o) { //객체의 필드값들 비교
        if (!(o instanceof Person2 person2)) return false;
        return age == person2.age && Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() { //객체의 필드 주소들 비교
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person2 o) {
        if (age < o.age) return -1;
        else if (age == o.age) return 0;
        else return 1;
    }


    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}