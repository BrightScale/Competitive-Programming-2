import java.io.*;
import java.util.*;
public class EqualRectangles {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int Q = nextInt();
		for(int i = 0; i < Q; i++) {
			int N = nextInt();
			int arr[] = new int[N*4];
			for(int j = 0; j < N*4; j++) arr[j] = nextInt();
			Arrays.sort(arr);
			boolean valid = true;
			int save = arr[0] * arr[N*4-1];
			for(int j = 0; j < N; j++) {
				if(arr[j*2]*arr[N*4-1-j*2]!=save) {
					valid = false;
					break;
				}
				if(arr[j*2]!=arr[j*2+1] || arr[N*4-j*2-1] != arr[N*4-j*2-2]) {
					valid = false;
					break;
				}
			}
			if(valid)System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
