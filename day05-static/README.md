<img width="1122" height="1402" alt="image" src="https://github.com/user-attachments/assets/f237eb9b-a72c-4179-8692-25c4064d3fe0" />


<br>

# ☕ Java Basic Learning - Day 5 (생성자 · static · Swing 입문)

## 📚 개요

이 수업에서는 **객체 생성 시 초기화(생성자)**, **클래스 공유 데이터(static)**, 그리고 **간단한 GUI(JFrame, JButton)** 를 다룹니다.

| 주제 | 내용 |
|------|------|
| **생성자(Constructor)** | `new`로 객체를 만들 때 자동 호출되어 필드를 원하는 값으로 초기화 |
| **static** | 인스턴스가 아니라 **클래스에 딱 하나** 존재하는 변수·메서드 |
| **toString()** | `System.out.println(참조변수)` 시 보이는 문자열을 직접 정의 |
| **Swing 기초** | `JFrame`, `FlowLayout`, `JButton`, `Font`, `Color` |

---

## 🔗 파일 구조

```
day5-static/
├── src/
│   └── object/
│       ├── Account.java      # 생성자로 계좌 정보 초기화
│       ├── AccountUse.java   # Account 사용 예제
│       ├── Day.java          # 인스턴스 필드 + static count + getter/setter
│       ├── DayUse.java       # Day 생성 및 static/toString 실습
│       └── Graphic.java      # JFrame + 버튼 GUI 예제
└── README.md
```

---

## 1️⃣ 생성자(Constructor) — `Account.java` / `AccountUse.java`

### 개념

- **생성자**는 클래스 이름과 같고, **반환 타입이 없습니다** (`void`도 쓰지 않음).
- 개발자가 생성자를 **하나도 작성하지 않으면**, 컴파일러가 **기본 생성자 `Account()`** 를 넣어 줍니다.
- **필드를 초기화하는 생성자**를 직접 만들면, 그 시그니처에 맞게 `new Account(이름, 주민, 금액)` 처럼 호출합니다.

### 메모리 관계 (도식)

```text
        STACK                         HEAP
  ┌──────────────┐              ┌─────────────────────┐
  │ account ─────┼─────────────►│ Account 인스턴스     │
  │ (참조/주소)   │              │ name: "홍길동"      │
  └──────────────┘              │ ssn:  "010115"      │
                                │ money: 10000        │
                                └─────────────────────┘
```

<img width="2393" height="1840" alt="image" src="https://github.com/user-attachments/assets/e0e92e34-af01-4fb3-82f7-995a127aea76" />

### 코드: `Account.java`

```java
package object;

public class Account {

    // 계좌만들때 필요한 필드(멤버변수)
    String name; //이름
    String ssn; //주민번호
    int money; //금액

    Account(String name,
                   String ssn,
                   int money) {
        this.name = name;
        this.ssn = ssn;
        this.money = money;
    }

//메서드는 만들지 않음.
}
```

### 코드: `AccountUse.java`

```java
package object;

public class AccountUse {
    public static void main(String[] args) {
        Account account = new Account(
                "홍길동",
                "010115",
                10000);
        //Account클래스내에 생성자가 하나도
        //없을 때 컴파일할 때
        //Account() 생성자메서드를 추가해줌.
        System.out.println(account.name);
        System.out.println(account.ssn);
        System.out.println(account.money);
    }
}
```

### 실행 흐름 (그림: mermaid)

```mermaid
flowchart LR
    A["main 시작"] --> B["new Account 호출"]
    B --> C["생성자 실행"]
    C --> D["필드에 값 대입"]
    D --> E["참조를 account에 대입"]
    E --> F["필드 출력"]
```

---

## 2️⃣ static과 인스턴스 — `Day.java` / `DayUse.java`

### 개념

| 구분 | 설명 | 예시 (`Day`) |
|------|------|----------------|
| **인스턴스 변수** | 객체마다 힙에 **복사** | `doing`, `time`, `location` |
| **static 변수** | 클래스당 **한 번만** (공유) | `count` — 생성될 때마다 증가 |
| **static 메서드** | 객체 없이 `클래스이름.메서드()` | `Day.getCount()` |

