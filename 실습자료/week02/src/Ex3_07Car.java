
public class Ex3_07Car {
	String color;
	int speed = 0;
	
	int getSpeed() {
		return speed;
	}
	
	void upSpeed(int value) {
		if (speed + value >= 200)
			speed = 200;
		else
			speed = speed + value;
	}
	
	void downSpeed(int value) {
		if (speed - value <= 0)
			speed = 0;
		else
			speed = speed - value;
	}
	
	String getColor() {
		return color;
	}
	
	public static void main(String args[]) {
		Ex3_07Car myCar1 = new Ex3_07Car();
		myCar1.color = "����";
		myCar1.speed = 0;
		
		myCar1.upSpeed(50);
		System.out.println("�ڵ���1�� ������ " + myCar1.getColor() + 
				"�̸�, �ӵ��� " + myCar1.getSpeed() + "km�Դϴ�.");
		
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 1���� ���� ���� 3-7");
	}
}