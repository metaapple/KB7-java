package collection;

public class Person3 {
    public void action(Calcuable calcuable){
        double result = calcuable.calc(10, 20);
        System.out.println("결과 : " + result);
    }
}
