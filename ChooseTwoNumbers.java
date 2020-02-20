import java.io.*;
public class ChooseTwoNumbers {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int A = nextInt(), maxA = 0;
		for(int i = 0; i < A; i++)maxA = Math.max(maxA, nextInt());
		int B = nextInt(), maxB = 0;
		for(int i = 0; i < B; i++)maxB = Math.max(maxB, nextInt());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		pw.println(maxA + " " + maxB);
		pw.close();
	}
}
