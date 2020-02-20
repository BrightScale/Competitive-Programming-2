import java.util.*;

public class searchEasyProblem {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		boolean hard = false;
		for(int i = 0; i < N; i++) {
			if(in.nextInt() == 1) hard = true;
		}
		if(hard)System.out.println("HARD");
		else System.out.println("EASY");
		in.close();
	}

}
