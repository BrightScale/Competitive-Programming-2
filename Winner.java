import java.io.*;
import java.util.*;
import java.awt.Point;
public class Winner {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	private static String read() throws IOException{
		st.nextToken();
		return st.sval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n = nextInt();
		TreeMap<Point,String> tm = new TreeMap<>(new compareX()); //use point as pair
		HashMap<String,Integer> nameToPoint = new HashMap<>(), nameToTime = new HashMap<>();
		String winner = ""; int maxPt = 0;
		for(int i = 0; i < n; ++i) {
			String name = read();
			int pt = nextInt();
			if(!nameToPoint.containsKey(name)) {
				nameToPoint.put(name, pt);
				nameToTime.put(name,i);
				tm.put(new Point(pt,i), name);
			}else{
				tm.remove(new Point(nameToPoint.get(name),nameToTime.get(name)));
				nameToPoint.put(name,nameToPoint.get(name)+pt);
				nameToTime.put(name,i);
				tm.put(new Point(nameToPoint.get(name),nameToTime.get(name)),name);
			}
			if(maxPt<nameToPoint.get(name)) {
				winner = name;
				maxPt = nameToPoint.get(name);
			}
			if(nameToPoint.get(name)<0) {
				tm.remove(new Point(nameToPoint.get(name),nameToTime.get(name)));
				nameToPoint.remove(name);
				nameToTime.remove(name);
			}
		}
		System.out.println(winner);
	}
	private static class compareX implements Comparator<Point>{
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.x==o2.x)return o1.y-o2.y;
			return o2.x-o1.x;
		}
		
	}
}
