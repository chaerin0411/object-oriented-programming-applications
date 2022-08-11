import java.io.*;

public class Tr8_02Buffered {
	public static void main(String[] args){
		try {
			File file = new File("C:\\Temp\\phone.txt"); // 파일 객체 생성
			FileReader filereader = new FileReader(file); // 입력 스트림 생성
			BufferedReader br = new BufferedReader(filereader); // 입력 버퍼 생성
			
			String line = "";
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			//.readLine()은 끝에 개행문자를 읽지 않는다.
			
			System.out.println("");
			br.close();
		}
		catch (FileNotFoundException e) {
	    	System.out.println("파일을 찾지 못했습니다.");
		}
		catch (IOException e) {
			System.out.println("입출력 오류");
		}

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 5주차 과제 실습문제 8-2(3)");
	}
}