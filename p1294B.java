import java.io.*;
import java.util.*;
import java.awt.Point;
public class p1294B {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int t = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int x = 0; x < t; ++x) {
			int n = nextInt();
			Point pt[] = new Point[n+1];
			for(int i = 0; i < n; ++i)pt[i] = new Point(nextInt(),nextInt());
			pt[n] = new Point(0,0);
			Arrays.sort(pt,new compareX());
			boolean valid = true;
			String s = "";
			for(int i = 1 ; i <= n; ++i) {
				if(pt[i].y < pt[i-1].y) {
					valid = false;
					break;
				}
				for(int j = pt[i-1].x; j < pt[i].x; ++j)s+="R";
				for(int j = pt[i-1].y; j < pt[i].y; ++j)s+="U";
			}
			if(valid) pw.println("YES" + "\n" + s);
			else pw.println("NO");
		}
		pw.close();
	}
	private static class compareX implements Comparator<Point>{
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.x==o2.x)return o1.y-o2.y;
			return o1.x-o2.x;
		}
	}
}
