import java.util.*;

public class seabattle {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int w1 = in.nextInt(), h1 = in.nextInt(), w2 = in.nextInt(), h2 = in.nextInt();
		System.out.println((w1 + 2) + (w2 + 2) + (h1+h2) + (h1+h2) + Math.abs(w1-w2));
		in.close();
	}
}