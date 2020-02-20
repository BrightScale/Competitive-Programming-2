import java.util.*;
public class bearBrother {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt(), b = in.nextInt(), ans = 0;
		for(;a<=b;ans++,a *= 3, b *= 2);
		System.out.println(ans);
		in.close();
	}

}
