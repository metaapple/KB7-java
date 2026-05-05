package test;

public class Student2 {

    String id;//꼭 필요한 필드
    String name;

    Student2(String id, String name) {
        this.id = id;
        this.name = name;
    }

//    @Override
//    public boolean equals(Object obj) {
//        boolean result = false;
//  //객체가 동일한지 비교할 때는 내부 필드의 값들이 동일한지 비교해야함.
////------------  if (obj instance of Studuent2){ Student2 s = (Student2) obj;}
////------------  if (obj instanceof Student2 s)와 동일
//        if (obj instanceof Student2 s) {
//            result = s.id.equals(id) && s.name.equals(name);
//        }
//        return result;
//    }

// //객체가 동일한지 비교할 때는 내부 필드의 값들이 들어있는 동일한지 비교해야함.
//    @Override
//    public int hashCode() {
//        return id.hashCode() + name.hashCode();
//    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