**주의:** `static` 메서드 안에서는 **인스턴스 필드**에 바로 접근할 수 없습니다. (객체가 없을 수도 있기 때문입니다.)

### 인스턴스 vs static (도형: ASCII)

```text
                    ┌─────────────────────────────────────┐
  Method Area       │  Day 클래스                          │
  (클래스 영역)      │  ─────────────────                  │
                    │  static int count  ◄── 전 객체 공유   │
                    └─────────────────────────────────────┘
                                      │
          각 객체(day1, day2, day3)    │
                    ┌───────────────────┼───────────────────┐
        HEAP        │                   │                   │
                    ▼                   ▼                   ▼
              ┌──────────┐        ┌──────────┐      ┌──────────┐
              │ Day #1   │        │ Day #2   │      │ Day #3   │
              │ doing    │        │ doing    │      │ doing    │
              │ time     │        │ time     │      │ time     │
              │ location │        │ location │      │ location │
              └──────────┘        └──────────┘      └──────────┘
```

### 코드: `Day.java`

```java
package object;

public class Day {
    //인스턴스 변수
    //객체생성시 힙영역에 복사
    private String doing;
    private int time;
    private String location;
    //정적 변수, static변수
    //메모리 원본 영역에 한 개만 존재
    static int count;

    public Day(String doing, int time, String location) {
        //this는 이 클래스로 만든 객체
        this.doing = doing;
        this.time = time;
        this.location = location;
        count++; //누적용
    } //생성자

    //내가 만드는 메서드는 가운데에 넣는 편
    //객체 만들지 않고도 클래스이름으로
    //바로 접근해서 메서드를 호출하고 싶을 때
    public static int getCount(){
        //static만들 때 조심할 것
        //인스턴스 변수를 넣을 수 없음.
        //static 변수만 넣을 수 있음.
        return count;
    }

    public String getDoing() {
        return doing;
    }

    public void setDoing(String doing) {
        this.doing = doing;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static void setCount(int count) {
        Day.count = count;
    }

    //toString()을 수정해서 재정의하자.
    @Override
    public String toString() {
        return "Day{" +
                "doing='" + doing + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }
} //클래스
```

### 코드: `DayUse.java`

```java
package object;

public class DayUse {
    public static void main(String[] args) {
        Day day1 = new Day("자바코드", 4, "세종대");
        System.out.println(day1); //참조형 변수
        System.out.println(Day.count);
        Day day2 = new Day("상속", 4, "세종대");
        System.out.println(day2);
        System.out.println(Day.count);
        Day day3 = new Day("인터페이스", 4, "세종대");
        System.out.println(day3);
        System.out.println(Day.count);

        System.out.println(Day.getCount());

        System.out.println(day1.getDoing());
        //참조형 변수를 출력해보니 패키지명.클래스명@주소 문자열 형태로 프린트됨.
        //이 문자열을 만들어주는 메서드가 자동호출하게 되어있음.
        //toString()임. 이것을 수정하면 변수가 가르키는 인스턴스 변수들을 출력하게 할 수 있음.
//        System.out.println(day1.doing);
//        System.out.println(day1.time);
//        System.out.println(day1.location);
    }
}
```

### `toString()` 동작 (그림: mermaid 시퀀스)

```mermaid
sequenceDiagram
    participant Main
    participant PS as "System.out"
    participant DayObj as "Day 인스턴스 day1"

    Main->>PS: println day1
    PS->>DayObj: toString
    DayObj-->>PS: Day 필드 문자열
    PS-->>Main: 콘솔에 출력
```

---

## 3️⃣ Swing GUI 입문 — `Graphic.java`

### 개념

