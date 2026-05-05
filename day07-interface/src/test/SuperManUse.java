package test;

public class SuperManUse {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan("클라크", 22, 100, true);
        System.out.println(superMan);

        superMan.run();
        superMan.space();
        superMan.eat();
    }
}
