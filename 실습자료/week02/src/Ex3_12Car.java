
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
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 1주차 과제 예제 3-12");
	}
}