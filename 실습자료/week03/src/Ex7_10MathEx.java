public class Ex7_10MathEx {
	public static void main(String[] args) {
		System.out.println(Math.PI); //������ ��� ���
		System.out.println(Math.sqrt(4)); //������
		System.out.println(Math.round(3.14)); //�ݿø�
		System.out.println(Math.floor(6.8)); //����
		System.out.println(Math.ceil(6.2)); //�ø�
		System.out.println(Math.abs(-20)); //����

		// [1, 45] ������ ������ ���� 5�� �߻�
		System.out.print("�̹��� ����� ��ȣ�� ");
		for (int i = 0; i < 5; i++)
			System.out.print((int)(Math.random()*45 + 1) + " ");
		
		System.out.println("");
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 3���� ���� ���� 7-10");
		
	}
}