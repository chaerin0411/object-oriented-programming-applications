
import java.io.*;
public class Ex8_01FileReaderEx {

	public static void main(String[] args) {
		FileReader fin = null;
		
		try {
			fin = new FileReader("c:\\windows\\system.ini");
			int c;
			while ((c = fin.read()) != -1) { // �� ���ھ� ���� ������ �б�
				System.out.print((char)c);
			}
			fin.close();
		}
		catch (IOException e) {
			System.out.println("����� ����");
		}
		
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 4���� ���� ���� 8-1");
	}

}