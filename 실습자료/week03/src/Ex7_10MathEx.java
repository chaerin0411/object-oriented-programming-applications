public class Ex7_10MathEx {
	public static void main(String[] args) {
		System.out.println(Math.PI); //원주율 상수 출력
		System.out.println(Math.sqrt(4)); //제곱근
		System.out.println(Math.round(3.14)); //반올림
		System.out.println(Math.floor(6.8)); //버림
		System.out.println(Math.ceil(6.2)); //올림
		System.out.println(Math.abs(-20)); //절댓값

		// [1, 45] 사이의 정수형 난수 5개 발생
		System.out.print("이번주 행운의 번호는 ");
		for (int i = 0; i < 5; i++)
			System.out.print((int)(Math.random()*45 + 1) + " ");
		
		System.out.println("");
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 3주차 과제 예제 7-10");
		
	}
}