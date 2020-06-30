
public class FindNum {
	public static void main(String[] args) {
		int[] arr = {2,2,3,3,3,2,2,2,3};
		int[] arr2 = findNum(arr, 0, arr.length);
		System.out.println(arr2[0]+" "+arr2[1]);
	}
	
	public static int[] findNum(int[] arr, int low, int high){
		int[] arr2 = {0,0};
		if(low>=high-1){
			arr2[0] = arr[low];
			arr2[1] = 1;
			System.out.print("Base:");print(arr2);
			return arr2;
		}
		int[] arrL = {0,0};
		int[] arrR = {0,0};
		int mid = (low+high)/2;
		System.out.println("low: "+low+", high: "+high+", mid: "+mid);
		for(int i=low+1; i<high; i++){
			if(arr[i]!=arr[i-1]){
				arrL = findNum(arr, low, mid);
				arrR = findNum(arr, mid, high);
				break;
			}
			else if(arr[i]==arr[i-1]&&i==high-1){
				arr2[0] = arr[i];
				arr2[1] = high-low;
				System.out.print("AllSame: ");print(arr2);
				return arr2;

			}
		}
//		System.out.print("L: ");print(arrL);
//		System.out.print("R: ");print(arrR);
		if(arrL[1]>arrR[1])
			arr2 = arrL;
		else
			arr2 = arrR;
		
		System.out.print("arr2: ");print(arr2);
		return arr2;
	}
		
	
	public static void print(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(i==0? "{"+arr[i]: ", "+arr[i]);
		System.out.println("}");
	}
}
