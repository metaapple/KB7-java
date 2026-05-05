package libs;

import lombok.*;

//@ToString
@NoArgsConstructor
@AllArgsConstructor
//다른 생성자와 함께 @Data를 사용하는 경우
//@RequiredArgsConstructor를 자동생성해주지 않음.
//별도로 명시해야함.
@RequiredArgsConstructor
//@Getter
//@Setter
@Data //equals(), hashCode()재정의해주어서 객체 중복처리 문제없음.
public class Student {

    @NonNull
    private String id;
    private String name;

}
