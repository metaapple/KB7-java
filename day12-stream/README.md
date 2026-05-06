<br>

<img width="1149" height="1369" alt="스트림" src="https://github.com/user-attachments/assets/a5cc442d-3c62-4a0b-90f4-d3fff66eb563" />


<br>


# ☕ Java Basic Learning - Day 12 (Stream / Optional)

Day12는 자바 **Stream(스트림) 파이프라인**을 이용해 컬렉션 데이터를 **선언형(메서드 체이닝)** 으로 처리하고,  
집계 결과에서 자주 등장하는 **OptionalDouble**의 의미와 사용법을 예제로 정리한 프로젝트입니다.

---

## 핵심 개념 한 장 요약

- **Stream 파이프라인**
  - 데이터 소스(컬렉션/배열 등) → 중간 연산 → 최종 연산(집계/수집) 형태로 처리합니다.
  - 스트림은 데이터를 “저장”하기보다 “흘려보내며 처리”하는 개념입니다.
- **중간 연산(Intermediate)**
  - 예: `map`, `filter`, `mapToInt` 등
  - 보통 **지연 실행(lazy)** 되어, 최종 연산이 호출될 때 실제로 동작합니다.
- **최종 연산(Terminal)**
  - 예: `sum`, `average`, `collect` 등
  - 최종 연산이 실행되면 파이프라인이 종료됩니다.
- **OptionalDouble**
  - 평균처럼 “값이 없을 수도 있는 결과”를 안전하게 표현하기 위한 래퍼 타입입니다.
  - 예: 빈 스트림에서 `average()`를 호출하면 결과가 비어 있을 수 있습니다.

---

## 실행 흐름 그림(mermaid)

### 1) Stream 파이프라인 전체 흐름

```mermaid
flowchart LR
  S["Source: List<Student>"] --> ST["stream()"]
  ST --> M["mapToInt(score)"]
  M --> SUM["sum() → int"]
  M --> AVG["average() → OptionalDouble"]
```

### 2) OptionalDouble 사용 흐름

```mermaid
flowchart TB
  A["average() 결과"] --> B{"값이 존재?"}
  B -->|Yes| C["getAsDouble()로 값 꺼냄"]
  B -->|No| D["isPresent()==false (값 없음)"]
```

---

## 코드 + 설명 (코드 아래에 바로 해설)

### `Student.java` (도메인 객체)

```java
package stream;

public class Student {
    private String name;
    private int score;

    public Student (String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}
```

- 스트림의 소스 데이터로 사용할 `Student` 클래스입니다.
- `score`를 스트림에서 꺼내 숫자 집계를 수행합니다.

---

### `StreamPipeLineExample.java` (sum / average 집계)

```java
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

        int result = list2.stream()
                .mapToInt(student -> student.getScore())
                .sum();
        System.out.println(result);

        OptionalDouble result2 = list2.stream()
                .mapToInt(student -> student.getScore())
                .average();
        System.out.println(result2.getAsDouble());
        System.out.println(result2.isPresent());
    }
}
```

- `mapToInt(student -> student.getScore())`
  - `Student` 스트림을 **IntStream**으로 바꿔서 숫자 집계에 최적화된 연산(`sum`, `average`)을 사용합니다.
- `sum()`
  - 점수 합계를 `int`로 반환합니다.
- `average()`
  - 평균은 값이 없을 수 있어 `OptionalDouble`로 반환됩니다.
  - 값이 있다고 가정하면 `getAsDouble()`로 꺼낼 수 있고, 존재 여부는 `isPresent()`로 확인합니다.

---

## Stream vs 전통 반복문 비교(개념)

| 구분 | 전통 반복문 | Stream |
|---|---|---|
| 스타일 | 명령형(어떻게) | 선언형(무엇을) |
| 코드 형태 | 루프 + 누적 변수 | 파이프라인(체이닝) |
| 읽기/수정 | 로직이 길어질 수 있음 | 연산 단위로 읽기 쉬움 |
| 확장 | 조건/변환이 늘면 복잡 | `filter/map/...`로 조합 |

---

## OptionalDouble 빠른 표

| 메서드 | 의미 |
|---|---|
| `isPresent()` | 값이 존재하면 `true` |
| `getAsDouble()` | 값을 `double`로 꺼냄(없으면 예외 가능) |

> 실무에서는 보통 `isPresent()` 체크 또는 `orElse(...)` 계열을 함께 사용해 “값 없음”을 안전하게 처리합니다.

---

## 어떻게 실행하나요?

### IntelliJ IDEA 기준
- `day12-stream/src/stream`에서 `StreamPipeLineExample`의 `main()` 실행

