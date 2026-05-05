package test;

import java.util.LinkedList;
import java.util.Queue;

public class CardTest {
    public static void main(String[] args) {
        //카드 문제는
        //rule1) 카드수를 입력 : 6 (1~6카드를 만든다.)
        //rule2) 맨앞에 있는 카드를 제거합니다.
        //rule3) 맨 앞으로 두번째 있었던 카드를 맨끝으로 붙인다.
        // --> rule2-3을 반복한 후 마지막에 남은 카드 번호가 몇 번입니까??
        //큐 --> LinkedList() : remove(), poll() --> add()

        int x = 6;

        //rule1) 카드수를 입력 : 6 (1~6카드를 만든다.)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= x; i++){
            queue.add(i);
        }
        System.out.println(queue);

        //rule2) 맨앞에 있는 카드를 제거합니다.
        //rule3) 맨 앞으로 두번째 있었던 카드를 맨끝으로 붙인다.
        for (int i = 0; i <= queue.size(); i++){
            queue.remove(); //맨 앞에 있는 것 삭제
            System.out.println(queue);
            queue.add(queue.poll());
            System.out.println(queue);
        }
        queue.remove();
        System.out.println(queue);
    }
}
