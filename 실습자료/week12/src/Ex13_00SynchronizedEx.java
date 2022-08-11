public class Ex13_00SynchronizedEx {
	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		Thread th1 = new StudentThread("kitae", board);
		Thread th2 = new StudentThread("hyosoo", board);
		th1.start();
		th2.start();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 12���� ����");
	}
}

class SharedBoard { //named board
	private int sum = 0; //�������� ��
	synchronized public void add() {
		int n = sum;
		Thread.yield(); //���� ���� ���� ������ �纸
		n += 10; //10 ����
		sum = n; //������ ���� �����տ� ���
		System.out.println(Thread.currentThread().getName()+" : "+sum);
	}
	public int getSum() { return sum; }
}

class StudentThread extends Thread { //named th
	private SharedBoard board; //�������� �ּ�, SharedBoard�� board �ҷ���
	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++)
			board.add(); //add�Լ� ȣ��
	}
}
