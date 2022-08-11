
import java.io.*;
public class Ex8_01FileReaderEx {

	public static void main(String[] args) {
		FileReader fin = null;
		
		try {
			fin = new FileReader("c:\\windows\\system.ini");
			int c;
			while ((c = fin.read()) != -1) { // 한 문자씩 파일 끝까지 읽기
				System.out.print((char)c);
			}
			fin.close();
		}
		catch (IOException e) {
			System.out.println("입출력 오류");
		}
		
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 4주차 과제 예제 8-1");
	}

}