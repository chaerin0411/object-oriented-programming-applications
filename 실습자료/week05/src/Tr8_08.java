import java.io.File;
public class Tr8_08 {
	public static void listDirectory(File dir) {
		File[] subFiles = dir.listFiles();
		// listFiles(): ���丮�� ��� ������ ��ȸ
		
		File max = new File("c:\\temp\\null.txt");
		for(int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			if (max.length() <= f.length()) max = f;
		}
		System.out.print("���� ū ������ " + max.getPath() + " " + max.length() + "����Ʈ");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		File c = new File("c:\\");
		listDirectory(c); 
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� �ǽ����� 8-8");
	}
}