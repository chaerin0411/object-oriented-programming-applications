
public class Ex3_04exam04 {
	
	public static void main(String args[]) {
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 1주차 과제 예제 3-4");
		int one[] = new int[3];
		for (int i = 0; i < one.length; i++) {
			one[i] = 10 * i;
		}
		
		String two[] = { "하나", "둘", "셋" };
		for (String str : two) {
			System.out.println(str);
		}
		
		int j = 0;
		while(j < one.length) {
			System.out.println(one[j]);
			j++;
		}
	}
}