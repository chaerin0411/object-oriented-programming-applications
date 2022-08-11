import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr9_04Translator extends JFrame {
	JButton converter;
	JButton canceler;
	JTextArea textIn;
	JTextArea textOut;
	
	public Pr9_04Translator() {
		super("�ؽ�Ʈ ��ȯ");
		
		//Text Area
		textIn = new JTextArea(10,14);
		textOut = new JTextArea(10,14);
		textIn.setLineWrap(true); //�ڵ��ٹٲ�
		textOut.setLineWrap(true);
		textOut.setEnabled(false); //���� ��Ȱ��ȭ
		
		//Text Area ���� �г�
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		//Button
		converter = new JButton("��ȯ");
		canceler = new JButton("���");

		//Button ActionEvent
		converter.addActionListener(new ButtonActionListener());
		canceler.addActionListener(new ButtonActionListener());
		
		//Button Panel
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(converter);
		buttonPanel.add(canceler);
		
		//Main Panel
		JPanel mainPanel = new JPanel(new BorderLayout(10,10));
		mainPanel.add(BorderLayout.CENTER, textAreaPanel);
		mainPanel.add(BorderLayout.SOUTH, buttonPanel);
		
		//Frame Settings
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(mainPanel);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Pr9_04Translator();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 4��");
	}

	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == converter) {
				textOut.setText("");
				String result = toEnglish(textIn.getText());
				textOut.append(result);
			}
			if(e.getSource() == canceler) {
				textOut.setText("");
			}
		}
		private String toEnglish(String korean) {
			String result = korean;
			result = result.replace("�ؽ�Ʈ", "Text");
			result = result.replace("����", "English");
			return result;
		}
	}
}