import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class Search {
	protected static int steps = 0;


	public static int linSearch(double[] search, double elem) {
		for(steps = 0; steps < search.length; steps++) {
			if(elem == search[steps]) {
				return steps;
			}		
		}
		return -1;
	}

	public static int binSearch(double[] search, double elem) {
		steps = 0;
		return binSearch(search, elem, 0, search.length-1);
	}
	
	private static int binSearch(double[] search, double elem, int left, int right) {
		steps++;
		if(left > right)
			return -1;
		
		int mid = (right + left) / 2;
		if(elem == search[mid])
			return mid;
		if(elem < search[mid])
			return binSearch(search, elem, left, mid-1);
		else 
			return binSearch(search, elem, mid+1, right);
		
	}	
	
	public static int interSearch(double[] search, double elem) {
		steps = 0;
		return interSearch(search, elem, 0, search.length-1);
	}
	
	public static int interSearch(double[] search, double elem, int left, int right) {
		steps++;
		if(left > right)
			return -1;
		
		int next = left
				+ (int) ((right - left) * (elem - search[left]) / (search[right] - search[left]));
		if(elem == search[next])
			return next;
		if(elem < search[next])
			return interSearch(search, elem, left, next-1);
		else 
			return interSearch(search, elem, next+1, right);
	}
	

	public static void main(String[] argv) {
		
		String format = "%-10s%10s%10s%10s%10s\n";
		
		// Head:
		System.out.printf(format, "n", "100", "1000", "10000", "100000");
				
		double avg1, avg2, avg3, avg4;
		//Linear:
		avg1 = avg100Runs(0,100,false);
		avg2 = avg100Runs(0,1000,false);
		avg3 = avg100Runs(0,10000,false);
		avg4 = avg100Runs(0,100000,false);
		System.out.printf(format, "Linear", avg1, avg2, avg3, avg4);
		
		avg1 = avg100Runs(0,100,true);
		avg2 = avg100Runs(0,1000,true);
		avg3 = avg100Runs(0,10000,true);
		avg4 = avg100Runs(0,100000,true);
		System.out.printf(format, "Linear^2", avg1, avg2, avg3, avg4);
		
		avg1 = avg100Runs(1,100,false);
		avg2 = avg100Runs(1,1000,false);
		avg3 = avg100Runs(1,10000,false);
		avg4 = avg100Runs(1,100000,false);
		System.out.printf(format, "Binaer", avg1, avg2, avg3, avg4);

		avg1 = avg100Runs(1,100,true);
		avg2 = avg100Runs(1,1000,true);
		avg3 = avg100Runs(1,10000,true);
		avg4 = avg100Runs(1,100000,true);
		System.out.printf(format, "Binaer^2", avg1, avg2, avg3, avg4);
		
		avg1 = avg100Runs(2,100,false);
		avg2 = avg100Runs(2,1000,false);
		avg3 = avg100Runs(2,10000,false);
		avg4 = avg100Runs(2,100000,false);
		System.out.printf(format, "Interpol", avg1, avg2, avg3, avg4);

		avg1 = avg100Runs(2,100,true);
		avg2 = avg100Runs(2,1000,true);
		avg3 = avg100Runs(2,10000,true);
		avg4 = avg100Runs(2,100000,true);
		System.out.printf(format, "Interpol^2", avg1, avg2, avg3, avg4);
		
		
		
	}
	
	
	public static double[] randomArray(int length, boolean square) {
		double[] random = new double[length];
		for(int i = 0; i < length; i++){
			random[i] = ThreadLocalRandom.current().nextDouble(0., 1.);
			if(square)
				random[i] *= random[i];
		}
		return random;
	}
	
	public static double avg100Runs(int method, int length, boolean square) {
		double averageSteps = 0;
		for (int run = 0; run < 100; run++) {
			double[] random = randomArray(length, square);
			double elem = random[0];
			Arrays.sort(random);
			if(method == 0)
				linSearch(random, elem);	
			else if (method == 1)
				binSearch(random, elem);
			else
				interSearch(random, elem);
			averageSteps += steps;
		}
		return averageSteps / 100.0;
	}
}
