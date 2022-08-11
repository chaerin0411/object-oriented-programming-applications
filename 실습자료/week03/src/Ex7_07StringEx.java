
public class Ex7_07StringEx {
	public static void main(String[] args) {
		String a = new String(" C#");
		String b = new String(", C++");

		System.out.println(a + "의 길이는 " + a.length()); //문자열의 길이(문자 개수)

		a = a.trim(); //문자열 앞 뒤의 공백 제거
		a = a.concat(b); //스트링 a에 b를 덧붙여 만든 새로운 스트링
		System.out.println(a);

		String s[] = a.split(","); //문자열 분리
		for (int i = 0; i < s.length; i++)
			System.out.println("분리된 문자열" + i + ": " + s[i]);
		
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 3주차 과제 예제 7-7");
	
	}
}