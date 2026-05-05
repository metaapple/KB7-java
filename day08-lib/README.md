
<img width="1024" height="1536" alt="image" src="https://github.com/user-attachments/assets/18c63248-c22f-4648-a701-46013443eec6" />

<br>

<img width="1197" height="1315" alt="image" src="https://github.com/user-attachments/assets/6d16e495-03d0-480d-8d40-055cf4f5cd6e" />

<br>

<img width="1024" height="1536" alt="image" src="https://github.com/user-attachments/assets/02a52545-5c79-4db2-b206-45cc816062fb" />



<br>

# ☕ Java Basic Learning - Day 8 (주요 라이브러리, Lombok, 예외처리)

Day 8에서는 **외부 라이브러리(Lombok)** 를 사용해 `getter/setter/toString/생성자`를 자동 생성하고,  
`try-catch-finally`와 **try-with-resources**로 예외처리 + 파일 쓰기(`FileWriter`)를 연습합니다.

---

### 🔗 파일 구조 (day8-lib)

```
day8-lib/
├── src/
│   ├── libs/
│   │   ├── Student.java
│   │   ├── StudentUse.java
│   │   ├── TimeCompareTest.java
│   │   ├── SimpleGraphTest.java
│   │   ├── StringBuilderPractice.java
│   │   ├── TokenPractice.java
│   │   ├── DateTimeComparePractice.java
│   │   ├── DateTimeOperationPractice.java
│   │   ├── TimeZonePractice.java
│   │   └── CalendarPractice.java
│   └── test/
│       ├── Test1.java
│       ├── Test2.java
│       ├── Test3.java
│       ├── SetTest1.java
│       ├── SetTest2.java
│       ├── SetTest3.java
│       ├── Student.java
│       └── Student2.java
├── test.txt                    # 파일쓰기 결과(실행 후 생성/갱신)
└── README.md
```

---

### 1) `Student.java` (Lombok: @Data + 생성자 자동 생성)

```java
package libs;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Student {

    @NonNull
    private String no;
    private String name;
}
```

- **핵심**: Lombok을 쓰면 반복 코드(생성자/게터/세터/toString/equals/hashCode)를 자동 생성해서 **코드를 짧게 유지**할 수 있음
- **포인트**: `@NonNull`이 붙은 필드(`no`)는 `@RequiredArgsConstructor`의 생성자 파라미터에 포함됨  
  → 즉, `new Student("200")` 같은 생성이 가능

---

### 2) `StudentUse.java` (기본 생성자 vs 필수 생성자 사용)

```java
package libs;

public class StudentUse {
    public static void main(String[] args) {
        Student s = new Student();
        s.setNo("100");
        System.out.println(s);

        Student s1 = new Student("200");
        System.out.println(s1);
    }
}
```

- **핵심**: `new Student()`는 `@NoArgsConstructor`로 생성된 기본 생성자
- **핵심**: `new Student("200")`는 `@RequiredArgsConstructor`로 생성된 “필수값(no)만 받는 생성자”
- **참고**: `System.out.println(s)`는 Lombok의 `@Data`가 만든 `toString()`이 호출되어 필드가 보기 좋게 출력됨

---

### 3) `Test1.java` (try-catch로 실행 흐름 끊김 방지)

```java
package test;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("1. 나는 프린트될 예정");
        try {
            System.out.println("2. 실행에러 있는 코드 " + 10 / 0);
        } catch (Exception e) {
            // 예외가 발생해도 프로그램이 종료되지 않게 잡아줌
        }
        System.out.println("3. 나는 프린트될까요???");
    }
}
```

- **핵심**: 예외가 나도 `catch`에서 잡으면 프로그램이 바로 종료되지 않고 다음 코드로 진행 가능
- **포인트**: `Exception`으로 넓게 잡을 수도 있지만, 실무/학습에서는 가능한 **구체적 예외부터 잡는 습관**이 좋음

---

### 4) `Test2.java` (FileWriter + 다중 catch + finally)

