import java.io.*;
public class p1292A {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N = nextInt(), Q = nextInt();
		int[] x = new int[Q], y = new int[Q];
		for(int i = 0; i < Q; ++i) {
			x[i] = nextInt()-1; y[i] = nextInt()-1;
		}
 		boolean lava[][] = new boolean[2][N];
 		int blockCount = 0;
 		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 		for(int i = 0; i < Q; ++i) {
			if(lava[x[i]+(x[i]==0?1:-1)][y[i]])blockCount+=lava[x[i]][y[i]]?-1:1;
			if(y[i] > 0 && lava[x[i]+(x[i]==0?1:-1)][y[i]-1])blockCount+=lava[x[i]][y[i]]?-1:1;
			if(y[i] < N-1 && lava[x[i]+(x[i]==0?1:-1)][y[i]+1])blockCount+=lava[x[i]][y[i]]?-1:1;
			lava[x[i]][y[i]] = !lava[x[i]][y[i]];
 			if(blockCount==0)pw.println("Yes");
 			else pw.println("No");
 		}
		pw.close();
	}
}
