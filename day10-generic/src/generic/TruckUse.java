package generic;

public class TruckUse {
    public static void main(String[] args) {
        Truck<String, Integer> truck = new Truck<>();
        truck.weight = "heavy";
        truck.distance = 100;
        System.out.println(truck);

        Truck<Integer, Integer> truck2 = new Truck<>(100, 200);
        System.out.println(truck2);

    }
}
