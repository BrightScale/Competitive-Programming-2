import java.util.*;
public class numberCircle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		Arrays.sort(arr);
		if (arr[N - 1] < arr[N - 2] + arr[N - 3]) {
            System.out.println("YES");
            for (int i = 0; i < N - 2; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[N - 1] + " " + arr[N - 2]);
        } else {
            System.out.println("NO");
        }
	}

}
