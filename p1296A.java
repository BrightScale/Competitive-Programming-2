import java.io.*;
public class p1296A {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			int n = nextInt();
			int oddCount = 0, evenCount = 0;
			for(int i = 0; i < n; ++i) {
				int a = nextInt();
				if((a&1)==1)++oddCount;
				else ++evenCount;
			}
			pw.println((oddCount&1)==1||(oddCount>0&&evenCount>0)?"YES":"NO");
		}
		pw.close();
	}

}
