import java.io.*;
import java.util.*;
public class p1278A {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		diffLoop: for(int i = 0; i < t; ++i) {
			String p = br.readLine(), h = br.readLine();
			if(h.length() < p.length()) {
				pw.println("NO");
				continue;
			}
			HashMap<Character, Integer> occur = new HashMap<>();
			for(int j = 0; j < p.length(); ++j) {
				if(!occur.containsKey(p.charAt(j)))occur.put(p.charAt(j), 1);
				else occur.put(p.charAt(j), occur.get(p.charAt(j))+1);
			}
			//sliding window to check if valid
			HashMap<Character, Integer> match = new HashMap<>();
			for(int j = 0; j < p.length()-1; ++j) {
				if(!match.containsKey(h.charAt(j)))match.put(h.charAt(j), 1);
				else match.put(h.charAt(j), match.get(h.charAt(j))+1);
			}
			for(int j = p.length()-1; j < h.length(); ++j) {
				//add current character
				if(!match.containsKey(h.charAt(j)))match.put(h.charAt(j), 1);
				else match.put(h.charAt(j), match.get(h.charAt(j))+1);
				//check if the same
				boolean valid = true;
				for(Map.Entry<Character,Integer> k : occur.entrySet()) {
					if(!match.containsKey(k.getKey()) || match.get(k.getKey()) != k.getValue()) {
						valid = false;
						break;
					}
				}
				if(valid) {
					pw.println("YES");
					continue diffLoop;
				}
				//remove first character in the map
				if(match.get(h.charAt(j-p.length()+1))==1)match.remove(h.charAt(j-p.length()+1));
				else match.put(h.charAt(j-p.length()+1), match.get(h.charAt(j-p.length()+1))-1);
			}
			pw.println("NO");
		}
		pw.close();
	}

}
