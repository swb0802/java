import java.text.DecimalFormat;
import java.util.Scanner;


public class NO1045 {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		float vs, r, c;
		float w[];
		float result[];
		int count;
		vs = sc.nextFloat();
		r = sc.nextFloat();
		c = sc.nextFloat();
		count = sc.nextInt();
		
		w = new float[count];
		result = new float[count];
		for(int i = 0; i < count; i++)
		{
			w[i] = sc.nextFloat();
			result[i] = (float) (r * c * vs * w[i] / Math.sqrt(r*r * c*c * w[i]*w[i] + 1));
		}
		
		DecimalFormat df = new DecimalFormat("0.000");
		for(int i = 0; i < count; i++)
		{
			System.out.println(df.format(result[i]));
		}
	}
	
}
