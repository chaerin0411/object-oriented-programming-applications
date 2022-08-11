
import java.io.FileReader;
import java.io.FileWriter;
public class CopyFile {

	public static void main(String[] args) {
		String input = "d:\\dream.txt";
		String output = "d:\\dreamCopy.txt";
		
		try {
			FileReader fin = new FileReader(input);
			FileWriter fout = new FileWriter(output);
			int ch;
			
			while( (ch = fin.read()) != -1 ) {
				fout.write(ch);
				System.out.print((char)ch);
			}
			
			fin.close();
			fout.close();
		}
		
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 4주차 과제 예제 *-*");
	}

}