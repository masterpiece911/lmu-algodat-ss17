public class Hashing {
	
	
	public static int h1(int i){
		return i/10+i%10;
	}
	
	public static int h2(int i) {
		return i%23;
	}
	
	public static void main(String[] args) {
		Integer[] array = {17, 46, 44, 32, 37, 8, 15, 19, 1, 87, 52, 44, 91, 82, 95, 63, 12, 54, 41, 88, 67, 80, 17};
		print(array);
		
		Integer[] harray1 = hash(array,1,1);
		print(harray1);
		
		Integer[] harray2 = hash(array,1,2);
		print(harray2);
		
		Integer[] harray3 = hash(array,2,1);
		print(harray3);
		
		
		Integer[] harray4 = hash(array,2,2);
		print(harray4);
		
		Integer[] harray5 = hash(array,3,1);
		print(harray5);
		
		Integer[] harray6 = hash(array,3,2);
		print(harray6);
		
		
		/*for(int m = 3; m < 35; m++) {
		
	
		Integer[] test = new Integer[m];
		int pos = 0;
		for(long i = 0; i < 100000; i++) {
			pos = (int)((i*i)%m);
			if(test[pos] == null)
				test[pos] = 1;
			else 
				test[pos] = test[pos] + 1;
		}
		System.out.print(m + ":\t");
		print(test);

		}*/
		
		
	}
	
	public static Integer[] hash(Integer[] array, int probe, int func){
		Integer[] result = new Integer[array.length];
		
		for(int i = 0; i < array.length; i++) {
			int hash = (func == 1 ? h1(array[i]) : h2(array[i]));
		
			
			int step = 0;
			int pos = hash;
			while(result[pos] != null) {
				step++;
				
				if(step > 22) // abbruch
					break;
				if(probe == 1)					
					pos = hash + step;
				else if(probe == 2)
					pos = hash + step*step;
				else
					pos = hash + step*step*(func == 2 ? h1(array[i]) : h2(array[i]));
				
				pos = pos%array.length;
			
				
			}
			if(result[pos] == null)
				result[pos] = array[i];
		}
		return result;
	}
	
	public static void print(Integer[] array) {
		String format = "%-2s ";
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null)
				System.out.printf(format, array[i]);
			else 
				System.out.printf(format, "--");
		}
		System.out.println();
	}
	
	
}