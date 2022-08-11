import javax.swing.*;
public class Ex9_01MyFrame extends JFrame {
	public Ex9_01MyFrame() {
		setTitle("300x300 스윙 프레임 만들기");
		setSize(300,300); // 프레임 크기 300x300
		setVisible(true); // 프레임 출력
	}
	public static void main(String[] args) {
		Ex9_01MyFrame frame = new Ex9_01MyFrame();

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 5주차 과제 예제 9-1");
	}
}