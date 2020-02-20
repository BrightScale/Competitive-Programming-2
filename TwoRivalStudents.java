import java.io.*;
public class TwoRivalStudents {
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
			int n = nextInt(), x = nextInt(), a = nextInt(), b = nextInt();
			pw.println(n-Math.abs(a-b)-x<=0?n-1:Math.abs(a-b)+x);
		}
		pw.close();
	}

}
