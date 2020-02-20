import java.io.*;
public class p3373 {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	private static long nextLong() throws IOException{
		st.nextToken();
		return (long)st.nval;
	}
	private static int P;
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N = nextInt(), M = nextInt(); P = nextInt();
		long val[] = new long[N];
		for(int i = 0; i < N; ++i)val[i] = nextLong();
		int x = (int) (Math.ceil(Math.log(N) / Math.log(2))); 
		int size = 2 * (int) Math.pow(2, x) - 1; 
		segTree = new long[size];
		lazyS = new long[size];
		lazyM = new long[size];
		constructSumTree(0,N-1,0,val);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < M; ++i) {
			int a = nextInt();
			if(a==1) {
				multiplyST(nextInt()-1,nextInt()-1,0,N-1,0,nextInt());
			}else if(a==2) {
				addST(nextInt()-1,nextInt()-1,0,N-1,0,nextInt());
			}else {
				pw.println(rangeSumQuery(nextInt()-1,nextInt()-1,0,N-1,0));
			}
		}
		pw.close();
	}
	private static long segTree[];
	private static long lazyS[];
	private static long lazyM[];
	private static void constructSumTree(int low, int high, int pos, long val[]) {
		if(low == high) {
			segTree[pos] = val[low]%P;
			return;
		}
		int mid = (low+high)/2;
		constructSumTree(low,mid,2*pos+1,val);
		constructSumTree(mid+1,high,2*pos+2,val);
		segTree[pos] = (segTree[2*pos+1]+segTree[2*pos+2])%P;
		lazyM[pos] = 1;
	}
	private static long rangeSumQuery(int qLow, int qHigh, int low, int high, int pos) {
		//lazy propagation
		//multiply
		if (lazyM[pos] != 0)  { 
			segTree[pos] = ((segTree[pos]*lazyM[pos])%P+P)%P; 
			if (high != low) { 
				lazyM[pos*2 + 1] *= lazyM[pos];
				lazyM[pos*2 + 2] *= lazyM[pos];
			} 
			lazyM[pos] = 1; 
		}
		//sum
		if (lazyS[pos] != 0)  { 
			segTree[pos] += (((high-low+1)*lazyS[pos])%P+P)%P;
			segTree[pos] %= P;
	        if (high != low) { 
	            lazyS[pos*2 + 1] += lazyS[pos];
	            lazyS[pos*2 + 2] += lazyS[pos];
	        } 
	        lazyS[pos] = 0; 
	    }
		if(qLow <= low && qHigh >= high) { //total overlap
			return segTree[pos];
		}
		if(qLow > high || qHigh < low) { //no overlap
			return 0;
		}
		//partial overlap
		int mid = (low+high)/2;
		return (rangeSumQuery(qLow,qHigh,low,mid,2*pos+1)+
				rangeSumQuery(qLow,qHigh,mid+1,high,2*pos+2))%P;
	}
	private static void multiplyST(int qLow, int qHigh, int low, int high, int pos, int val) {
		//lazy propagation
		//multiply
		if (lazyM[pos] != 0)  { 
			segTree[pos] = ((segTree[pos]*lazyM[pos])%P+P)%P; 
			if (high != low) { 
				lazyM[pos*2 + 1] *= lazyM[pos];
				lazyM[pos*2 + 2] *= lazyM[pos];
				lazyS[pos*2 + 1] *= lazyM[pos];
				lazyS[pos*2 + 2] *= lazyM[pos];
			} 
			lazyM[pos] = 1; 
		}
		//sum
		if (lazyS[pos] != 0)  { 
			segTree[pos] += (((high-low+1)*lazyS[pos])%P+P)%P;
			segTree[pos] %= P;
	        if (high != low) { 
	            lazyS[pos*2 + 1] += lazyS[pos];
	            lazyS[pos*2 + 2] += lazyS[pos];
	        } 
	        lazyS[pos] = 0; 
	    }
		//no coverage
		if(low > high || low > qHigh || high < qLow) {
			return;
		}
		//full coverage
		if(high <= qHigh && low >= qLow) {
			segTree[pos] = ((segTree[pos]*val)%P+P)%P; 
	        if (high != low) { 
	            lazyM[pos*2 + 1] *= val; 
	            lazyM[pos*2 + 2] *= val;
	            lazyS[pos*2 + 1] *= val; 
	            lazyS[pos*2 + 2] *= val;
	        }
	        return;
		}
		int mid = (low+high)/2; 
		multiplyST(qLow,qHigh, low, mid, 2*pos+1, val); 
		multiplyST(qLow,qHigh, mid+1, high, 2*pos+2, val); 
		segTree[pos] = (segTree[2*pos+1] + segTree[2*pos+2])%P; 
	}
	private static void addST(int qLow, int qHigh, int low, int high, int pos, int val) {
		//lazy propagation
		//multiply
		if (lazyM[pos] != 0)  { 
			segTree[pos] = ((segTree[pos]*lazyM[pos])%P+P)%P; 
			if (high != low) { 
				lazyM[pos*2 + 1] *= lazyM[pos];
				lazyM[pos*2 + 2] *= lazyM[pos];
				lazyS[pos*2 + 1] *= lazyM[pos];
				lazyS[pos*2 + 2] *= lazyM[pos];
			} 
			lazyM[pos] = 1; 
		}
		//sum
		if (lazyS[pos] != 0)  { 
			segTree[pos] += (((high-low+1)*lazyS[pos])%P+P)%P;
			segTree[pos] %= P;
	        if (high != low) { 
	            lazyS[pos*2 + 1] += lazyS[pos];
	            lazyS[pos*2 + 2] += lazyS[pos];
	        } 
	        lazyS[pos] = 0; 
	    }
		//no coverage
		if(low > high || low > qHigh || high < qLow) {
			return;
		}
		//full coverage
		if(high <= qHigh && low >= qLow) {
			segTree[pos] += (((high-low+1)*val)%P+P)%P;
			segTree[pos] %= P;
	        if (high != low) { 
	            lazyS[pos*2 + 1] += val; 
	            lazyS[pos*2 + 2] += val; 
	        }
	        return;
		}
		int mid = (low+high)/2; 
		addST(qLow,qHigh, low, mid, 2*pos+1, val); 
		addST(qLow,qHigh, mid+1, high, 2*pos+2, val); 
		segTree[pos] = (segTree[2*pos+1] + segTree[2*pos+2])%P; 
	}
}
