<img width="1197" height="1314" alt="image" src="https://github.com/user-attachments/assets/3f900a18-8826-48da-b17b-7ae5e3aa4a86" />

<br>

# ☕ Java Basic Learning - Day 6 (상속, 재사용, inherit)

#### 1) `Employee.java` (필드/생성자/getter-setter/`toString()` 재정의)

```java
package inherit;

public class Employee extends Object{
    /**
     * Object이 가지는 필드와 메서드를 다 상속받았음.
     * toString() --> Employee e = new Employee();
     * System.out.println(e) --> 패키지명.클래스명@ds9dspfs
     * 주소말고 toString()을 재정의해서 많이 씀.
     * 주소가 가르키는 필드값들 문자열로 만들어주는 기능으로 재정의해서 많이씀.
     * 부모에게 받은 메서드를 똑같이 써주면됨.(오버라이드, 재정의)
     * -------------------------------------------------------
     * 클래스는 기본적으로 3가지를 가짐
     * 필드(멤버변수)
     */
    public String name; //null로 초기화
    String address;
    protected int salary; //0
    private String rrn; //주민번호, null로 초기화

    //생성자
    //프로그래머가 안쓰면 컴파일할 때 기본생성자가 자동으로 추가됨.
    //객체생성한 후 초기화 나중에 하게 하고 싶고
    public Employee(){

    }
    //객체생성할 때 필드값 넣어서 초기화 동시에 하고 싶고
    public Employee(String name, String address, int salary, String rrn) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.rrn = rrn;
    }

    //멤버메서드
    //값넣을 때 set필드명(첫글자대문자) --> setter
    //값꺼낼 때 get필드명(첫글자대문자) --> getter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    @Override //--> 의미없는 표시를 넣어서 프로그래머가 구분하기 쉽게 도와줌.
    //@ --> hera@naver.com : naver.com에(At) 가입한 hera
    //@ --> Annotation(어노테이션, 애노테이션, 표시)
    //Car car = new Car()'
    //System.out.println(car); --> toString()을 무조건 호출함.
    //Object에 있는 toString()은 패키지명.클래스명@주소
    //우리가 만든 클래스에서 toString()을 재정의해서 필드값 문자열로 만들어주면 더 편함.
    public String toString() {
        return name + " " + address + " " + salary + " " + rrn;
    }
}
```

- **핵심**: `rrn`은 `private`이라 **직접 접근 불가** → `getRrn()`으로 접근
- **핵심**: `System.out.println(e)` 시 `toString()`이 자동 호출되므로 출력이 깔끔해짐

#### 2) `Manager.java` (상속 + `super(...)` + `toString()` 확장)

```java
package inherit;

public class Manager extends Employee {
    //필드 4개
    //메서드
    //Object이 상속한 메서드들
    //Employee가 상속한 메서드들
    private int bonus; //필드 5개

    public Manager(String name, String address, int salary, String rrn, int bonus) {
        //무조건 부모의 생성자를 호출하는 메서드는 첫번째 줄에 와야함.
        super(name, address, salary, rrn);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    public void test(){ //메서드 14개
        System.out.println("관리 감독하다.");
    }

    //재정의한 메서드
    @Override
    public String toString() {
        return super.toString() + " " + bonus;
    }
}
```

- **핵심**: 자식 생성자에서 `super(...)`로 **부모 필드 초기화**를 먼저 처리
- **핵심**: `toString()`에서 `super.toString()`을 호출해 **부모 출력 + bonus**로 확장

#### 3) `CompanyUse.java` (실행/확인용 main)

```java
package inherit;

public class CompanyUse {
    public static void main(String[] args) {

        Employee e = new Employee("홍길동", "광진구", 100000, "040701");
        System.out.println(e); //객체 프린트하면 toString() 무조건 호출됨.

        System.out.println(e.name); //public
        System.out.println(e.salary); //default
        System.out.println(e.address); //protected
//        System.out.println(e.rrn); //private

        System.out.println(e.getRrn());

        Manager manager = new Manager("김길동", "영등포", 100000, "040201", 1000);
        System.out.println(manager);

        manager.test();

//e.test();
    }
}
```

<img width="1093" height="540" alt="image" src="https://github.com/user-attachments/assets/a3d4456a-b714-49ce-9561-f8c6a647eabe" />


- **핵심**: `Employee`/`Manager` 출력 차이로 **오버라이딩 결과**를 확인 가능

#### 4) `Graphic2.java` (Swing GUI 예시)

