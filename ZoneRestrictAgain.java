import java.util.*;

public class ZoneRestrictAgain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), H = in.nextInt(), M = in.nextInt();
		int a[] = new int[N];
		for(int i = 0; i< N; i++) {
			a[i] = H;
		}
		for(int i = 0; i < M; i++) {
			int l = in.nextInt(), r = in.nextInt(), x = in.nextInt();
			for(int j = l-1; j < r; j++) {
				a[j] = Math.min(a[j], x);
			}
		}
		in.close();
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Math.pow(a[i],2);
		}
		System.out.println(sum);
	}

}
