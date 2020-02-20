import java.io.*;
public class Knapsack {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int W = nextInt();
		boolean dp[] = new boolean[W+1];
		dp[0] = true;
		for(int i = 0; i < 8; i++) {
			int a = nextInt();
			boolean temp[] = new boolean[W+1];
			for(int j = 0; j <= W; j++) {
				temp[j] = dp[j] || temp[j];
				if(dp[j]&&j+a<=W)temp[j+a]=true;
			}
			dp = temp;
		}
		for(int i = W; i >= 0; i--) {
			if(dp[i]) {
				System.out.println(i);
				return;
			}
		}
	}

}
