
public class Ex7_05WrapperEx {
	public static void main(String[] args) {
		System.out.println(Character.toLowerCase('A')); //'A'를 소문자로 변환
		String x = "-123";
		String y = "10";
		System.out.println("x + y = ?");
		System.out.println(Integer.parseInt(x) + Integer.parseInt(y));

		Double d = Double.valueOf(3.14);

		System.out.println(d.toString()); //Double을 문자열 "3.14"로 변환
		System.out.println(Double.parseDouble("3.14")); //문자열을 실수 3.14로 변환

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 3주차 과제 예제 7-5");
		
	}
}