```java
package test;

import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        try {
            FileWriter file = new FileWriter("test.txt");
            file.write("오늘은 목요일 \n");
            file.write("내일은 깃특강 \n");
            file.write("다음주에 만나요. \n");
            file.close();

            System.out.println(10 / 0);
        } catch (IOException e) {
            System.out.println("파일 쓰기 에러 : " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("수학 에러 : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("위 catch에서 지정하지 않은 예외상황 : " + e.getMessage());
        } finally {
            System.out.println("예외 발생 여부와 상관없이 무조건 실행하는 코드는 여기에 넣어주세요.");
        }
    }
}
```

- **핵심**: `IOException`(파일 관련) / `ArithmeticException`(0으로 나눔) 등 예외 종류별로 다른 메시지/대응이 가능
- **핵심**: `finally`는 예외 발생 여부와 관계없이 실행 → **마무리 작업(정리/로그 등)** 에 자주 사용
- **주의**: `close()`를 까먹으면 스트림이 RAM에 남을 수 있음(자원 누수) → 아래 `Test3`처럼 자동 close를 추천

---

### 5) `Test3.java` (try-with-resources: 자동 close)

```java
package test;

import java.io.FileWriter;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) {
        try (FileWriter file = new FileWriter("test.txt")) {
            file.write("오늘은 목요일 \n");
            file.write("내일은 깃특강 \n");
            file.write("다음주에 만나요. \n");
            System.out.println(10 / 0);
        } catch (IOException e) {
            System.out.println("파일 쓰기 에러 : " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("수학 에러 : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("위 catch에서 지정하지 않은 예외상황 : " + e.getMessage());
        } finally {
            System.out.println("예외 발생 여부와 상관없이 무조건 실행하는 코드는 여기에 넣어주세요.");
        }
    }
}
```

- **핵심**: `try (...) {}` 괄호 안에 자원을 선언하면, 블록이 끝날 때 **자동으로 close()** 됨
- **추천**: 파일/DB/네트워크처럼 “열고 닫는” 자원은 try-with-resources 형태가 안전함

---

### 표로 요약

#### 1) Lombok 어노테이션 정리

| 어노테이션 | 의미 | Student에서의 효과 |
|---|---|---|
| `@Data` | `@Getter/@Setter/@ToString/@EqualsAndHashCode/@RequiredArgsConstructor` 포함(기본 구성) | getter/setter/toString 자동 생성 |
| `@NoArgsConstructor` | 기본 생성자 생성 | `new Student()` 가능 |
| `@RequiredArgsConstructor` | `final` 또는 `@NonNull` 필드만 받는 생성자 생성 | `new Student("200")` 가능 |
| `@NonNull` | null 체크 대상(필수 값) | `no`가 “필수 생성자” 파라미터에 포함 |

#### 2) 예외처리 흐름 정리

| 구분 | 언제 실행? | 목적 |
|---|---|---|
| `try` | 정상 코드 실행 구간 | 예외가 날 수 있는 코드 묶기 |
| `catch` | try에서 예외 발생 시 | 예외를 잡고 대체 흐름 처리 |
| `finally` | 예외 발생 여부와 무관 | 정리/마무리/로그 같은 공통 처리 |

---

### 그림으로 이해하기

#### 1) Lombok 기반 객체 생성 흐름

```mermaid
flowchart TD
  A["Student.java"] --> B["@NoArgsConstructor"]
  A --> C["@RequiredArgsConstructor"]
  A --> D["@Data"]

  B --> E["new Student()"]
  C --> F["new Student(no)"]
  D --> G["s.setNo(...)\ns.setName(...)"]
  D --> H["System.out.println(s)\n(toString 호출)"]
```

#### 2) try-catch-finally 실행 흐름

```mermaid
flowchart TD
  A[try 블록 실행] --> B{예외 발생?}
  B -- 아니오 --> C[정상 진행]
  B -- 예 --> D[catch에서 처리]
  C --> E[finally 실행]
  D --> E[finally 실행]
  E --> F[다음 코드 진행/종료]
```

