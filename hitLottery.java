import java.util.*;

public class hitLottery {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int bill[] = {100,20,10,5,1};
		int count = 0;
		for(int i = 0; i < bill.length; i++) {
			count += Math.floor(N/bill[i]);
			N -= Math.floor(N/bill[i])*bill[i];
		}
		System.out.println(count);
		in.close();
	}
}
