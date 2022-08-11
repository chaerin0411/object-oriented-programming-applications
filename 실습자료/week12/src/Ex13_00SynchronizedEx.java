public class Ex13_00SynchronizedEx {
	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		Thread th1 = new StudentThread("kitae", board);
		Thread th2 = new StudentThread("hyosoo", board);
		th1.start();
		th2.start();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 12주차 예제");
	}
}

class SharedBoard { //named board
	private int sum = 0; //집계판의 합
	synchronized public void add() {
		int n = sum;
		Thread.yield(); //현재 실행 중인 스레드 양보
		n += 10; //10 증가
		sum = n; //증가한 값을 집계합에 기록
		System.out.println(Thread.currentThread().getName()+" : "+sum);
	}
	public int getSum() { return sum; }
}

class StudentThread extends Thread { //named th
	private SharedBoard board; //집계판의 주소, SharedBoard의 board 불러옴
	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++)
			board.add(); //add함수 호출
	}
}