---

### 실행 방법 (간단)

IntelliJ에서 각 `main()` 클래스 우클릭 → Run.

- `libs.StudentUse` 실행: Lombok 생성자/세터/toString 확인
- `test.Test1` 실행: try-catch 흐름 확인
- `test.Test2` 실행: `FileWriter`로 `test.txt` 생성 + 예외/ finally 흐름 확인
- `test.Test3` 실행: try-with-resources로 자동 close 확인
  <br>
  <br>
- 인텔리제이 auto import 설정
  <img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/375bad67-23d3-4f55-8cf0-3522078d436f" />
<hr>
- jdk17 라이브러리 api문서 : https://docs.oracle.com/en/java/javase/17/docs/api/index.html
<br>
<hr>
<br>
- 예외처리
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/f80e68ad-691a-4b20-b647-3322cf2aed85" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/4c67faa2-e375-4f90-8ed2-d9e3a1fe8e41" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/22316b0f-b331-4ef4-a4ba-43b56d54f9d1" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/c5283a8a-1c6b-49f8-8e85-285c6f392d40" />
<img width="1622" height="970" alt="image" src="https://github.com/user-attachments/assets/dbc56adf-5e01-4c76-a569-13a4ecfded54" />
<img width="1631" height="964" alt="image" src="https://github.com/user-attachments/assets/bc1a5c3b-5b82-4c31-88a6-622e90d84afd" />
<img width="1619" height="971" alt="image" src="https://github.com/user-attachments/assets/a7e334d4-fcf6-4873-ac92-c9af24c2ce1d" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/fe9ced24-cb24-434a-a13c-395db014d123" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/20cabba5-2f4f-4081-8a1a-4b641f6249a2" />
<br>
- 인텔리제이에서 try-catch자동생성
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/9ebd3e6b-85b2-43ee-981e-c735c6064250" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/e14ab384-34c5-4477-8796-99910727283a" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/9cd1efc3-805c-4de2-88f3-b78c4b8d8692" />


<br>
<hr>
- 하나의 프로젝트안에서 모듈 별 구현 가능하다. <br>
- 자바는 프로젝트를 다 완성하면 jar로 압축해서 서버로 파일을 옮긴다.

<img width="2554" height="1418" alt="image" src="https://github.com/user-attachments/assets/0fd9604c-25f9-47a7-ae4b-aa588ca97a12" />
<img width="2553" height="1425" alt="image" src="https://github.com/user-attachments/assets/efa24f0a-f31c-44c4-bf61-10afb57ffaa9" />


- 회사에서 사용할 라이브러리 만들기
  --> 모듈만들기(jar파일로 묶어야함.) --> 사용하기

```
모듈만들기(jar파일로 묶어야함.) --> 사용하기package test;

// day8-libs 프로젝트 아래 test패키지
package test;

public class Cal {
    public void add(int a, int b) {
        int c = a + b;
        System.out.println(c);
    }

    public void sub(int a, int b) {
        int c = a - b;
        System.out.println(c);
    }
}

// -----------------------------------

package test;

public class Cal2 {
    public void mul(int a, int b) {
        int c = a * b;
        System.out.println(c);
    }

    public void div(int a, int b) {
        int c = a / b;
        System.out.println(c);
    }
}

//day8-lib 프로젝트 아래 test패키지


public class LibTest {
    public static void main(String[] args) {
        Cal cal = new Cal();
        cal.add(100, 200);
        Cal2 cal2 = new Cal2();
        cal2.mul(100, 200);
    }
}

```

