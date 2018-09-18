package selenium_test;

import java.util.Arrays;

public class LargestSmallest {

	public static void main(String[] args) {
		int[] arr={34,56,-44,89,345,2,6,1,31};
		int largest=arr[0];
		int smallest=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>largest){
				largest=arr[i];
			}
			else if(arr[i]<smallest){
				smallest=arr[i];
			}
		}
		System.out.println("Arry is:"+Arrays.toString(arr));
		System.out.println("Largest is"+largest);
		System.out.println("Smallest is"+smallest);

	}

}
