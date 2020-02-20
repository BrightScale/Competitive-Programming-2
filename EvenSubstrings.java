import java.io.*;
public class EvenSubstrings{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int ans = 0;
		for(int i = 0; i < n; ++i) ans += (s.charAt(i)-'0')%2==0?i+1:0;
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		pw.println(ans);
		pw.close();
	}
}