<img width="1996" height="1952" alt="image" src="https://github.com/user-attachments/assets/e9a85b2c-06ce-4c82-9550-f192fa258ff0" />
<img width="3828" height="2062" alt="image" src="https://github.com/user-attachments/assets/d9f90223-5759-4fa1-9324-efbf28536e14" />
--> 다른 프로젝트에서 사용
<img width="1997" height="1951" alt="image" src="https://github.com/user-attachments/assets/e38c0dfe-9169-45ae-9b49-2127abe72220" />
<img width="994" height="614" alt="image" src="https://github.com/user-attachments/assets/c2d3d3d7-ec9c-47f5-b441-138ce0857bff" />
<img width="2580" height="2071" alt="image" src="https://github.com/user-attachments/assets/1b9dbeac-dfd3-4790-bb8e-cbde1f05191f" />
<img width="960" height="441" alt="image" src="https://github.com/user-attachments/assets/eec9cc23-0efa-4dab-a3ee-5419e4d45b01" />
<img width="3239" height="1338" alt="image" src="https://github.com/user-attachments/assets/984b779a-126b-4264-a032-d9bb2d50077b" />

<br>

<img width="2286" height="1307" alt="image" src="https://github.com/user-attachments/assets/1dcdef0a-a628-4615-ad37-a3d9dbc19d92" />
<img width="44" height="44" alt="image" src="https://github.com/user-attachments/assets/dc871793-5a37-4440-8e2e-f57bfaab583b" />

<br>
- 롬복라이브러리 <br>
--> 클래스의 기본 구조에 해당하는 메서드를 자동으로 생성해줌<br>
--> 다운로드 : https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.40<br>
--> 현재 우리가 사용하는 버전에서는 @NoArgsConstructor, @AllArgsConstructor와 함께 @Data를 사용하는 경우 기본 생성자만 만들어집니다.<br>
--> 함께 사용하는 경우 별도로 @RequiredArgsConstructor를 명시해주세요.!!<br>
<img width="2350" height="1846" alt="image" src="https://github.com/user-attachments/assets/81144ea1-d179-48c2-9690-ed327caeee59" />
<img width="3694" height="1926" alt="image" src="https://github.com/user-attachments/assets/855d48fc-260a-4fbe-a022-187e73393829" />

```

package test;

import lombok.*;

@ToString
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Bag {

    @NonNull
    private String name;
    private String description;
    private double price;
}

--------------------------

package test;


public class LombokTest {
    public static void main(String[] args) {
        Bag bag = new Bag("홍길동",
                "목요일이야",
                1000);

        System.out.println(bag.getName());
        bag.setName("김길동");
        System.out.println(bag);


    }
}

```
- record도 일부 자동생성해주는 기능이 있음. 메서드이름이 약간 다름
  <img width="3441" height="1925" alt="image" src="https://github.com/user-attachments/assets/58a309a5-f962-4eef-b83d-085a73259bf8" />
  <br>


```
package test;

public record MemberRecord(String id, String name, int age) {
}

-----------------------
package test;

public class MemberRecordUse {
    public static void main(String[] args) {
        MemberRecord m1 = new MemberRecord("winter", "눈송이", 25);
        MemberRecord m2 = new MemberRecord("winter", "눈송이", 25);

        System.out.println(m1.id());
        System.out.println(m1.name());
        System.out.println(m1.age());
        System.out.println(m1);
        System.out.println("equals: " + m1.equals(m2));
        System.out.println("hashCode 비교: " + (m1.hashCode() == m2.hashCode()));
    }
}

```


- 대표적인 라이브러리
  <img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/194af064-0fd5-46f6-8571-361eb2a71f25" /> <br>
  <img width="1313" height="671" alt="스크린샷 2026-04-25 21 46 17" src="https://github.com/user-attachments/assets/2f97cc9a-fb61-4e0b-b363-9cec40d40744" />
  <img width="1289" height="328" alt="스크린샷 2026-04-25 21 46 48" src="https://github.com/user-attachments/assets/528d1a9f-ceb8-4d9a-9ff9-f311bde9ab17" />
  <img width="1008" height="299" alt="스크린샷 2026-04-25 21 47 10" src="https://github.com/user-attachments/assets/835cf891-00a5-4ac8-8c00-bd861812a19d" />

