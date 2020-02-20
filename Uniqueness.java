import java.io.*;
import java.util.*;
public class Uniqueness { 
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
    public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int N = nextInt();
		int arr[] = new int[N];
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < N; i++) {
			arr[i] = nextInt();
			hs.add(arr[i]);
		}
		int min = N-1;
		for(int i = 0; i < N; i++) {
			HashSet<Integer> temp =(HashSet<Integer>) hs.clone();
			boolean valid = true;
			for(int j = i+2; j < N; j++) {
				temp.remove(arr[i-1]);
				if(temp.contains(arr[i])) {
					valid = false;
					break;
				}
			}
			if(valid = true) {
				
			}
		}
		System.out.println(min);
    } 
} 