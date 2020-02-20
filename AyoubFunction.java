import java.io.*;
public class AyoubFunction {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		for(int x = 0; x < t; ++x) {
			int n = nextInt(), m = nextInt();
			int first = Math.max(n, n-(n-m*2+1)/2);
			long ans = first*first;
			long bit = 0;
			
		}
	}

}
