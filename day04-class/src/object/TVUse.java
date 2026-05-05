package object;

public class TVUse {
    public static void main(String[] args) {
        //클래스를 가지고 여러 객체를 만들 수 있다.
        //객체 생성(new)
        Television tv = new Television(); //멤버변수가 생성됨.
        //size, price변수가 만들어짐.
        //tv는 참조형변수이고
        //힙영역에 만들어진 size, price가 저장된 주소가 저장
        System.out.println(tv); //주소
        System.out.println(tv.price); //0
        System.out.println(tv.size); //null

        tv.price = 100000;
        tv.size = "big";

        System.out.println(tv.price + " " + tv.size);

        tv.powerOn();
        tv.powerOff();

        Television tv2 = new Television();
        System.out.println(tv2.price + " " + tv2.size);

        tv2.price = 200000;
        tv2.size = "small";
        System.out.println(tv2.price + " " + tv2.size);
        System.out.println(tv2);

        //리턴이 있는 메서드는 리턴받을 값을 가지고
        //어떤 처리를 이어서 해야함.
        System.out.println(tv2.getPrice());

        //변수에 리턴값을 넣어두고 다른 처리들을
        //이어서해도 됨.
        int price2 = tv2.getPrice();
        System.out.println(price2 - 10000);

        //void인 메서드를 호출한 경우
        //리턴한 값이 없으므로 출력X, 변수할당X
        //System.out.println(tv2.powerOn());
        int price3 = tv2.getPrice(100);
        System.out.println("할인 가격은 " + price3);

        //호출할 때 같은 이름이 여러개 불러진다.
        //오버로딩
    }
}
