import java.io.*;
public class p1284A {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	private static String read() throws IOException{
		st.nextToken();
		return st.sval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n = nextInt(), m = nextInt();
		String[] s = new String[n], t = new String[m];
		for(int i = 0; i < n; ++i) s[i] = read();
		for(int i = 0; i < m; ++i) t[i] = read();
		int q = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < q; ++i) {
			int y = nextInt()-1;
			pw.println(s[y%n]+t[y%m]);
		}
		pw.close();
	}

}
