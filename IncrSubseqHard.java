import java.util.*;
public class IncrSubseqHard {
	static int arr[];
	private static ArrayList<Character> maxStrict(ArrayList<Character> sides, int a, int b, int place) {
		if(a == b) {
			if(arr[a] > place) {
				sides.add('R');
				return sides;
			}
		}
		if(!(arr[a] > place) && !(arr[b] > place) && a==b)return sides;
		if(!(arr[a] > place)) {
			place = arr[b];
			sides.add('R');
			b--;
			return maxStrict(sides,a,b,place);
		}else if(!(arr[b] > place)) {
			place = arr[a];
			sides.add('L');
			a++;
			return maxStrict(sides,a,b,place);
		}else if(arr[a] > arr[b]) {
			place = arr[b];
			b--;
			sides.add('R');
			return maxStrict(sides,a,b,place);
		}else if(arr[b] > arr[a]) {
			place = arr[a];
			a++;
			sides.add('L');
			return maxStrict(sides,a,b,place);
		}else {
			place = arr[a];
			ArrayList<Character> right = maxStrict(sides,a,b-=1,place); //arraylist sides is changed, doesn't work
			ArrayList<Character> left = maxStrict(sides,a+=1,b+=1,place);
			if(right.size() > left.size()) return right;
			return left;
		}
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		ArrayList<Character> result = maxStrict(new ArrayList<Character>(),0,arr.length-1, 0);
		System.out.println(result.size());
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
	}

}
