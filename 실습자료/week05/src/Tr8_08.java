import java.io.File;
public class Tr8_08 {
	public static void listDirectory(File dir) {
		File[] subFiles = dir.listFiles();
		// listFiles(): 디렉토리의 모든 파일을 조회
		
		File max = new File("c:\\temp\\null.txt");
		for(int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			if (max.length() <= f.length()) max = f;
		}
		System.out.print("가장 큰 파일은 " + max.getPath() + " " + max.length() + "바이트");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		File c = new File("c:\\");
		listDirectory(c); 
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 5주차 과제 실습문제 8-8");
	}
}