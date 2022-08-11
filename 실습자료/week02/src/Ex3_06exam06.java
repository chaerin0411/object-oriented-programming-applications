
public class Ex3_06exam06 {
	
	static int var = 100;
	public static void main(String args[]) {
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 1주차 과제 예제 3-6");
		int num1 = 100, num2 = 0;
		
		try {
			System.out.println(num1/num2);
		}
		catch (java.lang.ArithmeticException e) {
			System.out.println("계산에 문제가 있습니다.");
		}
	}
}