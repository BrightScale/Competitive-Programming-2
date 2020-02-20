import java.util.*;

public class Polycarp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt(), curr = 1;
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) a[i] = in.nextInt();
        in.close();
        Arrays.sort(a);
        for(int i = 0; i < n; i++) if(curr <= a[i]) curr++;
        System.out.println(curr-1);
	}
}
