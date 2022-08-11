import java.io.File;
public class Ex8_08FileEx {
	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath() + "�� ���� ����Ʈ �Դϴ�.-----");
		// getPath(): ������ �н��� ��ȯ
		File[] subFiles = dir.listFiles();
		// listFiles(): ���丮�� ��� ������ ��ȸ
		
		for(int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t���� ũ��: " + f.length());
			System.out.printf("\t������ �ð�: %tb %td %ta %tT\n", t, t, t, t);
		}
	}
	
	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		// getPath(): ������ �н��� ��ȯ
		// getParent(): ������ �θ� ��ȯ
		// getName(): ���� �̸��� ��ȯ
		// c:\windows\system.ini, c:\windows, system.ini
		
		String res = "";
		if(f1.isFile()) res = "����";
		else if(f1.isDirectory()) res = "���丮";
		System.out.println(f1.getPath() + "�� " + res + "�Դϴ�.");
		// c:\windows\system.ini�� �����Դϴ�.
		
		File f2 = new File("c:\\Temp\\java_sample"); 
		if(!f2.exists()) {
			f2.mkdir(); // �������� ������ ���丮 ����
		}
		
		listDirectory(new File("c:\\Temp")); 
		f2.renameTo(new File("c:\\Temp\\javasample")); // javasample�� �̸� ����
		listDirectory(new File("c:\\Temp"));

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� ���� 8-8");
	}
}
