
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class CopyFileByte {

	public static void main(String[] args) {
		String input = "d:\\bts.mp4";
		String output = "d:\\btsCopy.mp4";
		
		try {
			FileInputStream fin = new FileInputStream(input);
			FileOutputStream fout = new FileOutputStream(output);
			int ch;
			
			while( (ch = fin.read()) != -1 ) {
				fout.write(ch);
			}
			System.out.println("작업이 완료되었습니다.");
			
			fin.close();
			fout.close();
		}
		
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 4주차 과제 파일복사예제");
		System.out.println("FileInputStream과 FileOutputStream");
	}

}