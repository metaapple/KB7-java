package string;
import javax.swing.*;
import java.awt.*;
import java.util.Random;import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BopgiProgram extends JFrame {

    JButton[] buttons = new JButton[25];
    JButton startBtn;
    JLabel resultLabel;
    JLabel timerLabel;
    Random rand = new Random();
    boolean isRunning = false;
    Timer countdownTimer;
    int remainingTime = 20;

    public BopgiProgram() {
        setTitle("뽑기 프로그램 하나만 짱!!");
        setSize(760, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 상단 제목
        JLabel title = new JLabel("뽑기 프로그램 하나만 짱!!", SwingConstants.CENTER);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        title.setBackground(new Color(255, 50, 120));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setPreferredSize(new Dimension(760, 90));
        add(title, BorderLayout.NORTH);

        // 번호 버튼 패널
        JPanel panel = new JPanel(new GridLayout(5, 5, 15, 15));
        panel.setBackground(new Color(255, 180, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        Color[] buttonColors = {
                new Color(255, 100, 100), new Color(255, 160, 60),
                new Color(255, 220, 80), new Color(100, 220, 100),
                new Color(80, 180, 255), new Color(180, 100, 255)
        };

        for (int i = 0; i < 25; i++) {
            buttons[i] = new JButton(i + "번");
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 17));
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setBackground(buttonColors[i % 6]);
            buttons[i].setFocusable(false);
            panel.add(buttons[i]);
        }
        add(panel, BorderLayout.CENTER);

        // 하단
        JPanel bottomPanel = new JPanel(new BorderLayout(0, 10));
        bottomPanel.setBackground(new Color(255, 120, 200));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 15, 20));

        timerLabel = new JLabel("20", SwingConstants.CENTER);
        timerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 55));
        timerLabel.setForeground(Color.WHITE);

        startBtn = new JButton("🎰 뽑기 시작!");
        startBtn.setFont(new Font("맑은 고딕", Font.BOLD, 26));
        startBtn.setBackground(new Color(255, 70, 150));
        startBtn.setForeground(Color.WHITE);
        startBtn.setPreferredSize(new Dimension(760, 70));

        resultLabel = new JLabel("당첨 결과가 여기에 표시됩니다", SwingConstants.CENTER);
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        resultLabel.setForeground(Color.WHITE);

        bottomPanel.add(timerLabel, BorderLayout.NORTH);
        bottomPanel.add(startBtn, BorderLayout.CENTER);
        bottomPanel.add(resultLabel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        startBtn.addActionListener(e -> {
            if (isRunning) return;
            startDrawing();
        });
    }

    private void startDrawing() {
        isRunning = true;
        startBtn.setEnabled(false);
        remainingTime = 20;
        timerLabel.setText("20");
        timerLabel.setForeground(Color.WHITE);
        resultLabel.setText("뽑는 중...");

        final int winning = rand.nextInt(25);

        countdownTimer = new Timer(1000, e -> {
            remainingTime--;
            timerLabel.setText(String.valueOf(remainingTime));

            if (remainingTime <= 5) {
                timerLabel.setForeground(new Color(255, 80, 80));
            }

            if (remainingTime <= 0) {
                countdownTimer.stop();
                finishDrawing(winning);
            }
        });
        countdownTimer.start();

        // 번호 돌리는 애니메이션
        new Thread(() -> {
            try {
                int delay = 45;
                for (int round = 0; round < 7; round++) {
                    for (int i = 0; i < 25; i++) {
                        if (!isRunning) return;
                        final int num = i;
                        SwingUtilities.invokeLater(() -> highlightButton(num));
                        Thread.sleep(delay);
                    }
                    delay += 10;
                }
            } catch (InterruptedException ex) {}
        }).start();
    }

    private void finishDrawing(int winning) {
        SwingUtilities.invokeLater(() -> {
            resetButtonColors();
            buttons[winning].setBackground(new Color(255, 30, 30));
            buttons[winning].setForeground(Color.WHITE);
            buttons[winning].setText(winning + "번 당첨!!");

            resultLabel.setText("🎉 " + winning + "번 당첨되었습니다! 🎉");
            resultLabel.setForeground(new Color(255, 255, 80));

            showWinnerPopup(winning);
        });

        isRunning = false;
        startBtn.setEnabled(true);
    }

    private void highlightButton(int num) {
        resetButtonColors();
        buttons[num].setBackground(new Color(255, 255, 100));
    }

    private void resetButtonColors() {
        Color[] buttonColors = {
                new Color(255, 100, 100), new Color(255, 160, 60),
                new Color(255, 220, 80), new Color(100, 220, 100),
                new Color(80, 180, 255), new Color(180, 100, 255)
        };

        for (int i = 0; i < 25; i++) {
            buttons[i].setBackground(buttonColors[i % 6]);
            buttons[i].setForeground(Color.BLACK);
            String text = buttons[i].getText();
            if (text.contains(" 당첨!!")) {
                buttons[i].setText(text.replace(" 당첨!!", ""));
            }
        }
    }

    // 개선된 귀여운 팝업 (글자 크게 + 선명 + 그림 강화)
    private void showWinnerPopup(int winning) {
        JDialog popup = new JDialog(this, "🎉 당첨 축하합니다! 🎉", true);
        popup.setSize(560, 480);
        popup.setLocationRelativeTo(this);
        popup.getContentPane().setBackground(new Color(255, 240, 250)); // 밝은 핑크 배경
        popup.setLayout(new BorderLayout(10, 20));

        // 상단 당첨 메시지 - 크게, 굵게, 선명한 색상
        JLabel msg = new JLabel("<html><center><font color='#FF0066' size='7'>"
                + winning + "번<br>당첨!</font></center></html>", SwingConstants.CENTER);
        msg.setFont(new Font("맑은 고딕", Font.BOLD, 36));

        // 귀여운 캐릭터 영역 (더 크고 선명하게)
        JLabel character = new JLabel("🎉 🏆 ✨", SwingConstants.CENTER);
        character.setFont(new Font("Dialog", Font.PLAIN, 90));   // 매우 큰 이모지
        character.setForeground(new Color(255, 140, 0));

        // 추가 귀여운 텍스트
        JLabel subText = new JLabel("<html><center><font color='#FF3399' size='5'>"
                + "축하해요!!<br>"
                + "오늘 최고의 운이네요~<br>"
                + "💖 💖 💖</font></center></html>", SwingConstants.CENTER);
        subText.setFont(new Font("맑은 고딕", Font.BOLD, 24));

        JButton closeBtn = new JButton("확인하고 다시 뽑기 🎊");
        closeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        closeBtn.setBackground(new Color(255, 80, 120));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setPreferredSize(new Dimension(200, 60));

        popup.add(msg, BorderLayout.NORTH);
        popup.add(character, BorderLayout.CENTER);
        popup.add(subText, BorderLayout.SOUTH);
        popup.add(closeBtn, BorderLayout.PAGE_END);   // 아래쪽 버튼

        closeBtn.addActionListener(e -> popup.dispose());

        popup.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BopgiProgram().setVisible(true));
    }
}