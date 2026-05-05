package test;

import java.util.Objects;

public class Person2 implements Comparable<Person2> {
    public String name;
    public int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //객체 비교(동일) --> 값: equals(), 주소: hashcode()
    //생성된 객체 필드의 값과 주소가 동일한지 비교


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person2 person2)) return false;
        return age == person2.age && Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //객체 비교(누가 더 큰가/작은가)
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