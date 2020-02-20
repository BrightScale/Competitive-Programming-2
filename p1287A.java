import java.io.*;
public class p1287A {
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
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < t; ++i) {
			int n = nextInt();
			String s = read();
			int curr = -1, max = 0;
			for(int j = 0; j < n; ++j) {
				if(s.charAt(j)=='A') {
					if(curr < 0) curr = j;
					else {
						max = Math.max(max, j-curr-1);
						curr = j;
					}
				}
			}
			if(curr>=0)max = Math.max(max, n-curr-1);
			pw.println(max);
		}
		pw.close();
	}

}
