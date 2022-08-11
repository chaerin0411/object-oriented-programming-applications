
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
public class BufferedStreamEx {

	public static void main(String[] args) {
		long start, end, duration;
		String input = "d:\\bts.mp4";
		String output = "d:\\btsCopy.mp4";
		
		// --버퍼 사용
		start = System.nanoTime();
		try {
			FileInputStream  fin  = new FileInputStream(input);
			FileOutputStream fout = new FileOutputStream(output);
			BufferedInputStream  bin  = new BufferedInputStream(fin);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			int ch;
			
			while( (ch = bin.read()) != -1 ) {
				bout.write(ch);
			}
			System.out.println("버퍼 작업이 완료되었습니다.");
			
			bin.close();
			bout.close();
		}
		
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
		
		end = System.nanoTime();
		duration = end - start;
		System.out.println("버퍼를 사용한 경우 " + duration);
		
		// --파일 사용
		start = System.nanoTime();
		try {
			FileInputStream  fin  = new FileInputStream(input);
			FileOutputStream fout = new FileOutputStream(output);
			int ch;
			
			while( (ch = fin.read()) != -1 ) {
				fout.write(ch);
			}
			System.out.println("파일 작업이 완료되었습니다.");
			
			fin.close();
			fout.close();
		}
		
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
		
		end = System.nanoTime();
		duration = end - start;
		System.out.println("파일을 사용한 경우 " + duration);
		
		System.out.println();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 4주차 과제 버퍼사용예제");
		System.out.println("버퍼 스트림을 이용한 출력");
	}

}