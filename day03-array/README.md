<img width="1024" height="1536" alt="image" src="https://github.com/user-attachments/assets/ebd63668-ccdf-4bca-bed9-5c1d09e1b292" />


<br>


# ☕ Java Basic Learning - Day 3 (Array)

`day3`에서는 **배열(Array)** 을 집중적으로 연습합니다.  
`Array1~4.java` 흐름대로 **1차원 배열 → 2차원 배열 → 가변(비정형) 2차원 배열 → 얕은/깊은 복사**를 다룹니다.

---

## 📂 프로젝트 구조



```text
day3
└─ src
   └─ array
      ├─ Array1.java  (1차원 배열 / for, for-each)
      ├─ Array2.java  (2차원 배열 리터럴 / 중첩 for)
      ├─ Array3.java  (2차원 배열 new / 가변 길이 2차원 배열)
      └─ Array4.java  (배열 복사: 얕은 복사 vs 깊은 복사(clone))
```

---

## 📝 핵심 개념 요약

### 1) 1차원 배열 기초 (`Array1.java`)

- **특징**
  - **고정 크기**: 한 번 만들면 길이를 바꾸기 어렵습니다.
  - **같은 타입만 저장**: `int[]`에는 `int`만 들어갑니다.
  - **자동 초기화**: `new int[10]`처럼 만들면 기본값 `0`으로 채워집니다.
- **자주 쓰는 문법**
  - **선언/생성**: `int[] a = new int[10];`
  - **리터럴 생성**: `int[] b = {100, 200, 300};`
  - **길이**: `b.length`
  - **반복 출력**: `for`, `for-each`

#### 📌 그림: 1차원 배열 메모리(개념)

```text
[스택(Stack)]                         [힙(Heap)]

jumsu2 (참조 변수)  ───────────────▶   int[] (length = 3)
                                     ├─ [0] = 100
                                     ├─ [1] = 200
                                     └─ [2] = 300
```

---

### 2) 2차원 배열 기본 (`Array2.java`)

- **2차원 배열은 “1차원 배열의 배열”**
  - `int[][] scores`는 “행” 단위로 `int[]`를 여러 개 들고 있는 구조입니다.
- `scores.length`는 **행(row) 개수**
- `scores[i].length`는 **i번째 행의 열(column) 개수**

#### 📌 그림: 2차원 배열 접근(개념)

```text
scores (int[][])
 ├─ scores[0] (int[]) ──▶ scores[0][0], scores[0][1], scores[0][2] ...
 └─ scores[1] (int[]) ──▶ scores[1][0], scores[1][1] ...

※ scores.length       = 행(row) 개수
※ scores[i].length    = i행의 열(column) 개수
```

---

### 3) 가변(비정형) 2차원 배열 (`Array3.java`)

`new int[2][]`처럼 만들면 **행(바깥 배열)만 먼저 만들고**, 각 행의 `int[]`는 나중에 원하는 길이로 채울 수 있습니다.

```java
int[][] scores2 = new int[2][];
scores2[0] = new int[3];
scores2[1] = new int[] {1, 2};
```

#### 📌 그림: 행마다 길이가 다른 2차원 배열

```text
scores2 (int[][])
 ├─ scores2[0] = new int[3]   → [0, 0, 0]
 └─ scores2[1] = new int[2]   → [1, 2]  (예시)
```

---

### 4) 배열 복사: 얕은 복사 vs 깊은 복사 (`Array4.java`)

- **얕은 복사(Shallow copy)**: **주소(참조)만 복사**
  - `int[] num4 = num3;`
  - 두 변수가 **같은 배열**을 가리켜서, 하나를 수정하면 다른 쪽에서도 바뀐 것처럼 보입니다.
- **깊은 복사(Deep copy)**: **새 배열을 만들고 값까지 복사**
  - `int[] num5 = num3.clone();`
  - 서로 다른 배열이므로 수정이 독립적입니다.

#### 📌 그림: 얕은/깊은 복사 차이

```text
[얕은 복사]
num3 ──▶ (같은 배열 A) ◀── num4
  → num3[0] 바꾸면 num4에서도 똑같이 바뀜

[깊은 복사]
num3 ──▶ 배열 B
num5 ──▶ 배열 C  (clone으로 새 배열)
  → num3 바꿔도 num5는 영향 없음
```

---
<img width="2598" height="1460" alt="image" src="https://github.com/user-attachments/assets/90fe2435-ecaf-4706-86cd-50f1087e65f5" />
<img width="2569" height="1457" alt="image" src="https://github.com/user-attachments/assets/03b18493-f9fd-489c-8a38-a243dbd9f583" />

<img width="2582" height="1457" alt="image" src="https://github.com/user-attachments/assets/dfa1af28-768f-427c-a660-9c6b48a69173" />
<img width="2577" height="1453" alt="image" src="https://github.com/user-attachments/assets/9f1c46b2-4178-4229-9e59-c8998ed07880" />

