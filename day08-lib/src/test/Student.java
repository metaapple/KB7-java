package test;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//다른 생성자 어노테이션이 있으면 @Data라고 썼더라도
//별도로 써주어야 적용됨.
public class Student {

    @NonNull
    String id;//꼭 필요한 필드
    String name;

}
