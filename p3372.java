import java.io.*;
public class p3372 {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	private static long nextLong() throws IOException{
		st.nextToken();
		return (long)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N = nextInt(), M = nextInt();
		long val[] = new long[N];
		for(int i = 0; i < N; ++i)val[i] = nextLong();
		int x = (int) (Math.ceil(Math.log(N) / Math.log(2))); 
		int size = 2 * (int) Math.pow(2, x) - 1; 
		segTree = new long[size];
		lazy = new long  [size];
		constructSumTree(0,N-1,0,val);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < M; ++i) {
			if(nextInt()==1)updateST(nextInt()-1,nextInt()-1,0,N-1,0,nextInt());
			else pw.println(rangeSumQuery(nextInt()-1,nextInt()-1,0,N-1,0));
		}
		pw.close();
	}
	private static long segTree[];
	private static long lazy[];
	private static void constructSumTree(int low, int high, int pos, long val[]) {
		if(low == high) {
			segTree[pos] = val[low];
			return;
		}
		int mid = (low+high)/2;
		constructSumTree(low,mid,2*pos+1,val);
		constructSumTree(mid+1,high,2*pos+2,val);
		segTree[pos] = segTree[2*pos+1]+segTree[2*pos+2];
	}
	private static long rangeSumQuery(int qLow, int qHigh, int low, int high, int pos) {
		//lazy propagation
		if (lazy[pos] != 0)  { 
			segTree[pos] += (high-low+1)*lazy[pos]; 
	        if (high != low) { 
	            lazy[pos*2 + 1] += lazy[pos];
	            lazy[pos*2 + 2] += lazy[pos];
	        } 
	        lazy[pos] = 0; 
	    }
		if(qLow <= low && qHigh >= high) { //total overlap
			return segTree[pos];
		}
		if(qLow > high || qHigh < low) { //no overlap
			return 0;
		}
		//partial overlap
		int mid = (low+high)/2;
		return rangeSumQuery(qLow,qHigh,low,mid,2*pos+1)+
				rangeSumQuery(qLow,qHigh,mid+1,high,2*pos+2);
	}
	private static void updateST(int qLow, int qHigh, int low, int high, int pos, int val) {
		//lazy propagation
		if(lazy[pos] != 0) {
			 segTree[pos] += (high-low+1)*lazy[pos]; 
			 if(low != high) {
				 lazy[pos*2 + 1]  += lazy[pos]; 
		         lazy[pos*2 + 2]  += lazy[pos]; 
			 }
			 lazy[pos] = 0;
		}
		//no coverage
		if(low > high || low > qHigh || high < qLow) {
			return;
		}
		//full coverage
		if(high <= qHigh && low >= qLow) {
			segTree[pos] += (high-low+1)*val; 
	        if (high != low) { 
	            lazy[pos*2 + 1] += val; 
	            lazy[pos*2 + 2] += val; 
	        }
	        return;
		}
		int mid = (low+high)/2; 
		updateST(qLow,qHigh, low, mid, 2*pos+1, val); 
		updateST(qLow,qHigh, mid+1, high, 2*pos+2, val); 
		segTree[pos] = segTree[2*pos+1] + segTree[2*pos+2]; 
	}
}
