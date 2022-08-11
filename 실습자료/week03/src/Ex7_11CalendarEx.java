
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

		System.out.print("현재" + year + "/" + month + "/" + day + "/");
		System.out.print("(" + hourOfDay + "시)");
		System.out.println(minute + "분");
		
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 3주차 과제 예제 7-11");
		
	}

}