import java.io.*;
public class p1004 {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N = nextInt();
		int grid[][] = new int[N][N];
		while(true) {
			int x = nextInt(), y = nextInt(), w = nextInt();
			if(x==0&&y==0&&w==0)break;
			grid[x-1][y-1] = w;
		}
		int dp[][] = new int[N][N];
		int dx[] = {0,1};
		int dy[] = {1,0};
		dp[0][0] = grid[0][0];
		for(int i = 0; i < 2*(N-1); ++i) { //o(N^3)
			int temp[][] = new int[N][N];
			for(int j = Math.max(0, i-N+1); j <= i && j < N; ++j) {
				for(int k = Math.max(0, i-N+1); k <= i && k < N; ++k) {
					for(int f = 0; f < 2; ++f) {
						if(isValid(j+dy[f],i-j+dx[f],N)) {
							for(int g = 0; g < 2; ++g) {
								if(isValid(k+dy[g],i-k+dx[g],N)) {
									if(j+dy[f]==k+dy[g])temp[j+dy[f]][k+dy[g]] = Math.max(temp[j+dy[f]][k+dy[g]],
											dp[j][k] + grid[j+dy[f]][i-j+dx[f]]);
									else temp[j+dy[f]][k+dy[g]] = Math.max(temp[j+dy[f]][k+dy[g]],
											dp[j][k] + grid[j+dy[f]][i-j+dx[f]] + grid[k+dy[g]][i-k+dx[g]]);
								}
							}
						}
					}
				}
			}
			dp = temp;
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		pw.println(dp[N-1][N-1]);
		pw.close();
	}
	private static boolean isValid(int x, int y, int N){
		return x < N && y < N;
	}
}
