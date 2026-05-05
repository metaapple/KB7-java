package generic;

public class Truck <T1, T2>{
    //필드, 생성자, 메서드
    T1 weight;
    T2 distance;

    public Truck() {
    }

    public Truck(T1 weight, T2 distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public T1 getWeight() {
        return weight;
    }

    public void setWeight(T1 weight) {
        this.weight = weight;
    }

    public T2 getDistance() {
        return distance;
    }

    public void setDistance(T2 distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "weight=" + weight +
                ", distance=" + distance +
                '}';
    }
}
