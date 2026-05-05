package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapExample {
    public static void main(String[] args) {
        //Map 컬렉션 생성
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

//        Map<Integer, String> map = new HashMap<>();
        //작업 스레드객체생성
        Thread threadA = new Thread() {
            @Override
            public void run() {
                //객체 1000개추가
                for (int i = 1; i <= 1000; i++) {
                    map.put(i, "내용" + i);
                }
            }
        };

        //작업스레드객체생성
        Thread threadB = new Thread() {
            @Override
            public void run() {
                //객체1000개추가
                for (int i = 1001; i <= 2000; i++) {
                    map.put(i, "내용" + i);
                }
            }
        };
        //작업스레드실행
        threadA.start();
        threadB.start();

        //작업스레드들이 모두 종료될때까지 메인스레드를 기다리게함
        try {
            threadA.join();
            threadB.join();
        } catch (Exception e) {
        }

        //저장된총객체수얻기
        int size = map.size();
        System.out.println("총객체수: " + size);
        System.out.println();
    }
}
