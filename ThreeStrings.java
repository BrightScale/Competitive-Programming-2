import java.io.*;
public class ThreeStrings {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			String a = br.readLine(), b = br.readLine(), c = br.readLine();
			boolean valid = true;
			for(int i = 0; i < a.length(); ++i) {
				if(a.charAt(i) != c.charAt(i) && b.charAt(i) != c.charAt(i)) {
					valid = false;
					break;
				}
			}
			if(valid)pw.println("YES");
			else pw.println("NO");
		}
		pw.close();
	}

}
