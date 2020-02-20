import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class PrimeSubtraction {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st;
		while(--t >= 0) {
			st = new StringTokenizer(br.readLine());
			pw.println(Long.parseLong(st.nextToken())-Long.parseLong(st.nextToken())>1?"YES":"NO");
		}
		pw.close();
	}
}
