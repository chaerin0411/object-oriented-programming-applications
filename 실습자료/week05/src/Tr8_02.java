import java.io.*;
public class Tr8_02 {
	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		
		try {
			fin = new FileReader("c:\\temp\\phone.txt");
			while ((c = fin.read()) != -1) { // �� ���ھ� �б�
				System.out.print((char)c);
			}
			System.out.println("");
			System.out.println("");
			fin.close();
		}
		catch (IOException e) {
			System.out.println("����� ����");
		}

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� �ǽ����� 8-2");
	}
}