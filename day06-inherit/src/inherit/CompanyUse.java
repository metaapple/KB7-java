package inherit;

public class CompanyUse {
    public static void main(String[] args) {

        Employee e = new Employee("홍길동", "광진구", 100000, "040701");
        System.out.println(e); //객체 프린트하면 toString() 무조건 호출됨.

        System.out.println(e.name); //public
        System.out.println(e.salary); //default
        System.out.println(e.address); //protected
//        System.out.println(e.rrn); //private

        System.out.println(e.getRrn());

        Manager manager = new Manager("김길동", "영등포", 100000, "040201", 1000);
        System.out.println(manager);

        manager.test();

        //e.test();
    }
}
