import java.io.*;
import java.util.*;
public class KforthePriceofOne {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken()), 
					k = Integer.parseInt(st.nextToken());
			int val[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) val[j] = Integer.parseInt(st.nextToken());
			Arrays.sort(val);
			int dp[][] = new int[n+1][2];
			for(int j = 1; j < k; ++j) dp[j][1] = Integer.MAX_VALUE;
			for(int j = 0; j < n; ++j) {
				dp[j+1][0] = dp[j][0];
				if(j-k+1 >= 0) {
					dp[j+1][0] = Math.min(dp[j+1][0],dp[j][1]);
					dp[j+1][1] = val[j]+Math.min(dp[j-k+1][0], dp[j-k+1][1]);
				}
				dp[j+1][0]+=val[j];
			}
			int ans = 0;
			for(int j = 1; j <= n; ++j) {
				if(Math.min(dp[j][0], dp[j][1]) <= p)ans = j;
			}
			pw.println(ans);
		}
		pw.close();
	}

}
