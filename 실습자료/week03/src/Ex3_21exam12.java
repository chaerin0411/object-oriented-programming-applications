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

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 3���� ���� ���� 3-21");
	
	}

	static class iCat implements iAnimal {
		public void eat() {
			System.out.println("������ �����Ѵ�.");
		}
	}

	static class iTiger extends Ex3_16Animal implements iAnimal {
		void move() {
			System.out.println("�׹߷� �̵��Ѵ�.");
		}

		public void eat() {
			System.out.println("������� ��ƸԴ´�.");
		}
	}
}