<br>
<hr>
<br>

## 학습 포인트 체크리스트

- 스트림 파이프라인이 **Source → 중간 연산 → 최종 연산** 구조라는 걸 설명할 수 있는가?
- `mapToInt()`를 쓰면 왜 `sum()`/`average()`를 편하게 쓸 수 있는가?
- `average()`가 `OptionalDouble`을 반환하는 이유를 설명할 수 있는가?

<br>

<img width="1122" height="1402" alt="image" src="https://github.com/user-attachments/assets/19692ecd-f39a-4df1-bc16-a7c9330c155b" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_4" src="https://github.com/user-attachments/assets/d0b43ca7-0582-4e46-9fa8-d1c85afd2a49" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_5" src="https://github.com/user-attachments/assets/0199849f-6a7d-40f6-a5eb-5575a8a7e9f2" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_6" src="https://github.com/user-attachments/assets/0f1e9772-dfcb-47cf-99af-ce7678f6abec" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_7" src="https://github.com/user-attachments/assets/e3531f36-c9b1-4ee0-bdb2-9208928e9edd" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_11" src="https://github.com/user-attachments/assets/5b90a9c6-f713-4fbd-b168-cdde1eac4b72" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_12" src="https://github.com/user-attachments/assets/00a6911f-e6aa-4ed3-abb9-7b7268e88d2c" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_24" src="https://github.com/user-attachments/assets/a31ebbff-f307-4523-8b15-275086569b67" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_34" src="https://github.com/user-attachments/assets/36f4d0d9-0bd1-4b6b-9a87-0b4227972439" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_36" src="https://github.com/user-attachments/assets/4624794d-9a46-42cb-b3ee-ed6544f05c1c" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_40" src="https://github.com/user-attachments/assets/54b8b0f5-9fd9-4ec8-b7b5-b4a5a7e8cc82" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_41" src="https://github.com/user-attachments/assets/0c076af3-daf7-41b9-a76d-e3e5676f437e" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_42" src="https://github.com/user-attachments/assets/97ca84bd-d29e-4747-bf04-15bf4ffb4340" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_43" src="https://github.com/user-attachments/assets/0b2ecaaa-4c9b-4bb1-af27-808ed963429c" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_44" src="https://github.com/user-attachments/assets/a1413456-4faf-4b23-8b2f-ea87084a64e7" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_45" src="https://github.com/user-attachments/assets/77b5f0aa-bbad-4898-bcb2-25b2fde6dc96" />

<img width="2208" height="1242" alt="6FD1EA1EF645EF159C800A38167B2A44_46" src="https://github.com/user-attachments/assets/a83c7a8a-e79f-476a-b978-d27858a750f2" />


<br>
- 디버거
<img width="1024" height="1536" alt="image" src="https://github.com/user-attachments/assets/792604a8-62ff-433c-921e-a102f7b1e93c" />
<img width="3795" height="1973" alt="image" src="https://github.com/user-attachments/assets/d6a16b1a-1cc5-4d01-ab50-e4e507f3e136" />
<img width="1699" height="1987" alt="image" src="https://github.com/user-attachments/assets/1840d777-50d0-483d-a78b-0e97153abebe" />
<img width="3506" height="1403" alt="image" src="https://github.com/user-attachments/assets/04ba5b15-c380-43c3-b459-e5e1f38f5952" />
<img width="3579" height="1787" alt="image" src="https://github.com/user-attachments/assets/c63c0ce7-0eb8-4e2d-8f27-ee480fe4fb15" />
<img width="2548" height="1358" alt="image" src="https://github.com/user-attachments/assets/b7c9fe8d-ba9d-4d42-a6bf-fd15dfc9e96a" />
<img width="2543" height="1351" alt="image" src="https://github.com/user-attachments/assets/f5377fc3-5793-436d-802d-11412ebc4e43" />

<hr>

- 멀티코어 CPU → 동시에 4개 작업 처리 가능 (CPU 1개, Core 4개 (쿼드코어) <br>
- 내부 반복자 + 멀티코어 (컬렉션 내부에서 데이터를 나눠서 여러 코어에 자동 분배) <br>

<img width="1002" height="1614" alt="image" src="https://github.com/user-attachments/assets/33560dd6-2fe6-435a-afc3-e59ff3527447" />
<br>
<img width="2037" height="1234" alt="image" src="https://github.com/user-attachments/assets/5348c4f1-8002-4eca-8a35-876aff9f59d8" />
<br>

<img width="1480" height="581" alt="image" src="https://github.com/user-attachments/assets/37ccd42d-e379-4308-ab98-75f1ebbac539" />




