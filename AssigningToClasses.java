import java.io.*;
import java.util.*;
public class AssigningToClasses {
	private static StreamTokenizer st;
	private static int nextInt()throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			int n = nextInt();
			int arr[] = new int[2*n];
			for(int i = 0; i < 2*n; ++i)arr[i] = nextInt();
			Arrays.sort(arr);
			pw.println(arr[n]-arr[n-1]);
		}
		pw.close();
	}

}
