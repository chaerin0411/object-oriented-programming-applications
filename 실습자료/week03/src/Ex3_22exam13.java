interface ClickListener {
	public void print();
}

/*
//Ŭ������ ���� ����
class NoNameClass implement ClickListener {
	@Override
	public void print() {
		System.out.println("Ŭ�� �������Դϴ�.");
	}
}
*/

//�͸� ���� Ŭ����
public class Ex3_22exam13 {
	public static void main(String[] args) {

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 3���� ���� ���� 3-22");
		
		/*
		//Ŭ������ ���� ����
		NoNameClass listener = new NoNameClass();
		*/
		
		//Ctrl + Space ������ �ڵ��ϼ���
		ClickListener listener = (new ClickListener() {
			@Override
			public void print() {
				System.out.println("Ŭ�� �������Դϴ�.");
			}
		});
		
		listener.print();
	}
}