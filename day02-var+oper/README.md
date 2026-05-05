<img width="1196" height="1315" alt="image" src="https://github.com/user-attachments/assets/5a49c92d-5db5-4d77-86b6-9d0b7cd8b666" />
<img width="1077" height="1480" alt="image" src="https://github.com/user-attachments/assets/587a2cc9-d23f-44c9-aeb5-388c3fb6c650" />


<br>

# ☕ Java Basic Learning - Day 2

Java 프로그래밍 기초 2일차 학습 내용 정리입니다. 연산자, 형변환, 입력(Scanner), 그리고 배열의 기초를 다룹니다.

<img width="1877" height="1057" alt="image" src="https://github.com/user-attachments/assets/b9908ef7-c527-4fbd-8544-0b8eb4e3dae2" />
<img width="1868" height="1061" alt="image" src="https://github.com/user-attachments/assets/113582fc-9d71-40cb-a228-9a5e32072f17" />
<img width="1960" height="1107" alt="image" src="https://github.com/user-attachments/assets/2cefa10d-878b-4704-a118-780bdcc99413" />
<img width="1868" height="1057" alt="image" src="https://github.com/user-attachments/assets/d340da2b-2923-4751-bfe6-7f09fff55a21" />
<img width="1875" height="1063" alt="image" src="https://github.com/user-attachments/assets/3895dc04-95bf-40f9-a63e-532c94dbce89" />

<img width="1961" height="1108" alt="image" src="https://github.com/user-attachments/assets/37d2fbc9-3f12-417b-be7e-8f9056ab9716" />
<img width="1875" height="1054" alt="image" src="https://github.com/user-attachments/assets/57ba7118-ab15-4264-8204-cc2f0451fddb" />
<img width="1872" height="1060" alt="image" src="https://github.com/user-attachments/assets/4e92d579-0a44-4bd5-9cfa-6987b8b98fbb" />
<img width="1973" height="1108" alt="image" src="https://github.com/user-attachments/assets/ea337fef-b64a-4ff7-9566-b746b3dfa3cc" />
<img width="1973" height="1108" alt="image" src="https://github.com/user-attachments/assets/56b37896-f5b2-4504-b580-e2557f9603f7" />
<img width="1959" height="1106" alt="image" src="https://github.com/user-attachments/assets/93a2451f-8bf6-4404-94fd-b1cd7e254e77" />
<img width="1959" height="1106" alt="image" src="https://github.com/user-attachments/assets/735f7b21-7e5a-4086-b481-a53e4197d300" />

- 아스키코드(ASCII, AMERICAN STANDADARD CHARACTOR....) --> UNICODE에 포함
  <img width="632" height="299" alt="image" src="https://github.com/user-attachments/assets/f27efb26-815c-4d80-afcc-c13f43ddec9b" />
- 8비트로 표현될 수 있는 정수값의 범위, 자바
<img width="629" height="503" alt="image" src="https://github.com/user-attachments/assets/d3bf5e28-1a22-4bb1-9d24-d08eec4d1c5e" />

```
2의 0승 - 1
2의 1승 - 2
2의 2승 - 4
2의 3승 - 8
2의 4승 - 16
2의 5승 - 32
2의 6승 - 64


2¹ = 2
2² = 4
2³ = 8
2⁴ = 16
2⁵ = 32
2⁶ = 64
총합 = 1 + 2 + 4 + 8 + 16 + 32 + 64 = 127

맨 앞 비트는 부호비트(1, 0)

맨 앞 비트 (최상위 비트, MSB) 가 부호를 결정
0이면 → 양수 (Positive)
1이면 → 음수 (Negative)



```

<img width="595" height="493" alt="image" src="https://github.com/user-attachments/assets/1321b133-5515-4b08-a62b-d202bab7705a" />
<img width="1194" height="117" alt="image" src="https://github.com/user-attachments/assets/4dc9f14a-262c-485f-841d-069a936b47f2" />
<img width="1193" height="182" alt="image" src="https://github.com/user-attachments/assets/a40767a9-a6b5-4623-bcf1-ccf79bcfb42b" />


- jdk download
  jdk17 download(windows) - https://jdk.java.net/java-se-ri/17
- 컴파일+실행
<img width="1528" height="1852" alt="image" src="https://github.com/user-attachments/assets/b9decace-6563-4011-abf7-3e82205edf3a" />
<img width="735" height="526" alt="image" src="https://github.com/user-attachments/assets/3100ef7e-ec2a-41bc-9085-1d014ed6483d" />
<img width="1973" height="1564" alt="image" src="https://github.com/user-attachments/assets/efc792ca-6def-422b-a779-614466aa0639" />

