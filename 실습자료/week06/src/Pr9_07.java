import javax.swing.*; // 이곳에 필요한 import문을 삽입하라.

public class Pr9_07 extends JFrame {
	public Pr9_07() {
		setTitle("hello"); // 프레임 타이틀로 "hello" 문자열 출력
		setSize(200, 300); // 프레임 크기를 200x300으로 설정
		setVisible(true); // 프레임 화면 출력
	}
	public static void main(String [] args) {
		Pr9_07 frame = new Pr9_07();
	}
}