
public class Ex7_07StringEx {
	public static void main(String[] args) {
		String a = new String(" C#");
		String b = new String(", C++");

		System.out.println(a + "�� ���̴� " + a.length()); //���ڿ��� ����(���� ����)

		a = a.trim(); //���ڿ� �� ���� ���� ����
		a = a.concat(b); //��Ʈ�� a�� b�� ���ٿ� ���� ���ο� ��Ʈ��
		System.out.println(a);

		String s[] = a.split(","); //���ڿ� �и�
		for (int i = 0; i < s.length; i++)
			System.out.println("�и��� ���ڿ�" + i + ": " + s[i]);
		
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 3���� ���� ���� 7-7");
	
	}
}