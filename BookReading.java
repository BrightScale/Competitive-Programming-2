import java.io.*;
public class BookReading {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
	private static long nextLong() throws IOException {
		st.nextToken();
		return(long)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int q = nextInt();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < q; i++) {
			long n = nextLong(), m = nextLong();
			long sum = 0;
			for(int j = 1; j <= 10; j++) {
				sum += (m*j)%10;
			}
			long track = m*10 * (n/(m*10));
			sum *= n/(m*10);
			for(int j = 1; j <= 10; j++) {
				if(track+(j*m) > n) break;
				else sum += (j*m)%10;
			}
			pw.println(sum);
		}
		pw.close();
	}

}