- **`JFrame`**: 창(틀). 크기 `setSize`, 보이기 `setVisible(true)` 가 필요합니다.
- **`FlowLayout`**: 컴포넌트를 **왼쪽부터** 나열합니다.
- **`JButton`**: 버튼. `setText`, `setBackground`, `setFont` 등으로 꾸밉니다.
- **`Color.xxx`, `Font.BOLD`** 처럼 자주 쓰는 값은 **클래스 이름으로 접근** — 수업에서 배운 **static** 과 같은 맥락입니다.

### 화면 구성 스케치 (도형)

```text
   ┌────────────────────────────────────────────┐
   │  나의 첫 자바프로그램 (JFrame 제목)          │
   ├────────────────────────────────────────────┤
   │  [ 버튼1 ] [ 버튼2 ] [ 버튼3 ] [ 버튼4 ] [ 버튼5 ]   ← FlowLayout
   │     ↑ 색/글꼴 설정                            │
   └────────────────────────────────────────────┘
```

### 코드: `Graphic.java`

<img width="2393" height="1840" alt="image" src="https://github.com/user-attachments/assets/cc9a76af-60f0-4528-a6ab-2b47d64c7cb0" />
<img width="2930" height="1683" alt="image" src="https://github.com/user-attachments/assets/3357c34d-553b-456a-9509-adebb77d1769" />
<img width="503" height="501" alt="image" src="https://github.com/user-attachments/assets/6a711c50-a323-412b-98c7-9372a10c7053" />

```java
package object;

//컴파일러가 번역할 때 자동으로 넣어줌.
//개발자는 써주지 않음.
//import java.lang.*;

import javax.swing.*;
import java.awt.*;

public class Graphic {
    public static void main(String[] args) {
        //필요한 부품들을 생각해보자.
        //틀 --> JFrame
        //배치 --> FlowLayout
        //버튼 --> JButton
        //글자 --> Font

        //JFrame클래스로 객체를 만들어주세요.
        //new --> 객체생성과 관련된 키워드
        JFrame frame = new JFrame("나의 첫 자바프로그램"); //힙영역에 멤버변수들을 복사
        FlowLayout layout = new FlowLayout();
        JButton button = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        //객체생성시 멤버변수들을 내가 원하는 값으로 초기화하고 하고 싶은 경우
        //"클래스이름과 동일한 메서드"를 만들어서 객체생성과 동시에
        //초기화가 가능함. ==> 생성자 메서드(생성자, CONSTRUCTOR)
        //객체 생성시 클래스이름과 동일한 메서드인 생성자 메서드가 있으면
        //자동 호출되면서 멤버변수 자동 초기화
        Font font = new Font("궁서", Font.BOLD, 30);

        //프레임은 가로/세로 설정이 꼭 있어야한다.
        frame.setSize(400,400);
//        frame.setTitle("나의 첫 자바프로그램");
        //프레임에 레이아웃 설정
        frame.setLayout(layout); //왼쪽부터 붙이고, 가운데 정렬
        frame.add(button);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(new JButton("버튼5")); //ok
        //버튼5를 담고 있는 변수가 없어서 버튼안에 있는 메서드나 변수를 접근 불가능

        button.setText("버튼1");
        button2.setText("버튼2");
        button3.setText("버튼3");
        button4.setText("버튼4");

        //프로그램할 때 자주쓰는 변수(보통 상수)나 메서드는
        //클래스이름으로 바로 접근해서 사용 가능하게 만들어놓았음.
        //Color.pink, Font.BOLD, Math.PI
        //Math.random(), Integer.parseInt() : String("100") --> int(100)
        //Float.parseFloat(), Double.parseDouble()
        //String.valueOf() : int(100) --> String("100")
        //메모리에 항상 상주하고 있어서 클래스이름으로 접근/불러서 사용 가능함
        //static(정적) 변수/메서드
        button.setBackground(Color.CYAN);
        button2.setBackground(Color.pink);
        button3.setBackground(Color.yellow);
        button4.setBackground(Color.ORANGE);


        button.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        button4.setFont(font);

        //프레임은 위 설정에 맞게 보여지게 해야함.
        //기본값은 보이는 것으로 설정을 바꾸어주어야함.
        //맨 마지막에 써야함.
        frame.setVisible(true);
    }
}
```

