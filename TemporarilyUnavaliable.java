import java.io.*;
public class TemporarilyUnavaliable {
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
			int a = nextInt(), b = nextInt(), c = nextInt(), r = nextInt();
			int ans = 0;
			if((a<c-r && b < c-r) || (a>c+r && b > c+r)) {
				ans = Math.abs(b-a);
				
			}else {
				if(a<c-r) {
					ans += Math.abs(c-r-a);
				}
				if(a>c+r) {
					ans += Math.abs(a-c-r);
				}
				if(b<c-r) {
					ans += Math.abs(c-r-b);
				}
				if(b>c+r) {
					ans += Math.abs(b-c-r);
				}
			}
			pw.println(ans);
		}
		pw.close();
	}

}
