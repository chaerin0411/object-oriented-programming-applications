import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Tr8_02NextLine {
	public static void main(String[] args) {
		
		try {
			Vector<String> wordVector = new Vector<String>();
			Scanner scanner = new Scanner(new FileReader("c:\\Temp\\phone.txt"));
			
			while (scanner.hasNext()) { // ������ ������ �ݺ��Ͽ� �б�
				String word = scanner.nextLine();
				// �� ���� ������ �б�
				// word�� '/n'�� ����
				wordVector.add(word); // �ܾ ���Ϳ� ����
				System.out.println((String)word);
			}
			System.out.println("");
		}
		
		catch (FileNotFoundException e) {
			System.out.println("������ ã�� ���߽��ϴ�.");
		}

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� �ǽ����� 8-2(2)");
	}
}