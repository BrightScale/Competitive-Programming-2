import java.io.*;
public class p1283B {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < t; ++i) {
			int n = nextInt(), k = nextInt();
			long m = n/k, l = n-m*k;
			pw.println(m*k + Math.min(k/2, l));
		}
		pw.close();
	}

}
