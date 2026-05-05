package test;

public class SyncTest {
    public static void main(String[] args) {
        BankAccount2 bankAccount = new BankAccount2();
        Thread t1 = new Thread(bankAccount);
        Thread t2 = new Thread(bankAccount);
        t1.start();
        t2.start();
    }
}
