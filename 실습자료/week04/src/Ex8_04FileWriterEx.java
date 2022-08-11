
import java.io.*;
import java.util.*;
public class Ex8_04FileWriterEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileWriter fout = null;
		
		try {
			fout = new FileWriter("c:\\Temp\\test.txt");
			while(true) { // 한 문자씩 파일 끝까지 읽기
				String line = scanner.nextLine();
				if(line.length() == 0)
					break;
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		}
		catch (IOException e) {
			System.out.println("입출력 오류");
		}
		
		scanner.close();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 4주차 과제 예제 8-4");
	}

}