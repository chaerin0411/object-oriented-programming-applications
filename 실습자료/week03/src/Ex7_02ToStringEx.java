
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

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 3���� ���� ���� 7-2");
	
		Person p1 = new Person("������", "����");
		System.out.println(p1.toString());
		System.out.println(p1); //p1�� p.toString()���� �ڵ� ��ȯ
		System.out.println(p1 + "�Դϴ�"); //p1.toString() + "�Դϴ�"�� �ڵ� ��ȯ

		Person p2 = new Person("������", "��⵵");
		System.out.println(p2.toString());
		System.out.println(p2); //p2�� p.toString()���� �ڵ� ��ȯ
		System.out.println(p2 + "�Դϴ�"); //p2.toString() + "�Դϴ�"�� �ڵ� ��ȯ
		
	}
}