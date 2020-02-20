import java.io.*;
import java.util.*;
public class MotarackBirthday {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = 0; int maxDif = 0;
			int max = 0, min = Integer.MAX_VALUE,last = 0;
			for(int i = 0; i < n; ++i) {
				int val = Integer.parseInt(st.nextToken());
				if(val==-1 && i > 0 && last!=-1) {
					max = Math.max(max, last); min = Math.min(min, last);
					++count;
				}else if(i>0 && val>=0){
					if(last==-1) {
						max = Math.max(max, val); min = Math.min(min, val);
						++count;
					}else {
						maxDif = Math.max(maxDif, Math.abs(last-val));
					}
				}
				last = val;
			}
			int k;
			if(count == 0) {
				k = 0;
			}else if(count == 1) {
				k =  max;
			}else {
				k = (max+min)/2;
				maxDif = Math.max(maxDif, Math.max(Math.abs(min-k), Math.abs(max-k)));
			}
			pw.println(maxDif + " " + k);
		}
		pw.close();
	}

}