<br>
- System.nanoTime()을 이용한 성능평가(배열과 List비교)
<br>
<img width="729" height="345" alt="스크린샷 2026-04-25 22 48 04" src="https://github.com/user-attachments/assets/7d72e24a-159a-4985-ba84-a33aff87c25b" />
<br>

<img width="1102" height="429" alt="스크린샷 2026-04-25 22 55 48" src="https://github.com/user-attachments/assets/09b5f85c-9eb0-49ea-ba5a-0f63a7263cc9" />

<br>

```
package test;

import java.util.ArrayList;
import java.util.LinkedList;

public class TimeCompareTest {

    public static void main(String[] args) {

        final int SIZE = 100000;

        // =========================
        // 1. 배열
        // =========================
        int[] arr = new int[SIZE];

        long start = System.nanoTime();

        // 값 넣기
        for (int i = 0; i < SIZE; i++) {
            arr[i] = i;
        }

        long end = System.nanoTime();
        System.out.println("배열 입력 시간: " + (end - start));

        start = System.nanoTime();

        // 조회
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += arr[i];
        }

        end = System.nanoTime();
        System.out.println("배열 조회 시간: " + (end - start));


        // =========================
        // 2. ArrayList
        // =========================
        ArrayList<Integer> arrayList = new ArrayList<>();

        start = System.nanoTime();

        // 추가
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
        }

        end = System.nanoTime();
        System.out.println("ArrayList 추가 시간: " + (end - start));

        start = System.nanoTime();

        // 조회
        sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += arrayList.get(i);
        }

        end = System.nanoTime();
        System.out.println("ArrayList 조회 시간: " + (end - start));


        // =========================
        // 3. LinkedList
        // =========================
        LinkedList<Integer> linkedList = new LinkedList<>();

        start = System.nanoTime();

        // 추가
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(i);
        }

        end = System.nanoTime();
        System.out.println("LinkedList 추가 시간: " + (end - start));

        start = System.nanoTime();

        // 조회 (⚠️ 매우 느림)
        sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += linkedList.get(i);
        }

        end = System.nanoTime();
        System.out.println("LinkedList 조회 시간: " + (end - start));
    }
}

```

<br>

- 그래프로 비교
  <br>

```
import java.util.*;

public class SimpleGraphTest {

    public static void main(String[] args) {

        int size = 100000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // 데이터 채우기
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // =====================
        // 측정
        // =====================
        long start = System.nanoTime();
        arrayList.get(size / 2);
        long arrayTime = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.get(size / 2);
        long linkedTime = System.nanoTime() - start;

        // =====================
        // 그래프 출력
        // =====================
        printGraph("ArrayList", arrayTime);
        printGraph("LinkedList", linkedTime);
    }

    public static void printGraph(String name, long time) {
        int length = (int)(time / 1000); // scale

        System.out.printf("%-12s | ", name);
        for (int i = 0; i < length; i++) {
            System.out.print("■");
        }
        System.out.println(" " + time + " ns");
    }
}


ArrayList   | ■■■■■ 5000 ns
LinkedList  | ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 500000 ns

```

<br>
<img width="700" height="500" alt="image" src="https://github.com/user-attachments/assets/1c9fcf78-8342-466d-bd13-033d3a33f7d0" />

<br>
- 래퍼클래스(포장클래스) : 형변환 + 포장클래스(클래스 <--- 박싱/언박싱 ---> 기본형)
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/c9bed3d2-4aaa-4d1b-96e4-d1c92ddd34f4" />

<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/b4bcc342-3749-4414-ba8b-eb087055b39a" />
- Wrapper class주의점
- Integer는 immutable (불변 객체)

