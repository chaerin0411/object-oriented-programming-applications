import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Tr8_02NextLine {
	public static void main(String[] args) {
		
		try {
			Vector<String> wordVector = new Vector<String>();
			Scanner scanner = new Scanner(new FileReader("c:\\Temp\\phone.txt"));
			
			while (scanner.hasNext()) { // 파일의 끝까지 반복하여 읽기
				String word = scanner.nextLine();
				// 한 라인 단위로 읽기
				// word에 '/n'은 없음
				wordVector.add(word); // 단어를 벡터에 저장
				System.out.println((String)word);
			}
			System.out.println("");
		}
		
		catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		}

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 5주차 과제 실습문제 8-2(2)");
	}
}