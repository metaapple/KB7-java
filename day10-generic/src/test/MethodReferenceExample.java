package test;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person3 person = new Person3();
        person.action( (x, y) -> x + y  );
        person.action( Computer :: staticMethod);
        Computer computer = new Computer();
        person.action( computer :: instanceMethod);
    }
}
