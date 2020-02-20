import java.util.*;
public class KeanuReeves {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		char arr[] = new char[N];
		arr = in.next().toCharArray();
		int num = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] == '0') num++;
		}
		in.close();
		if(num == N - num) {
			System.out.println(2);
			for(int i = 0; i < N-1; i++) {
				System.out.print(arr[i]);
			}
			System.out.println(" " + arr[N-1]);
		}else {
			System.out.println(1);
			for(int i = 0; i< N; i++) {
				System.out.print(arr[i]);
			}
		}
	}

}
