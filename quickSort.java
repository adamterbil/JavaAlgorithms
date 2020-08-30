package assign5;

import java.util.Random;

public class quickSort {
	
	//RANDOMIZED QUICKSORT
	
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
		int k = i + rand.nextInt(j-i);
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

	
	public static void quicksort(int a[], int i, int j){
        if (i < j){
            int p = randomPartition(a, i, j);
            quicksort(a, i, p-1);
            quicksort(a, p+1, j);
        }
    }

	public static void main(String[] args) {	
		//TEST TO MAKE SURE QUICKSORT WORKS
		/*int numArray[] = new int[10];
		for(int i = 0; i < numArray.length; i++){
			numArray[i] = randInt(0, 100);
		}
		
		System.out.println("Unordered Array: ");
		for(int x : numArray){
			System.out.println(x);
		}
		
		quicksort(numArray, 0, numArray.length-1);
		
		System.out.println("Ordered Array: ");
		for(int y : numArray){
			System.out.println(y);
		}*/
		
		
		int numbers[] = new int[100000];
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = randInt(-1000000, 1000000);
		}
		
		long startTime = System.currentTimeMillis();
		quicksort(numbers, 0, numbers.length-1);
		long endTime = System.currentTimeMillis();
		System.out.println("The time it took to sort the the array in milliseconds: " + (endTime-startTime));
		
		long startTime2 = System.currentTimeMillis();
		quicksort(numbers, 0, numbers.length-1);
		long endTime2 = System.currentTimeMillis();
		System.out.println("The time it took to sort the the array in milliseconds a second time: " + (endTime2-startTime2));
	}

}