<img width="2568" height="1452" alt="image" src="https://github.com/user-attachments/assets/29fad864-406f-4435-a6a1-d587d672fd67" />

<img width="2303" height="1296" alt="image" src="https://github.com/user-attachments/assets/2c1c492a-acc3-4768-807b-8939878d7837" />
<img width="2585" height="1458" alt="image" src="https://github.com/user-attachments/assets/03e48449-f43e-4d64-be81-9ddf82b0a6eb" />

<img width="2586" height="1459" alt="image" src="https://github.com/user-attachments/assets/329e74be-09a1-4bdc-920d-8f4ce77b3e98" />
<img width="2584" height="1462" alt="image" src="https://github.com/user-attachments/assets/6e3c0c0c-26f4-4216-b50d-fa3fc039384c" />
<img width="2582" height="1457" alt="image" src="https://github.com/user-attachments/assets/5b8d2763-da86-496c-ad5e-d4180b111145" />
<img width="2305" height="1304" alt="image" src="https://github.com/user-attachments/assets/c53c06ef-4be6-40a1-99f7-124d1323bd09" />
<img width="2478" height="1396" alt="image" src="https://github.com/user-attachments/assets/dff0f97d-bac6-4580-b23f-288b6fc0caa4" />
<img width="2301" height="1291" alt="image" src="https://github.com/user-attachments/assets/c4a4081d-4be6-4744-98f7-44a05ca17f88" />
<img width="2479" height="1401" alt="image" src="https://github.com/user-attachments/assets/08190275-7026-43f1-bee4-e73589a269d5" />

```
// 친구이름
        String[] names = {"홍길동", "김길동", "박길동", "송길동", "정길동"};
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }
        
        System.out.println();
        
        // 우리 가족 5명의 나이를 넣어보세요. 전체 출력
        int[] ages = {50, 40, 30, 20, 10};
        for (int i = 0; i < ages.length; i++) {
            System.out.print(ages[i] + " ");
        }
        
        System.out.println();
        
        // 친구들의 발 사이즈를 넣어보세요. 전체 출력
        int[] shoes = {134, 235, 245, 255, 300};
        for (int i = 0; i < shoes.length; i++) {
            System.out.print(shoes[i] + " ");
        }
        
        System.out.println();
        
        // 친구들의 성별을 넣어보세요. 전체 출력
        char[] gender = {'남', '여', '남', '남', '여'};
        for (int i = 0; i < gender.length; i++) {
            System.out.print(gender[i] + " ");
        }

```

# 2차원 배열
```
package array;

public class Array2 {
    public static void main(String[] args) {
       //2차원 배열
        // 1차원 배열을 묶어놓은 것

        //배열생성시 값을 이미 알고 있는 경우
        int[][] scores = {
                { 80, 90, 96},
                { 76, 88}
        };

        //배열 --> 반복문(for)
        //1차원 배열 --> for문 1개
        //2차원 배열 --> for문 2개

        //2차원 배열의 전체 행수
        System.out.println(scores.length); //2
        //첫번째 행의 1차원 배열의 개수
        System.out.println(scores[0].length); //3
        //두번째 행의 1차원 배열의 개수
        System.out.println(scores[1].length); //2

        //2차원 배열내의 특정한 요소를 접근
        System.out.println(scores[0][0]);
        System.out.println(scores[0][2]);
        System.out.println(scores[1][1]);

        //2차원인덱스 증가할 for문 하나
        //1차원인덱스 증가할 for문 하나
        for (int i = 0; i < scores.length ; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println(scores[i][j]);
            }
        }
    }
}
```

```
package array;

public class Array3 {
    public static void main(String[] args) {
        //배열 생성시 값을 모르고 있는 경우
        //일단 초기화된 공간을 만든다.
        //1. 1차원배열의 요소 개수를 다 똑같이 맞추고 싶은 경우
        int[][] scores = new int[2][3];
        //2행 3열의 2차원 배열의 생김
        //0 0 0
        //0 0 0

        //2. 1차원배열의 요소 개수를 다르게 하고 싶은 경우
        int[][] scores2 = new int[2][];
        scores2[0] = new int[3];
        //1차원 배열 만들때 이미 만들어진 변수에 넣는 경우
        //1. 0으로 된 초기화를 넣는 경우
        //scores2[1] = new int[2];
        //2. 원하는 값으로 넣어서 만드는 경우
        scores2[1] = new int[] {1, 2};
        // scores2[1] = {1, 2}; --> XXXX
        //0 0 0
        //1 2

        //배열의 주소가 들어가는 변수가
        //미리 만들어진 경우
        int[] scores3 = null;
        //scores3 = new int[3]; 문제없음.
        //scores3 = {1, 2, 3}; 문제있음.
        scores3 = new int[] {1,2,3};

    }
}


```