```


package test;

public class ValueComparePractice {
    public static void main(String[] args) {
        //-128~127범위가 아니므로 각각 주소를 만든다.
        Integer a = 300;
        Integer b = 300;
        System.out.println(a.intValue());
        System.out.println("300 비교");
        System.out.println("주소 비교 == : " + (a == b)); //false
        System.out.println("값 비교 equals : " + a.equals(b)); //true
        System.out.println("a identityHashCode: " + System.identityHashCode(a));
        System.out.println("b identityHashCode: " + System.identityHashCode(b));
        System.out.println("\n값 변경 후");
        a =  100;
        System.out.println("주소 비교 == : " + (a == b)); //false
        System.out.println("a identityHashCode: " + System.identityHashCode(a));
        System.out.println("b identityHashCode: " + System.identityHashCode(b));

        System.out.println("======================");

        //-128-127까지는 클래스로 저장시 미리 넣어둠.
        Integer c = 10;
        Integer d = 10;
        System.out.println("\n10 비교");
        System.out.println("== : " + (c == d)); //true
        System.out.println("equals : " + c.equals(d)); //true
        System.out.println("c identityHashCode: " + System.identityHashCode(c));
        System.out.println("d identityHashCode: " + System.identityHashCode(d));

        System.out.println("\n값 변경 후");
        c = 100;
        System.out.println("== : " + (c == d)); //false
        System.out.println("equals : " + c.equals(d)); //false
        System.out.println("c identityHashCode: " + System.identityHashCode(c));
        System.out.println("d identityHashCode: " + System.identityHashCode(d));
        }
}


```

<br>
<img width="814" height="1386" alt="image" src="https://github.com/user-attachments/assets/b9281d42-cbd5-472c-b494-45dfa81d2819" />



<br>
- StringBuilder

```

public class StringBuilderPractice {
    public static void main(String[] args) {
        String result = new StringBuilder()
                .append("World") //맨 끝에 추가
                .insert(0, "Hello ") //중간에 삽입
                .replace(6, 11, "Java") //일부글자대체
                .toString(); //문자열로생성

        System.out.println(result);
    }
}

```

<br>

- StringTokenizer

```

import java.util.StringTokenizer;

public class TokenPractice {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");

        System.out.println("[split 결과]");
        for (String name : arr) {
            System.out.println(name);
        }

        System.out.println();

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/");

        System.out.println("[StringTokenizer 결과]");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}

```

<br>

- LocalDateTime

```

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class DateTimeComparePractice {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

        LocalDateTime start = LocalDateTime.of(2026, 4, 1, 9, 0, 0);
        LocalDateTime end = LocalDateTime.of(2026, 12, 31, 18, 0, 0);

        System.out.println("시작: " + start.format(dtf));
        System.out.println("종료: " + end.format(dtf));

        if (start.isBefore(end)) {
            System.out.println("종료일 전입니다.");
        } else if (start.isEqual(end)) {
            System.out.println("같은 시각입니다.");
        } else {
            System.out.println("종료일이 지났습니다.");
        }

        System.out.println("남은 월: " + start.until(end, ChronoUnit.MONTHS));
        System.out.println("남은 일: " + start.until(end, ChronoUnit.DAYS));
        System.out.println("남은 시간: " + start.until(end, ChronoUnit.HOURS));
    }
}
```

```

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationPractice {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

        System.out.println("현재 시간: " + now.format(dtf));
        System.out.println("1년 후: " + now.plusYears(1).format(dtf));
        System.out.println("2개월 전: " + now.minusMonths(2).format(dtf));
        System.out.println("7일 후: " + now.plusDays(7).format(dtf));
    }
}

```

<br>

- TimeZone

```

import java.util.Calendar;
import java.util.TimeZone;

public class TimeZonePractice {
    public static void main(String[] args) {
        // 대한민국 시간대
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Seoul");
        Calendar now = Calendar.getInstance(timeZone);

        String amPm = now.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후";

        System.out.println("대한민국 현재 시간");
        System.out.println(amPm + " " +
                now.get(Calendar.HOUR) + "시 " +
                now.get(Calendar.MINUTE) + "분 " +
                now.get(Calendar.SECOND) + "초");
    }
}

```

