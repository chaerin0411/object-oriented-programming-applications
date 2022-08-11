import java.io.*;
public class Ex8_11BlockBinaryCopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\Temp\\flower.jpg");
		File dest = new File("c:\\Temp\\flowercopy.jpg"); 
		try
		{
			FileInputStream fi = new FileInputStream(src); // ����Ʈ ��Ʈ��
			FileOutputStream fo = new FileOutputStream(dest); // ����Ʈ ��Ʈ��
			byte [] buf = new byte [1024*10]; // 10KB ����
			while(true)
			{
				int n = fi.read(buf); // ���� ũ�⸸ŭ �б�. n�� ���� ���� ����Ʈ
				fo.write(buf, 0, n); // buf[0]���� n ����Ʈ ����
				if(n <buf.length)
					break;
			}
			fi.close();
			fo.close();
			System.out.println( src.getPath() + "�� " + dest.getPath() + "�� �����Ͽ����ϴ�.");
		}
		catch (IOException e)
		{
			System.out.println("���� ���� ����");
		}

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� ���� 8-11");
	}
}