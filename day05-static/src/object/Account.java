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
