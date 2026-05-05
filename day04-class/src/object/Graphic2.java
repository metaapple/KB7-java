package object;

import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class Graphic2 {
    public static void main(String[] args) {

        //전체 틀 : JFrame
        JFrame frame = new JFrame();
        frame.setSize(500, 500);

        //레이아웃 설정 : FlowLayout(순서대로 frame에 붙여줌. 넘치면 다음줄로 넘어감.)
        FlowLayout layout = new FlowLayout();
        //전체틀(프레임)에 레이아웃 설정
        frame.setLayout(layout);


        //버튼 생성, button, button2
        JButton button = new JButton();
        //생성된 버튼에 텍스트 저장 동작(메서드)
        button.setText("버튼1");


        ////////[[ JButton class 코드 ]]//////////
        // public class JButton {

        //     //멤버변수
        //     String text;

        //     //멤버메서드
        //     public void setText(String t) {
        //         //button의 텍스트를 지정
        //          text = t;
        //     }
        // }
        /////////////////////////////////////////


        button.setBackground(Color.RED);
        frame.add(button);

        //버튼 생성, button, button2, button3, 버튼4
        JButton button2 = new JButton();
        button2.setText("버튼2");
        button2.setBackground(Color.BLUE);
        frame.add(button2);

        JButton button3 = new JButton("버튼3");
        button3.setBackground(Color.PINK);
        frame.add(button3);

        frame.add(new JButton("버튼4"));

        //맥 user만 넣어주세요.!! ---------
        button.setOpaque(true);
        button2.setOpaque(true);
        button3.setOpaque(true);
        //맥 user만 넣어주세요.!! ---------

        //생성자(객체 생성하면서 동시에 멤버 변수 초기화하고 싶은 경우 사용)
        //클래스이름과 동일한 메서드를 생성자라고 함.
        //객체 생성하면서 멤버변수 자동초기화함)
        Font font = new Font("맑은 고딕", Font.BOLD, 20);
        button.setFont(font);
        button2.setFont(font);
        button3.setFont(font);

        //항상 맨 끝!!
        //화면에 보여주기
        frame.setVisible(true);
    }
}