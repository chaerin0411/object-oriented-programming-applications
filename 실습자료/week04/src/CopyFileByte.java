
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class CopyFileByte {

	public static void main(String[] args) {
		String input = "d:\\bts.mp4";
		String output = "d:\\btsCopy.mp4";
		
		try {
			FileInputStream fin = new FileInputStream(input);
			FileOutputStream fout = new FileOutputStream(output);
			int ch;
			
			while( (ch = fin.read()) != -1 ) {
				fout.write(ch);
			}
			System.out.println("�۾��� �Ϸ�Ǿ����ϴ�.");
			
			fin.close();
			fout.close();
		}
		
		catch (Exception e) {
			System.out.println("���ܹ߻�");
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 4���� ���� ���Ϻ��翹��");
		System.out.println("FileInputStream�� FileOutputStream");
	}

}