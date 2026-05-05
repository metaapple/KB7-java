package libs;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        //많은 양의 데이터를 쓰고 싶어 + 중복도 체크해주고 싶은 경우
        //Set(인터페이스, 규칙, 큰)--->HashSet(클래스, 작)
        Set set =  new HashSet();
        set.add("홍길동");
        set.add("김길동");
        System.out.println(set);
        System.out.println(set.size());
        set.add("홍길동");
        System.out.println(set);
        System.out.println(set.size());
    }
}
