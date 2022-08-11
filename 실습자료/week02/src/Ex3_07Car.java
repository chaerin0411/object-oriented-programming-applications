
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
		myCar1.color = "빨강";
		myCar1.speed = 0;
		
		myCar1.upSpeed(50);
		System.out.println("자동차1의 색상은 " + myCar1.getColor() + 
				"이며, 속도는 " + myCar1.getSpeed() + "km입니다.");
		
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 1주차 과제 예제 3-7");
	}
}