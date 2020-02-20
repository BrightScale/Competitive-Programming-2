import java.io.*;
import java.util.*;
public class PetyaAndExam {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	private static class Test implements Comparable<Test>{
		int t; 
		boolean easy;
		public Test(int t, boolean easy) {
			this.t = t;
			this.easy = easy;
		}
		@Override
		public int compareTo(Test o) {
			return t-o.t;
		}
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int m = nextInt();
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < m; ++i) {
			int n = nextInt(), t = nextInt(), a = nextInt(), b = nextInt();
			Test test[] = new Test[n];
			for(int j = 0; j < n; ++j) test[j] = new Test(0,nextInt()==0?true:false);
			for(int j = 0; j < n; ++j) test[j].t = nextInt();
			Arrays.sort(test);
			int ans = 0;
			int finishTime = 0;
			for(int j = 0; j < n; ++j) {
				if(test[j].t > t) break;
				if(finishTime<test[j].t) {
					ans = j;
					finishTime = test[j].t+(test[j].easy?a:b);
				}else finishTime += test[j].t+(test[j].easy?a:b);
			}
			pw.println(ans);
 		}
		pw.close();
	}

}
