
public class SecondMax {
	public static void main(String[] args) {
		int[] arr = {1,5,9,7,3,4,12,11,2};
		int[] arr2 = max(arr);
		System.out.println(arr2[1]);
	}
	
	public static void print(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(i==0? "{"+arr[i]: ", "+arr[i]);
		System.out.println("}");
	}
	
	public static int[] max(int[] arr){
		int n = arr.length;
		int[] info = new int[3];
		if(n==2){
			if(arr[0]>arr[1]){
				info[0] = arr[0];
				info[1] = arr[1];
				info[2] = 0;
			}
			else{
				info[0] = arr[1];
				info[1] = arr[0];
				info[2] = 1;
			}
			return info;
		}
		int n2 = n/2;
		int[] arr2 = new int[n2+(n&1)];
		for(int i=0; i<n2; i++)
			arr2[i] = Math.max(arr[2*i], arr[2*i+1]);
		if((n&1)==1)arr2[n2] = arr[n-1];
		info = max(arr2);
		return max2(arr, info);
	}
	
	private static int[] max2(int[] arr, int[] info){
		info[2]*=2;
		if(arr[info[2]]==info[0])
			info[1] = Math.max(info[1], arr[info[2]+1]);
		else
			info[1] = Math.max(info[1], arr[info[2]++]);
		return info;
	}
	
	
//	public static int max(int[] arr){
//		int n = arr.length;
//		if(n==2) return Math.max(arr[0], arr[1]);
//		
//		int n2 = n/2;
//		int[] arr2 = new int[n2+(n&1)];
//		for(int i=0; i<n2; i++)
//			arr2[i] = Math.max(arr[2*i], arr[2*i+1]);
//		if((n&1)==1)arr2[n2] = arr[n-1];
//		return max(arr2);
//	}
}
