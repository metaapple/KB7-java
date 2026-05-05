package test;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.Date;

public class ThreadRun extends JFrame {
    JLabel top = new JLabel("1"); //전역변수, 글로벌변수
    JLabel center = new JLabel("2");
    JLabel sub = new JLabel("3");

    public ThreadRun() {
        getContentPane().setBackground(Color.GREEN);
        setTitle("나의 멀티스레드");
        setSize(875, 360);

        top.setFont(new Font("Arial Narrow", Font.BOLD, 65));
        getContentPane().add(top, BorderLayout.NORTH);

        center.setFont(new Font("굴림", Font.PLAIN, 54));
        getContentPane().add(center, BorderLayout.CENTER);

        sub.setFont(new Font("Arial Narrow", Font.BOLD, 50));
        getContentPane().add(sub, BorderLayout.SOUTH);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(Color.GREEN);
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 35));
        getContentPane().add(lblNewLabel, BorderLayout.WEST);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setForeground(Color.GREEN);
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 35));
        getContentPane().add(lblNewLabel_1, BorderLayout.EAST);

///// 스레드 객체 만들기(익명클래스 이용)
        Thread counter = new Thread(){
            @Override
            public void run() {
                for (int i = 500; i > 0 ; i--) {
                    top.setText(String.valueOf(i));
                    System.out.println("현재 스레드 이름: " + getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("카운터 에러 발생함.");
                    }
                }
            }
        };

        Thread timer = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 300; i++) {
                    Date date = new Date();
                    sub.setText(String.valueOf(date));
                    System.out.println("현재 thread이름 : " + getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread img = new Thread(){
            @Override
            public void run() {
                String[] img = {"1.png", "2.png", "3.png", "4.png", "5.png"};
                for (int i = 0; i < img.length; i++) {
                    center.setText("이미지: " + img[i]);
                    //ImageIcon icon = new ImageIcon(img[i]);
                    //center.setIcon(icon);
                    System.out.println("현재 thread이름 : " + getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


///// cpu 스케쥴러에 스레드 등록
        counter.start();
        img.start();
        timer.start();


        setVisible(true);
    }

    public static void main(String[] args) {
        ThreadRun t = new ThreadRun();
    }
}