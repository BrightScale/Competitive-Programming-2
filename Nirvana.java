import java.util.*;

public class Nirvana {
	static int number(int array[]) {
		int num = 0;
		for(int i = 0; i < array.length; i++) {
			num += array[i] * Math.pow(10, i);
		}
		return num;
	}
	static int product(int array[]) {
		int product = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 0)continue;
			else product *= array[i];
		}
		return product;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.close();
		int length = (int) (Math.log10(N) + 1);
		int[] array = new int[length];
		for(int i = 0; i < length; i++) {
			array[i] = 9;
		}
		for(int i = 0; i < length; i++) {
			while(array[i] > 0 && number(array) > N) {
				array[i]--;
			}
		}
		System.out.println(product(array));
	}

}
