
public class Ex3_12Car {
	String color;
	int speed;
	
	Ex3_12Car(String color, int speed) {
		this.color = color;
		this.speed = speed;
	}
	
	Ex3_12Car(int speed) {
		this.speed =speed;
	}
	
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
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 1���� ���� ���� 3-12");
	}
}