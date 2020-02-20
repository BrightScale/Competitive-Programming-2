import java.util.*;

public class PileStone {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String s = in.next();
		in.close();
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(!(s.charAt(i) == '-' && count == 0)) {
				if(s.charAt(i) == '+') {
					count++;
				}else count--;
			}
		}
		System.out.println(count);
	}
	
}
