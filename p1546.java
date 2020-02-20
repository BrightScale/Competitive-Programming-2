import java.io.*;
import java.util.*;
public class p1546 {
	private static StreamTokenizer st;
	private static int nextInt()throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N = nextInt();
		ArrayList<Edge> edge = new ArrayList<>();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(i==j) {
					nextInt();
					continue;
				}
				edge.add(new Edge(i,j,nextInt()));
			}
		}
		Collections.sort(edge);
		UnionFindSet ufs = new UnionFindSet(N);
		int ans = 0;
		for(Edge i : edge) {
			if(ufs.find(i.u) != ufs.find(i.v)) {
				ufs.merge(i.u, i.v);
				ans+=i.w;
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		pw.println(ans);
		pw.close();
	}
	private static class UnionFindSet{
		int[]parent;
		int[]size;
		public UnionFindSet(int n) {
			parent = new int[n];
			size = new int[n];
			for(int i = 0; i < n; ++i) {
				parent[i] = i;
				size[i] = 1;
			}
		}
		public int find(int x) {
			if(parent[x] == x) return x;
			return parent[x] = find(parent[x]);
		}
		public void merge(int x, int y) {
			int px = find(x), py = find(y);
			if(size[px] < size[py]) {
				parent[px] = py;
				size[py] += size[px];
			}else{
				parent[py] = px;
				size[px] += size[py];
			}
		}
	}
	private static class Edge implements Comparable<Edge>{
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return w-o.w;
		}
	}
}
