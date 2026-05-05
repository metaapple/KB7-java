package test;

//public class Person extends Object
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("먹다.");
    }

    public void sleep() {
        System.out.println("자다.");
    }

    //Object으로 부터 메서드 5개를 포함하고 있음.


}