### GUI 초기화 흐름 (그림: mermaid)

```mermaid
flowchart TD
    A["JFrame Layout Font 생성"] --> B["frame.setSize"]
    B --> C["frame.setLayout"]
    C --> D["frame.add 로 버튼 추가"]
    D --> E["버튼 텍스트 색 폰트 설정"]
    E --> F["frame.setVisible true"]
    F --> G["화면에 창 표시"]
```

---

## 🎓 핵심 요약

| 주제 | 기억할 점 |
|------|-----------|
| **생성자** | 클래스명과 동일, 반환 타입 없음, `new` 시 자동 호출 |
| **static 변수** | 모든 인스턴스가 **공유**, 생성자 등에서 누적 카운트에 적합 |
| **static 메서드** | 인스턴스 필드 사용 불가(원칙적으로) |
| **toString()** | `println(객체)` 시 사용 — 내용을 읽기 좋게 바꿀 수 있음 |
| **Swing** | `JFrame` + `Layout` + 컴포넌트 추가 후 `setVisible(true)` |

---

## ▶️ 실행 방법 (IntelliJ / 터미널)

- **AccountUse**: `object.AccountUse` 의 `main` 실행  
- **DayUse**: `object.DayUse` 의 `main` 실행  
- **Graphic**: `object.Graphic` 의 `main` 실행 (GUI 창이 뜸)

터미널 예시 (`day5-static` 기준, 소스 경로에 맞게 조정):

```bash
javac -d out src/object/*.java
java -cp out object.AccountUse
java -cp out object.DayUse
java -cp out object.Graphic
```

---

## 📎 참고 그림 (개념 한눈에)

아래는 **static 필드가 “클래스에 붙어 있는 공유 값”** 이라는 점을 시각화한 다이어그램입니다.

```mermaid
flowchart TB
    subgraph CA["클래스 영역 공유"]
        C["static int count"]
    end
    subgraph HP["힙 영역 객체 각각"]
        D1["Day 인스턴스 1"]
        D2["Day 인스턴스 2"]
        D3["Day 인스턴스 3"]
    end
    C -.-> D1
    C -.-> D2
    C -.-> D3
```

<hr>

<br>
- 클래스 & 객체 복습
<img width="2473" height="1402" alt="image" src="https://github.com/user-attachments/assets/61d40813-5916-4bbc-a21a-04db5b725125" />
<img width="2465" height="1411" alt="image" src="https://github.com/user-attachments/assets/ff996c38-bb2c-4349-80dd-c0883c23fb8f" />
<img width="1448" height="1086" alt="image" src="https://github.com/user-attachments/assets/942b3ac5-08f2-43fd-82b7-91447a5c2d76" />

<img width="1532" height="1027" alt="image" src="https://github.com/user-attachments/assets/14a0c3e8-b09f-4e8a-9a35-1557f1d53c9e" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/2350a2b6-7db5-458e-a9d2-69334f51fe61" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/92b72644-9b70-4753-b620-e3ee2c8a7de8" />
<img width="1670" height="941" alt="image" src="https://github.com/user-attachments/assets/44e3c131-4d7c-410e-bc84-8d59580350fd" />




