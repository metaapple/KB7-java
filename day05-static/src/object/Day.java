package object;

public class Day {
    //인스턴스 변수
    //객체생성시 힙영역에 복사
    private String doing;
    private int time;
    private String location;
    //정적 변수, static변수
    //메모리 원본 영역에 한 개만 존재
    static int count;

    public Day(String doing, int time, String location) {
        //this는 이 클래스로 만든 객체
        this.doing = doing;
        this.time = time;
        this.location = location;
        count++; //누적용
    } //생성자

    //내가 만드는 메서드는 가운데에 넣는 편
    //객체 만들지 않고도 클래스이름으로
    //바로 접근해서 메서드를 호출하고 싶을 때
    public static int getCount(){
        //static만들 때 조심할 것
        //인스턴스 변수를 넣을 수 없음.
        //static 변수만 넣을 수 있음.
        return count;
    }

    public String getDoing() {
        return doing;
    }

    public void setDoing(String doing) {
        this.doing = doing;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static void setCount(int count) {
        Day.count = count;
    }

    //toString()을 수정해서 재정의하자.
    @Override
    public String toString() {
        return "Day{" +
                "doing='" + doing + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }
} //클래스
