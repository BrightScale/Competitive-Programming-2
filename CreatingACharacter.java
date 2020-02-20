import java.io.*;
public class CreatingACharacter {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int T = nextInt();
		for(int i = 0; i < T; i++) {
			int S = nextInt(), I = nextInt(), E = nextInt();
			//binary search
			int a = S, b = S+E;
		}
	}

}
