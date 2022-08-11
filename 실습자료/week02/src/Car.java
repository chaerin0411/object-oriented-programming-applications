
import java.lang.Math;

public class Car {
	
	final static int MAXSPEED = 200;
	String color;
	int speed;
	static int carCount;
	
	Car(String color, int speed) {
		this.color = color;
		this.speed = speed;
		carCount++;
	}
	
	Car(int speed) {
		this.speed =speed;
	}
	
	int getSpeed() {
		return speed;
	}
	
	static int currentCarCount() {
		return carCount;
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
		System.out.println("��ü�������α׷��� ���� 1���� ���� ���� 3-13");
		
		Car myCar1 = new Car("����", 0);
		Car myCar2 = new Car("�Ķ�", 0);
		Car myCar3 = new Car("�ʷ�", 0);
		
		System.out.println("����� ���� ���(���� �ʵ�) ==> " + Car.carCount);
		System.out.println("����� ���� ���(���� �޼ҵ�) ==> " + Car.currentCarCount());
		System.out.println("���� �ְ� ���� �ӵ� ==> " + Car.MAXSPEED);
		
		System.out.println("PI�� �� ==> " + Math.PI);
		System.out.println("3�� 5���� ==> " + Math.pow(3, 5));
	}
}