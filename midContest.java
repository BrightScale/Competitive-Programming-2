import java.util.*;
public class midContest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String time1 = in.next();
		String time2 = in.next();
		int minutes1 =
				Integer.parseInt(time1.substring(0,2))*60 + Integer.parseInt(time1.substring(3,5));
		int minutes2 = 
				Integer.parseInt(time2.substring(0,2))*60 + Integer.parseInt(time2.substring(3,5));
		int answer = (minutes2+minutes1)/2;
		if(answer/60 < 10) {
			System.out.print(0);
		}
		System.out.print(answer/60 + ":");
		if(answer - (answer/60)*60 < 10) {
			System.out.print(0);
		}
		System.out.println(answer - (answer/60)*60);
		in.close();
	}

}
