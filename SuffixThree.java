import java.io.*;
public class SuffixThree {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < N; ++i) {
			String s = br.readLine();
			if(s.length() > 1 && s.substring(s.length()-2,s.length()).equals("po")) {
				pw.println("FILIPINO");
			}else if(s.length() > 3 && (s.substring(s.length()-4,s.length()).equals("desu")
					|| s.substring(s.length()-4,s.length()).equals("masu"))){
				pw.println("JAPANESE");
			}else {
				pw.println("KOREAN");
			}
		}
		pw.close();
	}

}
