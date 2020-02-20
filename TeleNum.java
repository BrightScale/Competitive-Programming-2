import java.util.*;

public class TeleNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int l[] = new int[N];
		String s[] = new String[N];
		for(int i = 0; i < N; i++) {
			l[i] = in.nextInt();
			s[i] = in.next();
		}
		in.close();
		for(int i = 0; i < N; i++) {
			if(s[i].contains("8") && l[i] - s[i].indexOf("8") >= 11) {
				System.out.println("YES");
			}else System.out.println("NO");
		}
	}

}
