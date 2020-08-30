package assign3;

public class inversionPairs {
	
	public static int inversionCount(int a[]){
		
		int count = 0;
		for(int i = 0; i < a.length; i++){
			int ind = a[i];
			for(int j = i; j < a.length; j++){
				if(ind > a[j]) count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4, 3, 5, 2, 1};
		int[] b = {1};
		int[] c = {2, 1};
		int[] d = {3, 2, 1};
		int[] e = {4, 3, 2, 1};
		int[] f = {5, 4, 3, 2, 1};
		int[] g = {6, 5, 4, 3, 2, 1}; 
		System.out.println("The number of inversions in the given example is: " + inversionCount(a));
		System.out.println("Number of inversion with n = 1 elements: " + inversionCount(b));
		System.out.println("Number of inversion with n = 2 elements: " + inversionCount(c));
		System.out.println("Number of inversion with n = 3 elements: " + inversionCount(d));
		System.out.println("Number of inversion with n = 4 elements: " + inversionCount(e));
		System.out.println("Number of inversion with n = 5 elements: " + inversionCount(f));
		System.out.println("Number of inversion with n = 6 elements: " + inversionCount(g));
	}

}
