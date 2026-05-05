package libs;

public class StudentUse {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId("100");
        System.out.println(s);

        Student s1 = new Student("200");
        System.out.println(s1);
    }
}
