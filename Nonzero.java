import java.io.*;
public class Nonzero {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws  IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			int n = nextInt();
			int numOfZero = 0, totSum = 0;
			for(int i = 0; i < n; ++i) {
				int j = nextInt();
				if(j==0)++numOfZero;
				totSum+=j;
			}
			int steps = numOfZero;
			totSum+=numOfZero;
			if(totSum==0)++steps;
			pw.println(steps);
		}
		pw.close();
	}

}
