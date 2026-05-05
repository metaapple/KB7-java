package string;

public class Test {
    public static void main(String[] args) {
        String strVar1 = "홍길동";
        String strVar2 = "홍길동";
        if (strVar1 == strVar2) {
            System.out.println("주소가 같음");
        } else {
            System.out.println("주소가 다름");
        }
        if (strVar1.equals(strVar2)) {
            System.out.println("힙영역의 데이터가 동일함");
        }

        String strVar3 = new String("홍길동");
        String strVar4 = new String("홍길동");

        if (strVar3 == strVar4) {
            System.out.println("주소가 같음");
        } else {
            System.out.println("주소가 다름");
        }
        if (strVar3.equals(strVar4)) {
            System.out.println("힙영역의 데이터가 동일함");
        }

        strVar3 = "홍길동";
        if (strVar3 == strVar4) {
            System.out.println("주소가 같음");
        } else {
            System.out.println("주소가 다름");
        }
        if (strVar3.equals(strVar4)) {
            System.out.println("힙영역의 데이터가 동일함");
        }

    }
}
