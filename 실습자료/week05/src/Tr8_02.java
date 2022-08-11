import java.io.*;
public class Tr8_02 {
	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		
		try {
			fin = new FileReader("c:\\temp\\phone.txt");
			while ((c = fin.read()) != -1) { // 한 문자씩 읽기
				System.out.print((char)c);
			}
			System.out.println("");
			System.out.println("");
			fin.close();
		}
		catch (IOException e) {
			System.out.println("입출력 오류");
		}

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 5주차 과제 실습문제 8-2");
	}
}