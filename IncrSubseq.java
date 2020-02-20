import java.util.*;

public class IncrSubseq {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int a[] = new int[N];
		for(int i = 0; i < N; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		int count = 0;
		int place = 0;
		int i = 0;
		int j = a.length-1;
		ArrayList<Character> sides = new ArrayList<>();
		for(; i <= j;) {
			if(!(a[i] > place) && !(a[j] > place))break;
			if(!(a[i] > place)) {
				place = a[j];
				j--;
				count++;
				sides.add('R');
			}else if(!(a[j] > place)) {
				place = a[i];
				i++;
				count++;
				sides.add('L');
			}else {
				if(a[i] > a[j]) {
					place = a[j];
					j--;
					count++;
					sides.add('R');
				}else {
					place = a[i];
					i++;
					count++;
					sides.add('L');
				}
			}
		}
		System.out.println(count);
		for(int m = 0; m < count; m++) {
			System.out.print(sides.get(m));
		}
		
	}

}