- 패키지 만들기
<img width="1745" height="795" alt="image" src="https://github.com/user-attachments/assets/da6a61cd-b53d-4efc-9538-88c8a3a67549" />

- 한국어 언어팩 삭제(영어로 사용하고자 하는 경우)
<img width="2282" height="1867" alt="image" src="https://github.com/user-attachments/assets/b2aac58b-665b-4655-9f6a-97647d17e521" />

- 코드리포맷(코드정리) - reformat(한글로) ==> 에러 없을 때만 코드정리해줌.
<img width="2272" height="1774" alt="image" src="https://github.com/user-attachments/assets/129371a9-2c84-493f-8456-2830610eca37" />


- new(한글로) --> 변경하지 말고 alt + insert를 그대로 쓰시기를 권장
- 영문버전으로는 키를 변경하는 것이 적용이 되는데 한글로는 적용이 되지 않음.
<img width="2255" height="1763" alt="image" src="https://github.com/user-attachments/assets/89b4928a-a32d-46bc-99a2-92863b06d165" />


```
package test;

//자바파일하나 == class
//class이름은 파일명과 동일해야함.
//파일이름은 무조건 대문자로 시작
//낙타표기법
//클래스 첫줄은 무조건 패키지이름
//문장의 끝은 무조건 ;을 붙여야함.
public class Primitive {
    public static void main(String[] args) {
        //기본형 4가지
        //변수하나에 값하나 저장됨.
        //정수, 실수, 문자1, 논리
        //정수
        int age = 100; //정적타입핑, 정수말고는 다른 것 넣으면 에러
        //실수
        double height = 122.2; //소수점 15자리까지
        //문자1
        char gender = '남'; //무조건 홑따옴표
        //논리
        boolean food = true; //false

        //주의점.
        //정수는 byte --> short --> int --> long
        long money = 3333333333L; //L, l
        //실수는 float --> double
        float weight = 88.8F;
        //88.80000000000000 처럼 인식함.

        //추가
        //사람은 문자1글자보다 문자를 여러개를 많이 씀(문자열)
        String name = "홍길동"; //이중따옴표를 써야함.

        System.out.println("나이는 " + age + "세");
        System.out.println("성별은 " + gender + "임");
    }
}

```



  












## 📂 프로젝트 구조

```mermaid
graph TD
    Project[day2] --> src
    src --> oper[oper 패키지]
    src --> control[control 패키지]
    src --> array[array 패키지]
    
    oper --> Oper1[Oper1.java: 연산 및 형변환]
    control --> InputTest[InputTest.java: 입출력 제어]
    array --> Array1[Array1.java: 배열 기초]
```

---

## 📝 주요 학습 내용

### 1. 연산 및 형변환 (Casting)
`Oper1.java`에서는 기본적인 산술 연산과 데이터 타입 간의 변환을 학습합니다.

- **자동 형변환 (Promotion):** 작은 타입에서 큰 타입으로 변환될 때 자동으로 발생합니다. (예: `byte` -> `int` -> `double`)
- **강제 형변환 (Casting):** 큰 타입에서 작은 타입으로 변환할 때 데이터 손실을 감수하고 명시적으로 변환합니다. `(type)` 연산자를 사용합니다.
- **정수 연산의 특징:** 자바에서 `int` 간의 나눗셈 결과는 항상 `int`입니다. 실수 결과를 얻으려면 피연산자 중 하나를 `double`로 형변환해야 합니다.

### 2. 입출력 (Input/Output)
`InputTest.java`에서는 사용자로부터 입력을 받는 방법을 학습합니다.

- **System.out:** 표준 출력 장치 (모니터)
- **System.in:** 표준 입력 장치 (키보드)
- **Scanner 클래스:** `java.util.Scanner`를 사용하여 키보드 입력을 쉽게 처리할 수 있습니다.
  - `nextLine()`: 사용자로부터 한 줄의 문자열을 입력받습니다.
  - 모든 입력 데이터는 기본적으로 **문자열(String)** 타입으로 들어옵니다.

### 3. 배열 기초 (Array)
`Array1.java`에서는 데이터를 그룹으로 묶어 관리하는 배열을 다룹니다.

- **배열 선언 및 생성:** `int[] x = new int[10];`
- **참조형 변수:** 배열 변수 `x`를 출력하면 실제 값이 아닌 메모리 주소가 출력됩니다.
- **배열 길이:** `x.length`를 통해 배열의 크기를 확인할 수 있습니다.

---

## 🚀 실행 방법

각 Java 파일을 컴파일한 후 실행합니다.

```bash
# 예시: Oper1 실행
javac src/oper/Oper1.java
java -cp src oper.Oper1
```

