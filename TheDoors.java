import java.util.*;
public class TheDoors {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int count1 = 0;
		int count2 = 0;
		for(int i = 0; i < N; i++) {
			int input = in.nextInt();
			if(input == 1) {
				count1 = 1 + Math.max(count1, count2);
			}else {
				count2 = 1 + Math.max(count1, count2);
			}
		}
		in.close();
		System.out.println(Math.min(count1, count2));
	}
}
