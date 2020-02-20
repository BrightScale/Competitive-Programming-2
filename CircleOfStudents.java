import java.io.*;
public class CircleOfStudents {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException {
		st.nextToken();
		return(int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int Q = nextInt();
		for(int i = 0; i < Q; i++) {
			int N = nextInt();
			int arr[] = new int[N];
			int minIndex = 0;
			for(int j = 0; j < N; j++) {
				arr[j] = nextInt();
				minIndex = arr[minIndex] > arr[j] ? j : minIndex;
			}
			boolean rValid = true;
			//going right
			for(int j = minIndex+1; j < N; j++) {
				if(arr[j]!=arr[j-1]+1) {
					rValid = false;
					break;
				}
			}
			if(rValid) {
				for(int j = 0; j < minIndex; j++) {
					if(j==0) {
						if(arr[j]!=arr[N-1]+1) {
							rValid = false;
							break;
						}
					}else {
						if(arr[j]!=arr[j-1]+1) {
							rValid = false;
							break;
						}
					}
				}
			}
			if(rValid) {
				System.out.println("YES");
				continue;
			}
			//going left
			if(!rValid) {
				boolean lValid = true;
				for(int j = minIndex-1; j >= 0; j--) {
					if(arr[j]!=arr[j+1]+1) {
						lValid = false;
						break;
					}
				}
				if(lValid) {
					for(int j = N-1; j > minIndex; j--) {
						if(j == N-1) {
							if(arr[j]!=arr[0]+1) {
								lValid = false;
								break;
							}
						}else {
							if(arr[j]!=arr[j+1]+1) {
								lValid = false;
								break;
							}
						}
					}
				}
				if(lValid) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}

}
