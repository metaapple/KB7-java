package test;
//import java.lang.*;
public class Man extends Person {
    int power;

    public Man(String name, int age, int power) {
        super(name, age);
        this.power = power;
    }

    public void run(){
        System.out.println("빨리 달리다.");
    }

    //메서드 개수 : 8개
    //필드 개수 : 3개
}
