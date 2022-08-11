import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr9_03NumberGame extends JFrame {

	private int randomNum;
	private JTextField inputField;
	private JLabel guideLabel;
	private JButton retryButton;
	private JButton exitButton;
	
	public Pr9_03NumberGame() {
		super("숫자게임");
			 
		//top 패널에 들어갈 컴포넌트 구성
		JLabel infoLabel = new JLabel("숫자를 추측하시오 : ");
		inputField = new JTextField(10);
		
		//top 패널 구성
		JPanel topPanel = new JPanel();
		topPanel.add(infoLabel);
		topPanel.add(inputField);
		
		//middle 패널에 들어갈 레이블 구성
		guideLabel = new JLabel("숫자를 입력하시오.");
		guideLabel.setBackground(Color.WHITE);
		guideLabel.setOpaque(true);//레이블을 불투명하게
		
		//middle 패널 구성
		JPanel middlePanel = new JPanel();
		middlePanel.add(guideLabel);
		
		//low 패널에 들어갈 버튼 구성
		retryButton = new JButton("새 게임");
		exitButton = new JButton("종료");
		
		//low 패널 구성
		JPanel lowPanel = new JPanel();
		lowPanel.add(retryButton);
		lowPanel.add(exitButton);
		
		//메인 패널 구성
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(topPanel);
		mainPanel.add(middlePanel);
		mainPanel.add(lowPanel);
		add(mainPanel);
		
		inputField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(Integer.parseInt(inputField.getText()) < randomNum) {
						guideLabel.setText("너무 낮습니다!");
						guideLabel.setBackground(Color.RED);
					}
					else if(Integer.parseInt(inputField.getText()) > randomNum) {
						guideLabel.setText("너무 높습니다!");
						guideLabel.setBackground(Color.RED);
					}
					else {
						guideLabel.setText("정답입니다!");
						guideLabel.setBackground(Color.WHITE);
					}
				}
				catch(NumberFormatException ne){
					guideLabel.setText("잘못된 입력입니다!");
					guideLabel.setBackground(Color.RED);
				}
				inputField.selectAll();
			}
		});
		
		ButtonListener listener = new ButtonListener();
		retryButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		
		//랜덤 넘버와 프레임 설정
		setRandomNum();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	//접근자
	public int getRandomNum() { return randomNum; }
	//설정자
	public void setRandomNum() { randomNum = (int)(Math.random()*100)+1; }
	public static void main(String[] args) {
		new Pr9_03NumberGame();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 9주차 과제 3번");
	}
	
	//버튼에 들어갈 액션이벤트리스너
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == retryButton) {
				setRandomNum();
				guideLabel.setText("숫자를 입력하시오.");
				guideLabel.setBackground(Color.WHITE);
				inputField.setText("");
			}
			else if(e.getSource() == exitButton) {
				System.exit(0);
			}
		}
	}
}