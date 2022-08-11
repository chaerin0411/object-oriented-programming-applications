
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
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 1주차 과제 예제 3-13");
		
		Car myCar1 = new Car("빨강", 0);
		Car myCar2 = new Car("파랑", 0);
		Car myCar3 = new Car("초록", 0);
		
		System.out.println("생산된 차의 대수(정적 필드) ==> " + Car.carCount);
		System.out.println("생산된 차의 대수(정적 메소드) ==> " + Car.currentCarCount());
		System.out.println("차의 최고 제한 속도 ==> " + Car.MAXSPEED);
		
		System.out.println("PI의 값 ==> " + Math.PI);
		System.out.println("3의 5제곱 ==> " + Math.pow(3, 5));
	}
}