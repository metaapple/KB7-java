package object;

//컴파일러가 번역할 때 자동으로 넣어줌.
//개발자는 써주지 않음.
//import java.lang.*;

import javax.swing.*;
import java.awt.*;

public class Graphic {
    public static void main(String[] args) {
        //필요한 부품들을 생각해보자.
        //틀 --> JFrame
        //배치 --> FlowLayout
        //버튼 --> JButton
        //글자 --> Font

        //JFrame클래스로 객체를 만들어주세요.
        //new --> 객체생성과 관련된 키워드
        JFrame frame = new JFrame("나의 첫 자바프로그램"); //힙영역에 멤버변수들을 복사
        FlowLayout layout = new FlowLayout();
        JButton button = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        //객체생성시 멤버변수들을 내가 원하는 값으로 초기화하고 하고 싶은 경우
        //"클래스이름과 동일한 메서드"를 만들어서 객체생성과 동시에
        //초기화가 가능함. ==> 생성자 메서드(생성자, CONSTRUCTOR)
        //객체 생성시 클래스이름과 동일한 메서드인 생성자 메서드가 있으면
        //자동 호출되면서 멤버변수 자동 초기화
        Font font = new Font("궁서", Font.BOLD, 30);

        //프레임은 가로/세로 설정이 꼭 있어야한다.
        frame.setSize(400,400);
//        frame.setTitle("나의 첫 자바프로그램");
        //프레임에 레이아웃 설정
        frame.setLayout(layout); //왼쪽부터 붙이고, 가운데 정렬
        frame.add(button);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(new JButton("버튼5")); //ok
        //버튼5를 담고 있는 변수가 없어서 버튼안에 있는 메서드나 변수를 접근 불가능

        button.setText("버튼1");
        button2.setText("버튼2");
        button3.setText("버튼3");
        button4.setText("버튼4");

        //프로그램할 때 자주쓰는 변수(보통 상수)나 메서드는
        //클래스이름으로 바로 접근해서 사용 가능하게 만들어놓았음.
        //Color.pink, Font.BOLD, Math.PI
        //Math.random(), Integer.parseInt() : String("100") --> int(100)
        //Float.parseFloat(), Double.parseDouble()
        //String.valueOf() : int(100) --> String("100")
        //메모리에 항상 상주하고 있어서 클래스이름으로 접근/불러서 사용 가능함
        //static(정적) 변수/메서드
        button.setBackground(Color.CYAN);
        button2.setBackground(Color.pink);
        button3.setBackground(Color.yellow);
        button4.setBackground(Color.ORANGE);


        button.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        button4.setFont(font);

        //프레임은 위 설정에 맞게 보여지게 해야함.
        //기본값은 보이는 것으로 설정을 바꾸어주어야함.
        //맨 마지막에 써야함.
        frame.setVisible(true);
    }
}
