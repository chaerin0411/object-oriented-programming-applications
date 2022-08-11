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
		super("���ڰ���");
			 
		//top �гο� �� ������Ʈ ����
		JLabel infoLabel = new JLabel("���ڸ� �����Ͻÿ� : ");
		inputField = new JTextField(10);
		
		//top �г� ����
		JPanel topPanel = new JPanel();
		topPanel.add(infoLabel);
		topPanel.add(inputField);
		
		//middle �гο� �� ���̺� ����
		guideLabel = new JLabel("���ڸ� �Է��Ͻÿ�.");
		guideLabel.setBackground(Color.WHITE);
		guideLabel.setOpaque(true);//���̺��� �������ϰ�
		
		//middle �г� ����
		JPanel middlePanel = new JPanel();
		middlePanel.add(guideLabel);
		
		//low �гο� �� ��ư ����
		retryButton = new JButton("�� ����");
		exitButton = new JButton("����");
		
		//low �г� ����
		JPanel lowPanel = new JPanel();
		lowPanel.add(retryButton);
		lowPanel.add(exitButton);
		
		//���� �г� ����
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
						guideLabel.setText("�ʹ� �����ϴ�!");
						guideLabel.setBackground(Color.RED);
					}
					else if(Integer.parseInt(inputField.getText()) > randomNum) {
						guideLabel.setText("�ʹ� �����ϴ�!");
						guideLabel.setBackground(Color.RED);
					}
					else {
						guideLabel.setText("�����Դϴ�!");
						guideLabel.setBackground(Color.WHITE);
					}
				}
				catch(NumberFormatException ne){
					guideLabel.setText("�߸��� �Է��Դϴ�!");
					guideLabel.setBackground(Color.RED);
				}
				inputField.selectAll();
			}
		});
		
		ButtonListener listener = new ButtonListener();
		retryButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		
		//���� �ѹ��� ������ ����
		setRandomNum();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	//������
	public int getRandomNum() { return randomNum; }
	//������
	public void setRandomNum() { randomNum = (int)(Math.random()*100)+1; }
	public static void main(String[] args) {
		new Pr9_03NumberGame();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 3��");
	}
	
	//��ư�� �� �׼��̺�Ʈ������
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == retryButton) {
				setRandomNum();
				guideLabel.setText("���ڸ� �Է��Ͻÿ�.");
				guideLabel.setBackground(Color.WHITE);
				inputField.setText("");
			}
			else if(e.getSource() == exitButton) {
				System.exit(0);
			}
		}
	}
}