<br>

- Calender

```
import java.util.Calendar;

public class CalendarPractice {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int week = now.get(Calendar.DAY_OF_WEEK);
        int amPm = now.get(Calendar.AM_PM);
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);

        String weekName;
        switch (week) {
            case Calendar.MONDAY -> weekName = "월";
            case Calendar.TUESDAY -> weekName = "화";
            case Calendar.WEDNESDAY -> weekName = "수";
            case Calendar.THURSDAY -> weekName = "목";
            case Calendar.FRIDAY -> weekName = "금";
            case Calendar.SATURDAY -> weekName = "토";
            default -> weekName = "일";
        }

        String amPmText = (amPm == Calendar.AM) ? "오전" : "오후";

        System.out.println(year + "년 " + month + "월 " + day + "일");
        System.out.println("요일: " + weekName);
        System.out.println(amPmText + " " + hour + "시 " + minute + "분");
    }
}

```

<br>

- Date

```
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePractice {
    public static void main(String[] args) {
        Date now = new Date();

        // 기본 출력
        System.out.println(now.toString());

        // 포맷 출력
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(sdf.format(now));

        // ⭐ Date 기본 메서드들
        System.out.println("\n[Date 기본 메서드]");

        System.out.println("연도: " + (now.getYear() + 1900)); // 1900 기준이라 보정 필요
        System.out.println("월: " + (now.getMonth() + 1));    // 0부터 시작이라 +1
        System.out.println("일: " + now.getDate());

        System.out.println("시간: " + now.getHours());
        System.out.println("분: " + now.getMinutes());
        System.out.println("초: " + now.getSeconds());
    }
}

```

<br>

- Random

```
import java.util.Arrays;
import java.util.Random;

public class RandomLottoPractice {
    public static void main(String[] args) {
        int[] selectNumber = new int[6];
        int[] winningNumber = new int[6];

        Random random = new Random(3);
        for (int i = 0; i < 6; i++) {
            selectNumber[i] = random.nextInt(45) + 1;
        }

        random = new Random(5);
        for (int i = 0; i < 6; i++) {
            winningNumber[i] = random.nextInt(45) + 1;
        }

        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);

        System.out.println("선택번호: " + Arrays.toString(selectNumber));
        System.out.println("당첨번호: " + Arrays.toString(winningNumber));
        System.out.println("일치 여부: " + Arrays.equals(selectNumber, winningNumber));
    }
}

```

<br>

- Math

```

public class MathPractice {
    public static void main(String[] args) {
        System.out.println("ceil(5.3) = " + Math.ceil(5.3));
        System.out.println("floor(5.3) = " + Math.floor(5.3));
        System.out.println("max(3, 7) = " + Math.max(3, 7));
        System.out.println("min(3, 7) = " + Math.min(3, 7));

        double value = 12.3456;
        double rounded = Math.round(value * 100) / 100.0;
        System.out.println("소수 둘째 자리 반올림: " + rounded);
    }
}

```
<br>

<hr>

### equals / hashCode (신규 추가)

- 아래 내용은 `src/test`의 `SetTest1`, `SetTest2`, `SetTest3`, `Student`, `Student2` 기준으로 정리했습니다.
- 핵심은 `Set`이 중복 체크 시 `hashCode()` + `equals()`를 함께 사용한다는 점입니다.
- String은 equals/hashCode가 이미 구현되어 중복 제거됨
```java
// SetTest1.java
package test;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("kim");
        set.add("park");
        System.out.println(set);
        System.out.println(set.size());
        set.add("kim");
        System.out.println(set);
        System.out.println(set.size());

        /////  set : 중복된 것을 자동으로 넣어주지 않음.
        //  [kim, park]
        //  2
        //  [kim, park]
        //  2
        /////
    }
}

```

```java

// Student.java
@Data
public class Student {
    @NonNull String id;
    String name;
}
// @Data가 equals/hashCode를 자동 생성

```

<br>

