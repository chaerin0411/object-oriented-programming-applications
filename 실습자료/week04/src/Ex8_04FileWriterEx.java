
import java.io.*;
import java.util.*;
public class Ex8_04FileWriterEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileWriter fout = null;
		
		try {
			fout = new FileWriter("c:\\Temp\\test.txt");
			while(true) { // �� ���ھ� ���� ������ �б�
				String line = scanner.nextLine();
				if(line.length() == 0)
					break;
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		}
		catch (IOException e) {
			System.out.println("����� ����");
		}
		
		scanner.close();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 4���� ���� ���� 8-4");
	}

}