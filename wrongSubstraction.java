import java.util.*;

public class wrongSubstraction {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), K = in.nextInt();
		for(int i = 0; i < K; i++) {
			if(N%10==0) N /= 10;
			else N--;
		}
		System.out.println(N);
		in.close();
	}

}
