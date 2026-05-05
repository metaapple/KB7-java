package collection;

import java.util.ArrayList;
import java.util.List;

public class BoardUse {
    public static void main(String[] args) {
        List<Board> list = new ArrayList<>();
        list.add(new Board("홍", "펀", "hong"));
        list.add(new Board("홍2", "펀", "hong"));
        list.add(new Board("홍3", "펀", "hong"));
        list.add(new Board("홍4", "펀", "hong"));
        list.add(new Board("홍5", "펀", "hong"));

        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}