```java
package test;

import javax.swing.*;
import java.awt.*;
//import java.awt.point.*;

public class Graphic2 {
    public static void main(String[] args) {
        //필요한 객체 ram에 가져다 두어야함.
//        JFrame frame = new JFrame(); //기본 생성자 메서드가 자동 호출
//        frame.setTitle("나의 첫 그래픽 프로그램"); //멤버변수가 title에 메서드로 문자열을 넣음.
        //멤버변수를 직접 접근해서 값을 넣거나 꺼내거나 하는 작업을 잘하지 않음.
        //set멤버변수이름, get멤버변수이름으로 메서드를 만들어서 멤버변수를 넣거나 꺼내는 작업을 하는 편.
        //frame.title = "나의 첫 그래픽 프로그램";
        JFrame frame = new JFrame("나의 첫 그래픽 프로그램");
        frame.setSize(600, 500);
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout); //주소를 넣음.!!

        JButton button = new JButton("1증가");
        JButton button2 = new JButton("1감소");
        JButton button3 = new JButton("0으로 초기화");
        JLabel result = new JLabel("0"); //String.valueOf(0)

        frame.add(button);
        frame.add(button3);
        frame.add(button2);
        frame.add(result);

        //글자를 키우자.
        Font font = new Font("궁서", Font.BOLD, 40);
        button.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        result.setFont(new Font("궁서", Font.ITALIC, 400));

        //색을 넣어보자. 배경색 + 글자색
        button.setBackground(Color.RED);
        button2.setBackground(Color.BLUE);
        button.setForeground(Color.YELLOW);
        button2.setForeground(Color.YELLOW);
        button3.setBackground(Color.GREEN);
        button3.setForeground(Color.YELLOW);
        result.setForeground(Color.RED);

        //맥유저는 넣어주세요.
        button.setOpaque(true);
        button2.setOpaque(true);

        //위 설정대로 하면에 보여주세요!! 맨 끝에 위치해야함.
        frame.setVisible(true);
    }
}


```
<img width="977" height="695" alt="image" src="https://github.com/user-attachments/assets/5a9d4a3c-2f5c-44ad-ac13-2a4542e987d1" />
<img width="979" height="988" alt="image" src="https://github.com/user-attachments/assets/b03aad54-6201-4caf-a1ca-753d4af7eecc" />
<img width="1178" height="988" alt="image" src="https://github.com/user-attachments/assets/6d0be13d-e2cb-4f79-8a06-8e16ce4f632e" />


- **핵심**: `JFrame`, `JButton`, `JLabel`, `Layout` 같은 **객체를 생성하고 설정(set...)**하는 패턴을 연습
- **포인트**: `FlowLayout` 객체를 만들고 `frame.setLayout(layout)`처럼 **레이아웃도 “객체(주소)”로 주입**함
- **포인트**: `Font`, `Color`를 이용해 **글꼴/색상**을 꾸밀 수 있음
- **포인트**: (특히 macOS에서) 배경색이 안 먹으면 `setOpaque(true)`가 필요할 수 있음

---

### 표로 요약

#### 1) 클래스별 역할

| 클래스 | 패키지 | 역할 | 핵심 포인트 |
|---|---|---|---|
| `Employee` | `inherit` | 직원 기본 정보(이름/주소/급여/주민번호) 모델 | `toString()`을 재정의해서 보기 좋은 출력 |
| `Manager` | `inherit` | 직원(Employee)을 확장한 관리자 모델 | `bonus` 추가 + `super(...)`로 부모 초기화 |
| `CompanyUse` | `inherit` | 실행(테스트) 클래스 | 필드 접근 제어자/오버라이딩 결과 확인 |
| `Graphic2` | `test` | Swing GUI 맛보기 | 상속보다는 “객체 생성 + setter 스타일 사용” 관점 |

#### 2) `Employee` 필드 접근 제어자 정리

| 필드 | 타입 | 접근 제어자 | 외부 접근(권장/가능) | 의미 |
|---|---|---|---|---|
| `name` | `String` | `public` | 직접 접근 가능(하지만 보통 getter/setter 권장) | 이름 |
| `address` | `String` | default | 같은 패키지에서만 직접 접근 | 주소 |
| `salary` | `int` | `protected` | 같은 패키지/상속 관계에서 접근 | 급여 |
| `rrn` | `String` | `private` | 직접 접근 불가 → `getRrn()` 사용 | 주민번호(민감정보) |

#### 3) `toString()` 오버라이딩 비교

| 클래스 | 구현 | 출력 형태(요약) |
|---|---|---|
| `Object` | 기본 제공 | `패키지.클래스@주소` |
| `Employee` | 재정의 | `name address salary rrn` |
| `Manager` | 재정의 | `Employee정보 + bonus` (`super.toString()` 활용) |

---

### “왜 private은 getter/setter로 접근할까?”

`rrn`처럼 민감한 데이터는

- “마구 변경/조회”를 막고,
- 필요한 곳에서만 규칙을 걸어서(예: 마스킹, 검증) 공개하려고

`private`로 숨긴 뒤 `getRrn()` / `setRrn()`로 통제하는 패턴을 사용합니다.

