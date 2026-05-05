package libs;

import java.util.ArrayList;
import java.util.LinkedList;

public class TimeCompareTest {

    public static void main(String[] args) {

        final int SIZE = 100000;

        // =========================
        // 1. 배열
        // =========================
        int[] arr = new int[SIZE];

        long start = System.nanoTime();

        // 값 넣기
        for (int i = 0; i < SIZE; i++) {
            arr[i] = i;
        }

        long end = System.nanoTime();
        System.out.println("배열 입력 시간: " + (end - start));

        start = System.nanoTime();

        // 조회
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += arr[i];
        }

        end = System.nanoTime();
        System.out.println("배열 조회 시간: " + (end - start));


        // =========================
        // 2. ArrayList
        // =========================
        ArrayList<Integer> arrayList = new ArrayList<>();

        start = System.nanoTime();

        // 추가
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
        }

        end = System.nanoTime();
        System.out.println("ArrayList 추가 시간: " + (end - start));

        start = System.nanoTime();

        // 조회
        sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += arrayList.get(i);
        }

        end = System.nanoTime();
        System.out.println("ArrayList 조회 시간: " + (end - start));


        // =========================
        // 3. LinkedList
        // =========================
        LinkedList<Integer> linkedList = new LinkedList<>();

        start = System.nanoTime();

        // 추가
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(i);
        }

        end = System.nanoTime();
        System.out.println("LinkedList 추가 시간: " + (end - start));

        start = System.nanoTime();

        // 조회 (⚠️ 매우 느림)
        sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += linkedList.get(i);
        }

        end = System.nanoTime();
        System.out.println("LinkedList 조회 시간: " + (end - start));
    }
}

//배열 입력 시간: 1242222
//배열 조회 시간: 1561248
//ArrayList 추가 시간: 4413078
//ArrayList 조회 시간: 5161114
//LinkedList 추가 시간: 7472085
//LinkedList 조회 시간: 4291761118

