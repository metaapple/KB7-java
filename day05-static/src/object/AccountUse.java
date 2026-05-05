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










