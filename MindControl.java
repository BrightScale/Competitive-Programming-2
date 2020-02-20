import java.io.*;
public class MindControl {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			int n = nextInt(), m = nextInt(), k = nextInt();
			int arr[] = new int[n];
			for(int i = 0; i < n; ++i) arr[i] = nextInt();
			k = Math.min(m-1, k);
			//find answer
			int ans = 0;
			for(int i = 0; i <= k; ++i) {//take i element on the left
				int temp = Integer.MAX_VALUE;
				for(int j = 0; j < m-k; ++j) {//take j element on the left after
					temp = Math.min(temp,Math.max(arr[i+j], arr[(n-(k-i))-(m-k-j)]));
				}
				ans = Math.max(ans, temp);
			}
			pw.println(ans);
		}
		pw.close();
	}

}
