import java.util.*;
public class WaterLily {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double h = in.nextDouble(), l = in.nextDouble();
		in.close();
		System.out.printf("%.13f",((Math.pow(h,2)+Math.pow(l, 2))/(2*h))-h);
	}
}

//Math.pow((x-h),2)= Math.pow(x,2)-Math.pow(l,2)
//x^2-2xh+h^2 = x^2 - l^2
//-2xh+h^2 = -l^2
//2xh = h^2+l^2
//x = (h^2+l^2)2h
//output x-h