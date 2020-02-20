import java.io.*;
public class p1198 {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	private static long nextLong() throws IOException{
		st.nextToken();
		return (long)st.nval;
	}
	private static String read() throws IOException{
		st.nextToken();
		return st.sval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int M = nextInt(), D = nextInt();
		int x = (int) (Math.ceil(Math.log(M) / Math.log(2))); 
		int size = 2 * (int) Math.pow(2, x) - 1; 
		segTree = new long[size];
		int count = 0; long t = 0;
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < M; ++i) {
			String s = read();
			if(s.equals("A")) {
				//add
				updateST(count,0,M-1,0,(nextLong()+t)%D);
				++count;
			}else {
				//query
				t = queryST(Math.max(0, count-nextInt()),count,0,M-1,0);
				pw.println(t);
			}
		}
		pw.close();
	}
	private static long segTree[];
	private static void updateST(int point, int low, int high, int pos, long val) { //point update
		if(low > high || point > high || point < low) return; //no overlap
		if(point == low && point == high) { //total overlap
			segTree[pos] = val;
			return;
		}
		int mid = (low+high)/2; //partial overlap
		updateST(point,low,mid,2*pos+1,val); updateST(point,mid+1,high,2*pos+2,val);
		segTree[pos] = Math.max(segTree[2*pos+1], segTree[2*pos+2]);
	}
	private static long queryST(int qLow, int qHigh, int low, int high, int pos) { //range query
		if(qLow > high || qHigh < low) return 0; //no coverage
		if(qLow <= low && qHigh >= high) return segTree[pos]; //total overlap
		int mid = (low+high)/2;//partial overlap
		return Math.max(queryST(qLow,qHigh,low,mid,2*pos+1),queryST(qLow,qHigh,mid+1,high,2*pos+2));
	}
}
