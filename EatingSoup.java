import java.util.*;

public class EatingSoup {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), M = in.nextInt();
		in.close();
		System.out.println(Math.min(Math.max(1,M),N-M));
	}
}
