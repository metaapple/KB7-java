package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.point.*;

public class Graphic2_2 {
    //static main안에서 사용할 변수이므로 똑같이 static으로 선언
    static int count = 0;
    public static void main(String[] args) {
        //필요한 객체 ram에 가져다 두어야함.
//        JFrame frame = new JFrame(); //기본 생성자 메서드가 자동 호출
//        frame.setTitle("나의 첫 그래픽 프로그램"); //멤버변수가 title에 메서드로 문자열을 넣음.
        //멤버변수를 직접 접근해서 값을 넣거나 꺼내거나 하는 작업을 잘하지 않음.
        //set멤버변수이름, get멤버변수이름으로 메서드를 만들어서 멤버변수를 넣거나 꺼내는 작업을 하는 편.
        //frame.title = "나의 첫 그래픽 프로그램";
        JFrame frame = new JFrame("나의 첫 그래픽 프로그램");
        frame.setSize(600, 500);
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout); //주소를 넣음.!!
        JButton button = new JButton("1증가");
        JButton button2 = new JButton("1감소");
        JButton button3 = new JButton("0으로 초기화");
        JLabel result = new JLabel("0"); //String.valueOf(0)

        frame.add(button);
        frame.add(button3);
        frame.add(button2);
        frame.add(result);

        //글자를 키우자.
        Font font = new Font("궁서", Font.BOLD, 40);
        button.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        result.setFont(new Font("궁서", Font.ITALIC, 400));

        //색을 넣어보자. 배경색 + 글자색
        button.setBackground(Color.RED);
        button2.setBackground(Color.BLUE);
        button.setForeground(Color.YELLOW);
        button2.setForeground(Color.YELLOW);
        button3.setBackground(Color.GREEN);
        button3.setForeground(Color.YELLOW);
        result.setForeground(Color.RED);

        //맥유저는 넣어주세요.
        button.setOpaque(true);
        button2.setOpaque(true);

        //버튼 이벤트 처리해보자.(인터페이스 사용)
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                result.setText(count + "");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                result.setText(count + "");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                result.setText(count + "");
            }
        });

        //위 설정대로 하면에 보여주세요!! 맨 끝에 위치해야함.
        frame.setVisible(true);
    }
}