# 배열의 복사
```
package array;

import java.util.Arrays;

public class Array4 {
    public static void main(String[] args) {
        int[] num3 = {100, 200, 300};
        //1. 얕은 복사(주소만 복사)
        //--> 지역변수의 주소가 복사
        int[] num4 = num3;

        System.out.println("num3주소>> " + num3);
        System.out.println("num4주소>> " + num4);

        num3[0] = 999;
        System.out.println(Arrays.toString(num3));
        System.out.println(Arrays.toString(num4));

        //2. 깊은 복사(주소가 가르키고 있는 배열값들 복사)
        //--> 힙영역의 데이터들이 복사가 됨.
        //--> 새로운 주소가 만들어짐.

        int[] num5 = num3.clone();
        num3[0] = 555;
        System.out.println(Arrays.toString(num3));
        System.out.println(Arrays.toString(num5));

        //특별한 경우를 제외하고는
        //일반적으로 배열은 깊은 복사를 많이 쓴다.
        System.out.println(num3);
        System.out.println(num5);
    }
}
```

**Java String 클래스**에서 가장 자주 사용되고 중요한 메서드 **10개**
<hr>
<img width="2309" height="1164" alt="image" src="https://github.com/user-attachments/assets/00a5b954-3550-4703-a676-798a22dc5aed" />
<img width="815" height="312" alt="image" src="https://github.com/user-attachments/assets/b1019fa3-24d7-4d21-81ed-390895194efe" />

```
public class StringMethodExample {
    public static void main(String[] args) {
        
        String str = "  Hello Java World  ";
        
        System.out.println("원본 문자열: [" + str + "]");
        System.out.println("1. length()          : " + str.length());
        System.out.println("2. charAt(7)         : " + str.charAt(7));
        System.out.println("3. substring(7, 11)  : " + str.substring(7, 11));
        System.out.println("4. equals(\"hello\")   : " + str.equals("hello"));
        System.out.println("5. equalsIgnoreCase  : " + str.trim().equalsIgnoreCase("hello java world"));
        System.out.println("6. indexOf(\"Java\")    : " + str.indexOf("Java"));
        System.out.println("7. contains(\"World\") : " + str.contains("World"));
        System.out.println("8. replace(\"Java\", \"Python\") : " + str.replace("Java", "Python"));
        System.out.println("9. trim()            : [" + str.trim() + "]");
        
        String[] arr = str.trim().split(" ");
        System.out.print("10. split(\" \")       : ");
        for (String s : arr) {
            System.out.print("[" + s + "] ");
        }
        System.out.println();
    }
}
```

```
원본 문자열: [  Hello Java World  ]
1. length()          : 20
2. charAt(7)         : J
3. substring(7, 11)  : Java
4. equals("hello")   : false
5. equalsIgnoreCase  : true
6. indexOf("Java")    : 9
7. contains("World") : true
8. replace("Java", "Python") : [  Hello Python World  ]
9. trim()            : [Hello Java World]
10. split(" ")       : [Hello] [Java] [World]
```

# ENUM
- 타입 안전성 (Type Safety) — 가장 중요한 이유
- 잘못된 값을 넣는 실수를 컴파일 단계에서 막아줌.
- String이나 int로 요일을 표현하면 실수가 쉽게 발생

- 가독성과 유지보수성 향상
- 의미 있는 이름으로 코드를 작성할 수 있음
- 관련된 상수들을 하나의 타입으로 논리적으로 그룹화함.

```
Week.java (Enum 정의)

---------------------------
package array;


public enum Week {
    MONDAY,     // 월요일
    TUESDAY,    // 화요일
    WEDNESDAY,  // 수요일
    THURSDAY,   // 목요일
    FRIDAY,     // 금요일
    SATURDAY,   // 토요일
    SUNDAY      // 일요일
}
```

```

오늘은 WEDNESDAY입니다.
수요일! 벌써 주 중반이네요~

```

```

package array;

public class EnumTest {
    public static void main(String[] args) {
        
        // 오늘 요일을 하나 지정
        Week today = Week.WEDNESDAY;
        
        System.out.println("오늘은 " + today + "입니다.");
        
        // switch문으로 사용하기 (가장 많이 쓰이는 방식)
        switch(today) {
            case MONDAY:
                System.out.println("월요일은 힘들어요...");
                break;
            case WEDNESDAY:
                System.out.println("수요일! 벌써 주 중반이네요~");
                break;
            case FRIDAY:
                System.out.println("불금입니다!!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("주말이예요~ 행복한 시간!");
                break;
            default:
                System.out.println("평일입니다.");
        }
    }
}

```







## 🚀 실행 방법

IntelliJ에서 각 파일을 Run 해도 되고, 터미널에서 아래처럼 실행할 수도 있습니다.

```bash
# 예시: Array1 실행
javac src/array/Array1.java
java -cp src array.Array1
```

---

## ✅ 오늘의 체크리스트

- [ ] `new int[10]` 만들면 왜 0으로 채워질까? (기본값/자동 초기화)
- [ ] `for` vs `for-each`는 언제 각각이 더 편할까?
- [ ] `scores.length` 와 `scores[i].length` 차이를 설명할 수 있나?
- [ ] 얕은 복사/깊은 복사를 코드로 직접 확인해봤나?

