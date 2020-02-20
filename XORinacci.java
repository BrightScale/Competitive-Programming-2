import java.io.*;
public class XORinacci {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
	private static int xorCalc(int k) { 
	        if (k == 1)  
	            return 2; 
	          
	        // if k is of form 2^i-1 
	        if (((k + 1) & k) == 0)  
	            return k / 2; 
	      
	        return 1; 
	} 
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int T = nextInt();
		for(int i = 0; i < T; i++) {
			int a = nextInt(),b = nextInt(),N = nextInt();
			System.out.println(xorCalc(N));
		}
	}

}
