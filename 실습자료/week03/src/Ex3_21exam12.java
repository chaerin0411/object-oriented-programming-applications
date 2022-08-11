interface iAnimal {
	abstract void eat();
}

public class Ex3_21exam12 {
	
	public static void main(String args[]) {

		iCat cat = new iCat();
		cat.eat();

		iTiger tiger = new iTiger();
		tiger.move();
		tiger.eat();

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 3주차 과제 예제 3-21");
	
	}

	static class iCat implements iAnimal {
		public void eat() {
			System.out.println("생선을 좋아한다.");
		}
	}

	static class iTiger extends Ex3_16Animal implements iAnimal {
		void move() {
			System.out.println("네발로 이동한다.");
		}

		public void eat() {
			System.out.println("멧돼지를 잡아먹는다.");
		}
	}
}