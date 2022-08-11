
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
public class BufferedStreamEx {

	public static void main(String[] args) {
		long start, end, duration;
		String input = "d:\\bts.mp4";
		String output = "d:\\btsCopy.mp4";
		
		// --���� ���
		start = System.nanoTime();
		try {
			FileInputStream  fin  = new FileInputStream(input);
			FileOutputStream fout = new FileOutputStream(output);
			BufferedInputStream  bin  = new BufferedInputStream(fin);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			int ch;
			
			while( (ch = bin.read()) != -1 ) {
				bout.write(ch);
			}
			System.out.println("���� �۾��� �Ϸ�Ǿ����ϴ�.");
			
			bin.close();
			bout.close();
		}
		
		catch (Exception e) {
			System.out.println("���ܹ߻�");
			e.printStackTrace();
		}
		
		end = System.nanoTime();
		duration = end - start;
		System.out.println("���۸� ����� ��� " + duration);
		
		// --���� ���
		start = System.nanoTime();
		try {
			FileInputStream  fin  = new FileInputStream(input);
			FileOutputStream fout = new FileOutputStream(output);
			int ch;
			
			while( (ch = fin.read()) != -1 ) {
				fout.write(ch);
			}
			System.out.println("���� �۾��� �Ϸ�Ǿ����ϴ�.");
			
			fin.close();
			fout.close();
		}
		
		catch (Exception e) {
			System.out.println("���ܹ߻�");
			e.printStackTrace();
		}
		
		end = System.nanoTime();
		duration = end - start;
		System.out.println("������ ����� ��� " + duration);
		
		System.out.println();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 4���� ���� ���ۻ�뿹��");
		System.out.println("���� ��Ʈ���� �̿��� ���");
	}

}