
import java.util.Calendar;
public class Ex7_11CalendarEx {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR);
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		int ampm = cal.get(Calendar.AM_PM);
		int minute = cal.get(Calendar.MINUTE);

		System.out.print("����" + year + "/" + month + "/" + day + "/");
		System.out.print("(" + hourOfDay + "��)");
		System.out.println(minute + "��");
		
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 3���� ���� ���� 7-11");
		
	}

}