import java.util.*;
public class ChipsMoving {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) arr[i] = in.nextInt();
		in.close();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int count = 0;
			for(int j = 0; j < N; j++) {
				if((arr[i]-arr[j])%2 != 0) count++;
			}
			min = Math.min(count, min);
		}
		System.out.println(min);
	}

}
