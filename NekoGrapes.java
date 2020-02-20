import java.util.*;
public class NekoGrapes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), M = in.nextInt();
		int Ceven = 0, Codd = 0; //even and odd chests
		int Keven = 0, Kodd = 0; //even and odd keys
		for(int i = 0; i < N; i++) {
			if(in.nextInt() % 2 == 1) Codd++;
			else Ceven++;
		}
		for(int i = 0; i < M; i++) {
			if(in.nextInt() % 2 == 1) Kodd++;
			else Keven++;
		}
		in.close();
		System.out.println(Math.min(Ceven, Kodd)+Math.min(Codd, Keven));
	}

}
