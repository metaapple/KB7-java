package generic;


import java.util.ArrayList;

public class GenericTest2 {
    public static void main(String[] args) {
      //ArrayList은 객체생성할 때 원하는 타입으로 특정해서 만들 수 있는 제너릭 클래스
        // 불필요한 형변환을 하지 않아도 됨.
        ArrayList<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("홍길동");
        list.add("김길동");
        System.out.println(list.get(0).charAt(0));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(200);
        System.out.println(list2.get(0).intValue());
//        ArrayList<Student> list3 = new ArrayList<>();
//        ArrayList<Board> list4 = new ArrayList<>();

    }
}
