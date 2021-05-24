package UI;

import java.io.IOException;
import java.sql.Date;

public class mainTest {
	public static void main(String[] args) throws IOException {
		Date today = new Date(System.currentTimeMillis());
		Date myDate = new Date(today.getYear(), today.getMonth() + 5, today.getDay() + 1);
		System.out.println("My Date is " + myDate);
		System.out.println("Today Date is " + today);
		System.out.println("Long My Date is " + myDate.getTime());
		System.out.println("Long Today Date is " + today.getTime());

	}

}
