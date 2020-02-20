import java.io.*;
public class MagicStick {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int T = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < T; ++i) {
			int x = nextInt(), y = nextInt();
			if((x!=y)&&((x<4&&y>3)||(x==1)))pw.println("NO");
			else pw.println("YES");
		}
		pw.close();
	}

}
