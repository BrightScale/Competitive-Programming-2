import java.io.*;
import java.util.*;
public class DominatedSubarray {
	private static StreamTokenizer st;
	private static int nextInt() throws IOException{
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException{
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int T = nextInt();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		for(int i = 0; i < T; ++i) {
			int n = nextInt();
			if(n==1) {
				nextInt();
				pw.println(-1);
				continue;
			}
			int arr[] = new int[n];
			HashMap<Integer,Integer> hm = new HashMap<>();
			int max = 0;
			int num = 0;
			ArrayList<Integer> keep = new ArrayList<>();
			boolean valid = true;
			for(int j = 0; j < n; ++j) {
				arr[j] = nextInt();
				if(hm.containsKey(arr[j]))hm.put(arr[j], hm.get(arr[j])+1);
				else {
					keep.add(arr[j]);
					hm.put(arr[j],1);
				}
				if(hm.get(arr[j])>max) {
					max = hm.get(arr[j]);
					num = arr[j];
					valid = true;
				}else if(hm.get(arr[j])==max)valid=false;
			}
			if(!valid) {
				pw.println(-1);
			}
			TreeMap<Integer,Integer> tm  = new TreeMap<>();
			HashSet<Integer> hs = new HashSet<>();
			for(int j : keep) {
				if(hs.contains(hm.get(j))) tm.put(hm.get(j),tm.get(hm.get(j)+1));
				else tm.put(hm.get(j),1);
			}
			int l = 0, r = n-1;
			while(l+2 < r) {
				if(tm.size()==1) {
					l=0;
					r=2;
					break;
				}
				boolean cont = false;
				if(arr[r]==num && tm.lowerKey(tm.lastKey())<hm.get(num)-1) {
					if(hs.contains(hm.get(num)-1)) tm.put(hm.get(num)-1, tm.get(hm.get(num)-1)+1);
					tm.put(hm.get(num)-1,1);
					tm.remove(hm.get(num));
					hs.remove(hm.get(num));
					hm.put(num,hm.get(num)-1);
					cont = true;
					--r;
				}
				if(arr[l]==num && tm.lowerKey(hm.get(num))<hm.get(num)-1) {
					if(hs.contains(hm.get(num)-1)) tm.put(hm.get(num)-1, tm.get(hm.get(num)-1)+1);
					tm.put(hm.get(num)-1,1);
					tm.remove(hm.get(num));
					hs.remove(hm.get(num));
					hm.put(num,hm.get(num)-1);
					cont = true;
					++l;
				}
				if(arr[r] != num) {
					if(hm.get(arr[r])==1) {
						int a = tm.firstEntry().getValue();
						if(a==1) tm.remove(1);
						else tm.put(1,a-1);
					}else {
						int a = tm.get(hm.get(arr[r]));
						if(a==1) tm.remove(hm.get(arr[r]));
						else tm.put(hm.get(arr[r]), a-1);
						if(hs.contains(hm.get(arr[r])-1)) tm.put(hm.get(arr[r]-1),tm.get(hm.get(arr[r]-1)+1));
						else tm.put(hm.get(arr[r])-1,1);
					}
					hm.put(arr[r], hm.get(arr[r])-1);
					cont = true;
					--r;
				}
				if(arr[l] != num) {
					if(hm.get(arr[l])==1) {
						int a = tm.firstEntry().getValue();
						if(a==1) tm.remove(1);
						else tm.put(1,a-1);
					}else {
						int a = tm.get(hm.get(arr[l]));
						if(a==1) tm.remove(hm.get(arr[l]));
						else tm.put(hm.get(arr[l]), a-1);
						if(hs.contains(hm.get(arr[l])-1)) tm.put(hm.get(arr[l]-1),tm.get(hm.get(arr[l]-1)+1));
						else tm.put(hm.get(arr[l])-1,1);
					}
					hm.put(arr[l], hm.get(arr[l])-1);
					cont = true;
					++l;
				}
				if(!cont)break;
			}
			pw.println(r-l);
		}
		pw.close();
	}

}
