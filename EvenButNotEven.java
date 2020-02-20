import java.io.*;
public class EvenButNotEven {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			br.readLine(); String n = br.readLine();
			//find the amount of even and odd digit
			int odd = 0;
			for(int i = 0; i < n.length(); ++i) {
				odd += (n.charAt(i)-'1'+1)%2==0?0:1;
			}
			//remove ending even
			while(!n.isEmpty()&&(n.charAt(n.length()-1)-'1'+1)%2==0) {
				n = n.substring(0,n.length()-1);
			}
			//odd digits
			if(odd!=1&&odd%2==1) {
				//remove any odd
				String s = n;
				String ans = "";
				for(int i = 0; i < s.length(); ++i) {
					int m = s.charAt(i)-'1'+1;
					if(m%2==1) {
						ans = s.substring(0,i)+s.substring(i+1);
						break;
					}
				}
				while(ans.charAt(0)=='0') ans = ans.substring(1);
				pw.println(ans);
			}else {
				if(odd <= 1)pw.println(-1);
				else pw.println(n);
			}
		}
		pw.close();
	}

}
