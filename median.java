package assign5;

import java.util.Random;

public class median {
	
	//***EXTRA CREDIT ANSWER: ****
	//If you remove half the water of a bucket that contains 1 liter every hour
	//The bucket will never be empty
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void swap(int a[], int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int randomPartition(int a[], int i, int j){
		Random rand = new Random();
		int k = i + rand.nextInt((j-i) + 1);
		swap(a, i, k);
		return partition(a, i, j);
	}
	
	public static int partition(int a[], int i, int j){
        int pivot = a[i];
        int h = i;
        for (int k=i+1; k<=j; k++){  
            if (a[k] < pivot){
                h++;
                swap(a,h,k);
            }
        }
        swap(a,i,h);
        return h;
    }
	
	public static int select(int a[], int k){
		int i = 0;
		int j = a.length-1;
		while(true){
			int p = randomPartition(a, i, j);
			if(p == k) return a[k];
			if(p > k) j = p-1;
			else i = p+1;
		}
	}
	
	public static int findMedian(int a[]){
		int median;
		if(a.length % 2 == 0){
			return(median = select(a, a.length/2) + select(a, (a.length/2)-1/2));
		}
		else{
			return(median = select(a, a.length/2));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TEST FOR MEDIAN
		/*int numbers[] = {2, 7, 3, 1, 9};
		System.out.println(findMedian(numbers));*/
		
		int numbers[] = new int[100000];
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = randInt(-1000000, 1000000);
		}
		
		System.out.println("The median of the numbers array is: " + findMedian(numbers));
	}

}
