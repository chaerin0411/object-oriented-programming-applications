import java.io.File;
public class Ex8_08FileEx {
	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath() + "의 서브 리스트 입니다.-----");
		// getPath(): 파일의 패스를 반환
		File[] subFiles = dir.listFiles();
		// listFiles(): 디렉토리의 모든 파일을 조회
		
		for(int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일 크기: " + f.length());
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n", t, t, t, t);
		}
	}
	
	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		// getPath(): 파일의 패스를 반환
		// getParent(): 파일의 부모를 반환
		// getName(): 파일 이름을 반환
		// c:\windows\system.ini, c:\windows, system.ini
		
		String res = "";
		if(f1.isFile()) res = "파일";
		else if(f1.isDirectory()) res = "디렉토리";
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		// c:\windows\system.ini은 파일입니다.
		
		File f2 = new File("c:\\Temp\\java_sample"); 
		if(!f2.exists()) {
			f2.mkdir(); // 존재하지 않으면 디렉토리 생성
		}
		
		listDirectory(new File("c:\\Temp")); 
		f2.renameTo(new File("c:\\Temp\\javasample")); // javasample로 이름 변경
		listDirectory(new File("c:\\Temp"));

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 5주차 과제 예제 8-8");
	}
}