```java

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Student("1", "홍길동"));
        set.add(new Student("2", "김길동"));
        System.out.println(set);
        System.out.println(set.size());
        set.add(new Student("1", "홍길동"));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains(new Student("1", "홍길동")));

        /////  set : 중복된 것을 자동으로 넣어주지 않음.
        //  [Student(id=2, name=김길동), Student(id=1, name=홍길동)]
        //  2
        //  [Student(id=2, name=김길동), Student(id=1, name=홍길동)]
        //  2
        //  true
        /////
    }
}


```

<br>

```java

// Student2.java

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

// 원래 Object의 hashCode()는 해시테이블의 hash값(주소와 매핑되는 값)을 리턴, hashset에서는 중복된 값을 넣지 않아야 하는데,
// new 동일클래스(동일값1), new 클래스(동일값1)인 경우 주소(hash값)가 다르므로 동일값1이 들어가도 다른 대상으로 여김.
// 기존의 hash값을 비교하는 것으로 hashset에 넣으면 중복처리가 제대로 되지않음.
// 그 hash값의 필드의 주소가 동일한지 비교하면 이런 문제가 사라짐.
// //객체가 동일한지 비교할 때는 내부 필드의 값들이 들어있는 위치가 동일한지 비교해야함.
//    @Override
//    public int hashCode() {
//        return id.hashCode() + name.hashCode();
//    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

```
<br>

```java

package test;

import java.util.HashSet;
import java.util.Set;

public class SetTest3 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Student2("1", "홍길동"));
        set.add(new Student2("2", "김길동"));
        System.out.println(set);
        System.out.println(set.size());
        set.add(new Student2("1", "홍길동"));
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains(new Student2("1", "홍길동")));

        /////  set : 필드가 들어있는 주소와 값들이 동일한지 오버라이드해주지 않고
        //           객체의 주소만 비교하면 의도와는 다르게 처리됨.
        //  [1 홍길동, 2 김길동]
        //  2
        //  [1 홍길동, 1 홍길동, 2 김길동]
        //  3
        //  false


        //equals()와 hashcode() 오버라이드 후 -------------------------------
        /////  set : 필드가 들어있는 주소와 값들이 동일한지 오버라이드해주면
        //           중복체크를 제대로 해줌.
        // [2 김길동, 1 홍길동]
        // 2
        // [2 김길동, 1 홍길동]
        // 2
        // true

    }
}





```


```mermaid
flowchart TD
  A["SetTest1: String add"] --> B["중복 제거 성공"]
  C["SetTest2: Student add"] --> D["@Data로 equals/hashCode 자동 생성"]
  D --> E["중복 제거 성공 / contains=true"]
  F["SetTest3: Student2 add"] --> G["equals/hashCode 미구현"]
  G --> H["중복 제거 실패 가능 / contains=false"]
```

<br>
<img width="546" height="419" alt="스크린샷 2026-04-26 18 40 02" src="https://github.com/user-attachments/assets/22e7b749-0972-40e7-8fc6-50f1004930bd" />
<img width="1181" height="1331" alt="iOS 이미지" src="https://github.com/user-attachments/assets/b999d7a6-184d-44ed-aa0d-8d5fd1bdf698" />
<img width="1536" height="1024" alt="iOS 이미지 (1)" src="https://github.com/user-attachments/assets/ee1a73b4-93c9-47ba-a717-2cf3138b97e8" />
<img width="1536" height="1024" alt="iOS 이미지 (2)" src="https://github.com/user-attachments/assets/caba79f2-9783-4cf1-bc19-02b0a8f6ca16" />
<img width="1619" height="972" alt="iOS 이미지 (3)" src="https://github.com/user-attachments/assets/b9d8d29e-b819-4246-afb6-c9e0a2844715" />
<img width="1428" height="1101" alt="iOS 이미지 (4)" src="https://github.com/user-attachments/assets/280cde90-f2a8-451b-a97c-2a9a554e5d3b" />







