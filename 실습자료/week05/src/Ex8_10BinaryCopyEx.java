import java.io.*;
public class Ex8_10BinaryCopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\Temp\\flower.jpg");
		File dest = new File("c:\\Temp\\flowercopy.jpg");
		int c;
		try {
			FileInputStream fi = new FileInputStream(src); // ����Ʈ ��Ʈ��
			FileOutputStream fo = new FileOutputStream(dest); // ����Ʈ ��Ʈ�� 
			while((c = fi.read()) != -1) {
				fo.write((byte)c);
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath()+ "�� " + dest.getPath()+ "�� �����Ͽ����ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ���� ����");
		}

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� ���� 8-10");
	}
}