import java.io.*;
public class Ex8_09TextCopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\windows\\system.ini"); // ���� ���� ��θ�
		File dest = new File("c:\\Temp\\system.txt"); // ���� ���� ��θ�
		int c;
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest); 
			while((c = fr.read()) != -1) { // ���� �ϳ� �а�
				fw.write((char)c); // ���� �ϳ� ����
			}
			fr.close(); fw.close();
			System.out.println(src.getPath()+ "�� " + dest.getPath()+ "�� �����Ͽ����ϴ�.");
		}
		catch (IOException e) {
			System.out.println("���� ���� ����");
		}

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� ���� 8-9");
	}
}