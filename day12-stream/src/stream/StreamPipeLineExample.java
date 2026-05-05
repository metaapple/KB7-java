package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("홍길동", 10));
        list.add(new Student("신용권", 20));
        list.add(new Student("유미선", 30));

        List<Student> list2 = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        //스트림으로 처리하고 싶음.
        //대부분의 중간/최종처리하는 메서드는 함수형인터페이스를 쓸 수 있음.
        //메서드호출 + 람다식을 사용할 수 있음.
        int result = list2.stream().mapToInt( student -> student.getScore()).sum();
        System.out.println(result);


        OptionalDouble result2 = list2.stream().mapToInt(student -> student.getScore()).average();
        System.out.println(result2.getAsDouble());
        System.out.println(result2.isPresent());

        //OptionalDouble --> 필드 value, isPresent
        //계산 한 평균값을 value에 넣어주고, 평균값이 있는지 isPresent에 넣어줌.
        //필드는 private, getAsDouble() --> value를 꺼낼 수 있음.
        //계산결과값이 있는지 확인 isPresent()를 사용하면 됨.

    }
}
