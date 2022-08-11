import java.io.*;

public class Tr8_02Buffered {
	public static void main(String[] args){
		try {
			File file = new File("C:\\Temp\\phone.txt"); // ���� ��ü ����
			FileReader filereader = new FileReader(file); // �Է� ��Ʈ�� ����
			BufferedReader br = new BufferedReader(filereader); // �Է� ���� ����
			
			String line = "";
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			//.readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.
			
			System.out.println("");
			br.close();
		}
		catch (FileNotFoundException e) {
	    	System.out.println("������ ã�� ���߽��ϴ�.");
		}
		catch (IOException e) {
			System.out.println("����� ����");
		}

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� �ǽ����� 8-2(3)");
	}
}