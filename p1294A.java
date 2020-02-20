import java.io.*;
public class p1294A {
	private static StreamTokenizer st;
	private static int nextInt()throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String args[])throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int p = 0; p < t; ++p) {
			int a = nextInt(), b = nextInt(), c = nextInt(), n = nextInt();
			int max = Math.max(a, Math.max(b, c));
			int remain = (n-3*max+a+b+c);
			pw.println(remain>=0&&remain%3==0?"YES":"NO");
		}
		pw.close();
	}
}
