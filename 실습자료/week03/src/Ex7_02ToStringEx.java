
class Person {
	String name, addr;
	public Person(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Person (" + name + ", " + addr + ")";
	}
}

public class Ex7_02ToStringEx extends Person {
	public Ex7_02ToStringEx(String name, String addr) {
		super(name, addr);
	}
	
	public static void main(String[] args) {

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 3주차 과제 예제 7-2");
	
		Person p1 = new Person("아이유", "서울");
		System.out.println(p1.toString());
		System.out.println(p1); //p1은 p.toString()으로 자동 변환
		System.out.println(p1 + "입니다"); //p1.toString() + "입니다"로 자동 변환

		Person p2 = new Person("엄지희", "경기도");
		System.out.println(p2.toString());
		System.out.println(p2); //p2는 p.toString()으로 자동 변환
		System.out.println(p2 + "입니다"); //p2.toString() + "입니다"로 자동 변환
		
	}
}