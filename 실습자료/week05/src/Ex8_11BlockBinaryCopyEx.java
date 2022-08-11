import java.io.*;
public class Ex8_11BlockBinaryCopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\Temp\\flower.jpg");
		File dest = new File("c:\\Temp\\flowercopy.jpg"); 
		try
		{
			FileInputStream fi = new FileInputStream(src); // 바이트 스트림
			FileOutputStream fo = new FileOutputStream(dest); // 바이트 스트림
			byte [] buf = new byte [1024*10]; // 10KB 버퍼
			while(true)
			{
				int n = fi.read(buf); // 버퍼 크기만큼 읽기. n은 실제 읽은 바이트
				fo.write(buf, 0, n); // buf[0]부터 n 바이트 쓰기
				if(n <buf.length)
					break;
			}
			fi.close();
			fo.close();
			System.out.println( src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
		}
		catch (IOException e)
		{
			System.out.println("파일 복사 오류");
		}

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 5주차 과제 예제 8-11");
	}
}