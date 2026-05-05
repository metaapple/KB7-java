package test;

public class SuperMan extends Man {
    boolean fly; //false

    public SuperMan(String name, int age, int power, boolean fly) {
        super(name, age, power);
        this.fly = fly;
    }

    //우주를 날다.
    public void space(){
        //부모클래스로부터 상속받은 필드와 메서드는
        //자식클래스에서 바로 호출/접근해서 사용 가능
        sleep();
        System.out.println("수퍼맨 이름은 " + name);
        System.out.println("하늘을 날다.");
    }

    //eat()재정의
    @Override
    public void eat() {
        System.out.println("많이 먹다.");
    }

    //toString()재정의
    @Override
    public String toString() {
        //Object의 toString()은 "패키지명.클래스명@주소" 형태의 문자열을 만들어 리턴해주는 메서드
        //해당 클래스의 객체생성후 생성된 객체의 주소를 프린트할 때 자동 호출됨.
        //Car car = new Car();
        //System.out.println(car); //test.CarUse@dsids12f
        //car의 주소가 가르키고 힙영역에 만들어진 필드들의 값을 프린트하는 것으로 재정의해서 많이 씀.
        //컨트롤 + 스페이스바(자동완성)
        return name + " " + age + " " + power + " " + fly;
    }
}
