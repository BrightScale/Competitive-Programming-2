import java.io.*;
public class MakeProductEqualOne {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
	private static long nextLong() throws IOException {
		st.nextToken();
		return(long)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N = nextInt();
		long ans = 0;
		long negativeCount = 0;
		boolean containsZero = false;
		for(int i = 0; i < N; i++) {
			long a = nextLong();
			if(a < 0) {
				ans += -a-1;
				negativeCount++;
			}else if(a == 0){
				ans += 1;
				containsZero = true;
			}else {
				ans += a-1;
			}
		}
		if(negativeCount % 2 == 1 && !containsZero)ans+=2;
		System.out.println(ans);
	}

}