<br><br>
- 생성자
<img width="1672" height="941" alt="38B84CD3-4047-4AA7-A469-2653F466F735" src="https://github.com/user-attachments/assets/630e0e35-ad9b-4ef0-9f08-d1f01c7cfcb7" />
<img width="1670" height="942" alt="767CFCF8-0EB9-4E62-8878-FAF1DC0C368D" src="https://github.com/user-attachments/assets/5e947ae6-c636-4413-8d54-6170b4c57e93" />
<img width="1672" height="941" alt="8ADFA9C1-5715-42B6-B905-4B79590EAFC5" src="https://github.com/user-attachments/assets/89216860-0383-4299-9265-0bf7fa4915f7" />
<img width="1626" height="967" alt="37F73F38-9A9D-46B4-A36A-B1ED2E686E12" src="https://github.com/user-attachments/assets/b3b254d6-03a5-45d7-a487-908cd22b3680" />
<img width="1672" height="941" alt="2352D334-8F76-4A89-837A-551E1FE04DE0" src="https://github.com/user-attachments/assets/898c082e-cda7-4a78-b113-9127503fdf3f" />
<img width="2477" height="1402" alt="IMG_2093" src="https://github.com/user-attachments/assets/6c912ab5-af77-4c7c-b6ba-30b2fa09dc4e" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/f4679408-da66-49cf-8213-e47fbb8d1d71" />
<img width="1672" height="940" alt="image" src="https://github.com/user-attachments/assets/57343ddd-a0c9-48b4-890b-134fa23cb094" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/9782a56a-317f-4a0e-bd32-cf4d1d9de3f5" />
<img width="1697" height="927" alt="4CF49DAE-C095-4432-8CDA-545BCBCB0D06 (1)" src="https://github.com/user-attachments/assets/e61ec068-dbee-429c-b9f7-10cf57963563" />


<br><br>
- static
<img width="1660" height="948" alt="66B8869A-2B75-45FD-A099-3E16396AA030" src="https://github.com/user-attachments/assets/3d11f0a5-7ad6-4aec-abee-33da8aabbee6" />
<img width="1668" height="943" alt="1D444ADF-D2C4-41E5-8D5E-1D442D5E4581" src="https://github.com/user-attachments/assets/4835c3be-6420-4916-9d59-fed885c67a65" />
<img width="1658" height="949" alt="32800EB8-FD77-4C14-A6D7-445AF749DC97" src="https://github.com/user-attachments/assets/52e471f8-9509-4af6-ac9e-48c87f5c6220" />
<img width="1672" height="941" alt="5A503F59-FED9-410B-BCEE-218700535B98" src="https://github.com/user-attachments/assets/1bec5edd-8a83-40f1-bbf2-8c254fe16f5d" />



<br><br>
- final(상수 설정)
<img width="1672" height="941" alt="D60ECE01-9B14-4B00-BA72-B48040B81EED" src="https://github.com/user-attachments/assets/65fe4c17-34ae-40bb-b32c-5b81d781bd89" />
<img width="1662" height="946" alt="8AC43B71-D338-486B-AA4C-45D02F83AEA7" src="https://github.com/user-attachments/assets/9c21b722-46a5-4909-a55c-d62a15bdb0a1" />

<br><br>
- getter/setter
<img width="2482" height="1406" alt="image" src="https://github.com/user-attachments/assets/5bad3010-306c-47b0-b782-dfc6b0219c31" />
<img width="1916" height="1072" alt="스크린샷 2026-04-19 18 00 43" src="https://github.com/user-attachments/assets/a08be64b-17dd-4aa2-8189-0370216e7078" />
<img width="1200" height="1107" alt="IMG_2031" src="https://github.com/user-attachments/assets/569c6883-e3b5-44de-9079-ffdd3173b981" />
<img width="1508" height="1805" alt="IMG_2030" src="https://github.com/user-attachments/assets/533648fe-4fe5-4bfc-a32d-76f8b0bee3cb" />


<br><br>
-접근 제어자
<img width="1673" height="940" alt="1E3B2678-0D50-4AD4-B639-F51B9E4E41AC" src="https://github.com/user-attachments/assets/54293c24-0bd7-4dd4-a40b-dba4ef05eb1a" />


<br><br>
- 가변길이 매개변수
<img width="1200" height="906" alt="IMG_2032" src="https://github.com/user-attachments/assets/d4b31b7e-605c-43b8-8ecc-a64717cb0ca7" />
<img width="1200" height="1035" alt="IMG_2034" src="https://github.com/user-attachments/assets/a61512d9-33ba-41b9-a916-8f4e14293817" />




