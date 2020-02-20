import java.util.*;
public class Res3Nums {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[] = new int[4];
		int max = 0;
		for(int i = 0; i < 4; i++) {
			arr[i] = in.nextInt();
			max = Math.max(max, arr[i]);
		}
		in.close();
		Arrays.sort(arr);
		for(int i = 0; i < 3; i++) {
			System.out.print(max-arr[i] + " ");
		}
	}

}
