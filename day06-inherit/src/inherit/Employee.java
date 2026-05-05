package inherit;

public class Employee extends Object{
    /**
     * Object이 가지는 필드와 메서드를 다 상속받았음.
     * toString() --> Employee e = new Employee();
     * System.out.println(e) --> 패키지명.클래스명@ds9dspfs
     * 주소말고 toString()을 재정의해서 많이 씀.
     * 주소가 가르키는 필드값들 문자열로 만들어주는 기능으로 재정의해서 많이씀.
     * 부모에게 받은 메서드를 똑같이 써주면됨.(오버라이드, 재정의)
     * -------------------------------------------------------
     * 클래스는 기본적으로 3가지를 가짐
     * 필드(멤버변수)
     */
    public String name; //null로 초기화
    String address;
    protected int salary; //0
    private String rrn; //주민번호, null로 초기화

    //생성자
    //프로그래머가 안쓰면 컴파일할 때 기본생성자가 자동으로 추가됨.
    //객체생성한 후 초기화 나중에 하게 하고 싶고
    public Employee(){

    }
    //객체생성할 때 필드값 넣어서 초기화 동시에 하고 싶고
    public Employee(String name, String address, int salary, String rrn) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.rrn = rrn;
    }

    //멤버메서드
    //값넣을 때 set필드명(첫글자대문자) --> setter
    //값꺼낼 때 get필드명(첫글자대문자) --> getter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    @Override //--> 의미없는 표시를 넣어서 프로그래머가 구분하기 쉽게 도와줌.
    //@ --> hera@naver.com : naver.com에(At) 가입한 hera
    //@ --> Annotation(어노테이션, 애노테이션, 표시)
    //Car car = new Car()'
    //System.out.println(car); --> toString()을 무조건 호출함.
    //Object에 있는 toString()은 패키지명.클래스명@주소
    //우리가 만든 클래스에서 toString()을 재정의해서 필드값 문자열로 만들어주면 더 편함.
    public String toString() {
        return name + " " + address + " " + salary + " " + rrn;
    }
}
