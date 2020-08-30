package week2;
import java.util.Random;

public class Sorts {
	
	public static final int THRESHOLD = 33;
	
	public static void insertionSort(int a[], int low, int high){
		 for(int i = low + 1; i < high; i++){
			 int temp = a[i];
			 int j = i;
			 while((j > low) && (a[j-1] > temp)){
				 a[j] = a[j-1];
				 j--;
			 }
			 a[j] = temp;
		 }
	}
	
	public static void mergeSort(int f[],int lb, int ub){
	    if(lb+1<ub){
	        int mid = (lb+ub)/2;
	        mergeSort(f,lb,mid);
	        mergeSort(f,mid,ub);
	        merge(f,lb,mid,ub);
	    }
	}
	
	public static void hybridSort(int f[],int lb, int ub){
	    if (ub - lb <= THRESHOLD)
	        insertionSort(f, lb, ub);
	    else
	    {
	        int mid = (lb+ub)/2;
	        hybridSort(f,lb,mid);
	        hybridSort(f,mid,ub);
	        merge(f,lb,mid,ub);
	    }
	}
	
	public static void merge (int f[],int p, int q, int r){
	    
	    int i =p; int j = q; 
	   
	    int temp[] = new int[r-p]; int t = 0; 
	    while(i<q && j<r){
	        if(f[i]<=f[j]){
	            temp[t] =f[i]; 
	            i++;t++;
	        }
	        else{
	            temp[t] = f[j];
	            j++;
	            t++;
	        }

	        while(i<q){
	            temp[t] = f[i];
	            i++;
	            t++;

	        }
	        while(j<r){
	            temp[t]=f[j];
	            j++;
	            t++;
	        }
	        
	        i=p;t=0;
	        while(t<temp.length){
	            f[i]=temp[t];
	            i++;
	            t++;
	        }
	     }
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void main(String[] args) {
		// ***BENCHMARK TEST***
		//TEST FOR 1024 VALUES
		int array[] = new int[1024];
		int array_copy[] = new int[1024];
		
		for(int i = 0; i < array.length; i++){
			int r = randInt(-1000000, 1000000);
			array[i] = r; 
			array_copy[i] = r;
		}
		
		long startTime = System.currentTimeMillis();
		hybridSort(array_copy, 0, array_copy.length);
		long endTime = System.currentTimeMillis();
		System.out.println("hybridSort took " + (endTime - startTime) + " milliseconds on 1024 values.");
		
		int array2[] = new int[1024];
		int array_copy2[] = new int[1024];
		
		for(int i = 0; i < array2.length; i++){
			int r2 = randInt(-1000000, 1000000);
			array2[i] = r2; 
			array_copy2[i] = r2;
		}
		
		long startTime2 = System.currentTimeMillis();
		insertionSort(array_copy2, 0, array_copy2.length);
		long endTime2 = System.currentTimeMillis();
		System.out.println("insertionSort took " + (endTime2 - startTime2) + " milliseconds on 1024 values.");
		
		int array3[] = new int[1024];
		int array_copy3[] = new int[1024];
		
		for(int i = 0; i < array3.length; i++){
			int r3 = randInt(-1000000, 1000000);
			array3[i] = r3; 
			array_copy2[i] = r3;
		}
		
		long startTime3 = System.currentTimeMillis();
		mergeSort(array_copy3, 0, array_copy3.length);
		long endTime3 = System.currentTimeMillis();
		System.out.println("mergeSort took " + (endTime3 - startTime3) + " milliseconds on 1024 values.");
		
		System.out.println();
		
		//TEST FOR 4096 VALUES
		int array4[] = new int[4096];
		int array_copy4[] = new int[4096];
		
		for(int i = 0; i < array4.length; i++){
			int r = randInt(-1000000, 1000000);
			array4[i] = r; 
			array_copy4[i] = r;
		}
		
		long startTime4 = System.currentTimeMillis();
		hybridSort(array_copy4, 0, array_copy4.length);
		long endTime4 = System.currentTimeMillis();
		System.out.println("hybridSort took " + (endTime4 - startTime4) + " milliseconds on 4096 values.");
		
		int array5[] = new int[4096];
		int array_copy5[] = new int[4096];
		
		for(int i = 0; i < array5.length; i++){
			int r2 = randInt(-1000000, 1000000);
			array5[i] = r2; 
			array_copy5[i] = r2;
		}
		
		long startTime5 = System.currentTimeMillis();
		insertionSort(array_copy5, 0, array_copy5.length);
		long endTime5 = System.currentTimeMillis();
		System.out.println("insertionSort took " + (endTime5 - startTime5) + " milliseconds on 4096 values.");
		
		int array6[] = new int[4096];
		int array_copy6[] = new int[4096];
		
		for(int i = 0; i < array6.length; i++){
			int r6 = randInt(-1000000, 1000000);
			array6[i] = r6; 
			array_copy6[i] = r6;
		}
		
		long startTime6 = System.currentTimeMillis();
		mergeSort(array_copy6, 0, array_copy6.length);
		long endTime6 = System.currentTimeMillis();
		System.out.println("mergeSort took " + (endTime6 - startTime6) + " milliseconds on 4096 values.");
		
		System.out.println();
		
		//TEST FOR 16384 VALUES
		int array7[] = new int[16384];
		int array_copy7[] = new int[16384];
		
		for(int i = 0; i < array7.length; i++){
			int r = randInt(-1000000, 1000000);
			array7[i] = r; 
			array_copy7[i] = r;
		}
		
		long startTime7 = System.currentTimeMillis();
		hybridSort(array_copy7, 0, array_copy7.length);
		long endTime7 = System.currentTimeMillis();
		System.out.println("hybridSort took " + (endTime7 - startTime7) + " milliseconds on 16384 values.");
		
		int array8[] = new int[16384];
		int array_copy8[] = new int[16384];
		
		for(int i = 0; i < array8.length; i++){
			int r2 = randInt(-1000000, 1000000);
			array8[i] = r2; 
			array_copy8[i] = r2;
		}
		
		long startTime8 = System.currentTimeMillis();
		insertionSort(array_copy8, 0, array_copy8.length);
		long endTime8 = System.currentTimeMillis();
		System.out.println("insertionSort took " + (endTime8 - startTime8) + " milliseconds on 16384 values.");
		
		int array9[] = new int[16384];
		int array_copy9[] = new int[16384];
		
		for(int i = 0; i < array9.length; i++){
			int r6 = randInt(-1000000, 1000000);
			array9[i] = r6; 
			array_copy9[i] = r6;
		}
		
		long startTime9 = System.currentTimeMillis();
		mergeSort(array_copy9, 0, array_copy9.length);
		long endTime9 = System.currentTimeMillis();
		System.out.println("mergeSort took " + (endTime9 - startTime9) + " milliseconds on 16384 values.");
		
		System.out.println();
		
		//TEST FOR 65536 VALUES
		int array10[] = new int[65536];
		int array_copy10[] = new int[65536];
		
		for(int i = 0; i < array10.length; i++){
			int r = randInt(-1000000, 1000000);
			array10[i] = r; 
			array_copy10[i] = r;
		}
		
		long startTime10 = System.currentTimeMillis();
		hybridSort(array_copy10, 0, array_copy10.length);
		long endTime10 = System.currentTimeMillis();
		System.out.println("hybridSort took " + (endTime10 - startTime10) + " milliseconds on 65536 values.");
		
		int array11[] = new int[65536];
		int array_copy11[] = new int[65536];
		
		for(int i = 0; i < array11.length; i++){
			int r2 = randInt(-1000000, 1000000);
			array11[i] = r2; 
			array_copy11[i] = r2;
		}
		
		long startTime11 = System.currentTimeMillis();
		insertionSort(array_copy11, 0, array_copy11.length);
		long endTime11 = System.currentTimeMillis();
		System.out.println("insertionSort took " + (endTime11 - startTime11) + " milliseconds on 65536 values.");
		
		int array12[] = new int[65536];
		int array_copy12[] = new int[65536];
		
		for(int i = 0; i < array12.length; i++){
			int r6 = randInt(-1000000, 1000000);
			array12[i] = r6; 
			array_copy12[i] = r6;
		}
		
		long startTime12 = System.currentTimeMillis();
		mergeSort(array_copy12, 0, array_copy12.length);
		long endTime12 = System.currentTimeMillis();
		System.out.println("mergeSort took " + (endTime12 - startTime12) + " milliseconds on 65536 values.");
		
		System.out.println();
		
		//TEST FOR 262144 VALUES
		int array13[] = new int[262144];
		int array_copy13[] = new int[262144];
		
		for(int i = 0; i < array13.length; i++){
			int r = randInt(-1000000, 1000000);
			array13[i] = r; 
			array_copy13[i] = r;
		}
		
		long startTime13 = System.currentTimeMillis();
		hybridSort(array_copy13, 0, array_copy13.length);
		long endTime13 = System.currentTimeMillis();
		System.out.println("hybridSort took " + (endTime13 - startTime13) + " milliseconds on 262144 values.");
		
		int array14[] = new int[262144];
		int array_copy14[] = new int[262144];
		
		for(int i = 0; i < array14.length; i++){
			int r2 = randInt(-1000000, 1000000);
			array14[i] = r2; 
			array_copy14[i] = r2;
		}
		
		long startTime14 = System.currentTimeMillis();
		insertionSort(array_copy14, 0, array_copy14.length);
		long endTime14 = System.currentTimeMillis();
		System.out.println("insertionSort took " + (endTime14 - startTime14) + " milliseconds on 262144 values.");
		
		int array15[] = new int[262144];
		int array_copy15[] = new int[262144];
		
		for(int i = 0; i < array15.length; i++){
			int r6 = randInt(-1000000, 1000000);
			array15[i] = r6; 
			array_copy15[i] = r6;
		}
		
		long startTime15 = System.currentTimeMillis();
		mergeSort(array_copy15, 0, array_copy15.length);
		long endTime15 = System.currentTimeMillis();
		System.out.println("mergeSort took " + (endTime15 - startTime15) + " milliseconds on 262144 values.");
	}
}
