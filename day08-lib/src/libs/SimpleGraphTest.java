package libs;
import java.util.*;

public class SimpleGraphTest {

    public static void main(String[] args) {

        int size = 100000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // 데이터 채우기
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // =====================
        // 측정
        // =====================
        long start = System.nanoTime();
        arrayList.get(size / 2);
        long arrayTime = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.get(size / 2);
        long linkedTime = System.nanoTime() - start;

        // =====================
        // 그래프 출력
        // =====================
        printGraph("ArrayList", arrayTime);
        printGraph("LinkedList", linkedTime);
    }

    public static void printGraph(String name, long time) {
        int length = (int)(time / 1000); // scale

        System.out.printf("%-12s | ", name);
        for (int i = 0; i < length; i++) {
            System.out.print("■");
        }
        System.out.println(" " + time + " ns");
    }
}


//ArrayList   | ■■■■■ 5000 ns
//LinkedList  | ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 500000 ns
