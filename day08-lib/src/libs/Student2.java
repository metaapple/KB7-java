package libs;


public class Student2 {

    private String id;
    private String name;

    public Student2(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //객체를 비교할 때 원래 Object의 hashcode()를 구해서 비교
    //set에서는 객체비교시 생성된 주소(해시코드)만 가지고 비교하면 다 다르게 여김.
    //객체비교시 객체가 가르키고 있는 필드들의 주소와 필드의 값이 동일한지 비교해야함.

    //객체가 가르키고 있는 필드들의 주소
    //객체가 가르키고 있는 필드의 값
    //프로그래머가 비교하고 싶은 대로 재정의 해야함.


    @Override
    public boolean equals(Object obj) {
        boolean result = false;
  //객체가 동일한지 비교할 때는 내부 필드의 값들이 동일한지 비교해야함.
    //------------  if (obj instance of Student2){ Student2 s = (Student2) obj;}
    //------------  if (obj instanceof Student2 s)와 동일
        if (obj instanceof Student2 s) {
            result = s.id.equals(id) && s.name.equals(name);
        }
        return result;
    }

// 원래 Object의 hashCode()는 해시테이블의 hash값(주소와 매핑되는 값)을 리턴, hashset에서는 중복된 값을 넣지 않아야 하는데,
// new 동일클래스(동일값1), new 클래스(동일값1)인 경우 주소(hash값)가 다르므로 동일값1이 들어가도 다른 대상으로 여김.
// 기존의 hash값을 비교하는 것으로 hashset에 넣으면 중복처리가 제대로 되지않음.
// 그 hash값의 필드의 주소가 동일한지 비교하면 이런 문제가 사라짐.
 //객체가 동일한지 비교할 때는 내부 필드의 값들이 들어있는 위치가 동일한지 비교해야함.
    @Override
    public int hashCode() {
        return id.hashCode() + name.hashCode();
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
