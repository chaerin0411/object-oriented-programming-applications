
public class Ex7_05WrapperEx {
	public static void main(String[] args) {
		System.out.println(Character.toLowerCase('A')); //'A'�� �ҹ��ڷ� ��ȯ
		String x = "-123";
		String y = "10";
		System.out.println("x + y = ?");
		System.out.println(Integer.parseInt(x) + Integer.parseInt(y));

		Double d = Double.valueOf(3.14);

		System.out.println(d.toString()); //Double�� ���ڿ� "3.14"�� ��ȯ
		System.out.println(Double.parseDouble("3.14")); //���ڿ��� �Ǽ� 3.14�� ��ȯ

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 3���� ���� ���� 7-5");
		
	}
}