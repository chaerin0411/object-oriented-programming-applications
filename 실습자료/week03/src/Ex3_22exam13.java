interface ClickListener {
	public void print();
}

/*
//클래스를 직접 만듦
class NoNameClass implement ClickListener {
	@Override
	public void print() {
		System.out.println("클릭 리스너입니다.");
	}
}
*/

//익명 내부 클래스
public class Ex3_22exam13 {
	public static void main(String[] args) {

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 3주차 과제 예제 3-22");
		
		/*
		//클래스를 직접 만듦
		NoNameClass listener = new NoNameClass();
		*/
		
		//Ctrl + Space 누르면 자동완성됨
		ClickListener listener = (new ClickListener() {
			@Override
			public void print() {
				System.out.println("클릭 리스너입니다.");
			}
		});
		
		listener.print();
	}
}