---

### 실행 방법 (간단)

이 프로젝트는 빌드 도구(pom/gradle) 없이도 실행할 수 있는 구조입니다.

- `inherit.CompanyUse` 실행: 상속/오버라이딩/접근제어자 확인
- `test.Graphic2` 실행: Swing 화면 확인

IDE(IntelliJ)에서 각 `main()` 클래스 우클릭 → Run 하면 가장 편합니다.

---

<img width="2559" height="1439" alt="image" src="https://github.com/user-attachments/assets/7736c16c-0075-4b30-bead-66b7ddda3d9a" />
<img width="2556" height="1437" alt="image" src="https://github.com/user-attachments/assets/3fe2c93a-f66d-43ea-b2b7-062c8f37f96b" />
<img width="2557" height="1438" alt="image" src="https://github.com/user-attachments/assets/c3c8a858-e5ca-49fa-b5c4-77d3bb11ff42" />
<img width="2547" height="1429" alt="image" src="https://github.com/user-attachments/assets/7daea12f-fcfe-4e72-914b-ff26f247759a" />
<img width="2560" height="1446" alt="image" src="https://github.com/user-attachments/assets/7ad1bae8-157e-492d-aa41-58473948e779" />
<img width="2547" height="1434" alt="image" src="https://github.com/user-attachments/assets/16ec8d33-58b0-458b-99f0-5b01b88ca436" />
<img width="2548" height="1441" alt="image" src="https://github.com/user-attachments/assets/72015628-1072-47c3-81dc-8d3f8d5a9e5f" />
<img width="2553" height="1436" alt="image" src="https://github.com/user-attachments/assets/698ffd9c-307c-485e-8dd2-465d05c70ffa" />
<img width="2310" height="1298" alt="image" src="https://github.com/user-attachments/assets/09ea0907-6d20-4002-8329-014bc8eb0aac" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/0764fcbe-3fe6-4c3f-9327-a42cd58c741b" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/c47d5b54-43a2-4378-9504-72a2d8f1d81d" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/6a1a9a8e-fee4-4839-8fbf-09ea2f55bb22" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/7591674d-bfe8-4da5-90d0-5c0bca3d12bb" />


<img width="2553" height="1440" alt="image" src="https://github.com/user-attachments/assets/1bf30fc8-8117-465d-ad35-825331e4885f" />
<img width="2549" height="1438" alt="image" src="https://github.com/user-attachments/assets/b370dfb2-d469-4029-9730-a42836ece8a1" />
<br>
<img width="2555" height="1431" alt="image" src="https://github.com/user-attachments/assets/1c653411-5a26-4d87-b0df-5929e15b7284" />
<img width="2560" height="1426" alt="image" src="https://github.com/user-attachments/assets/a3955d9a-1642-400e-8f44-2737fac86d11" />
<img width="2555" height="1436" alt="image" src="https://github.com/user-attachments/assets/a135e59e-eab2-4067-b43d-7fcaea367110" />
<img width="2559" height="1376" alt="image" src="https://github.com/user-attachments/assets/36b5b425-7b79-46d6-8b17-e905afaba1d9" />

<br>
<hr>
<br>
- 클래스 만들기와 상속(재사용)
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/fe3b8c40-9e49-475f-8e64-74dbc8f2c1af" />

<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/ad8d8806-a7a5-4967-a89c-f863665c62ad" />
<br>
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/8b814891-1803-4270-b9fe-0b97ec961245" />
<img width="1652" height="952" alt="image" src="https://github.com/user-attachments/assets/bce4f08d-be64-4991-8dce-e1c3f76e1f54" />
<img width="1652" height="952" alt="image" src="https://github.com/user-attachments/assets/1e1d9587-4d1e-4d41-9399-9fe19c5c0ad6" />
<br>
- 클래스 다형성(오버로딩)
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/07f0c248-c470-4529-b554-768719d99e21" />
<br>
- 객체 지향 프로그래밍의 2대 원칙
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/44281055-229e-4376-a923-cc610a0fbc4f" />
<br>
- 형변환
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/cbf0184e-d7db-49fe-a40f-8829fc5e02d0" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/92001e3e-82a8-408a-8d23-5a008a3876ba" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/e32ba550-e750-4e5a-b1c4-6d0971e29f9b" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/97af1056-82a9-4d8e-bcd0-1d09fb823459" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/42780571-9d23-4d88-9322-7417c36487c3" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/1225929e-e603-4b83-9923-c3cf0a61a279" />

<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/c459699b-611c-487f-9f1c-defec4a3d6d3" />

- 요약
<img width="2545" height="1427" alt="image" src="https://github.com/user-attachments/assets/e8986144-c3ec-4fd5-8d6d-a3f1333c4f52" />











