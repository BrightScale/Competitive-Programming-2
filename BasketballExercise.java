import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BasketballExercise {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] row = new int[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) row[i][0] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) row[i][1] = Integer.parseInt(st.nextToken());
		br.close();
		long[][] dp = new long[N][2]; 
		for(int i = 0; i < N; i++) {
			long prev0 = 0, prev1 = 0;
			if(i > 0) {
				prev0 = dp[i-1][0];
				prev1 = dp[i-1][1];
			}
			dp[i][0] = Math.max(prev0, prev1 + row[i][0]);
			dp[i][1] = Math.max(prev1, prev0 + row[i][1]);
		}
		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
	}
}