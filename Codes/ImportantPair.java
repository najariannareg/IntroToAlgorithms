//import java.util.Arrays;

public class ImportantPair {
	public static void main(String[] args) {
		int[] arr = {35,24,6,8,62,16,11,1};
		System.out.println(importantPair(arr, 0));
	}
	
	public static int importantPair(int[] S, int count) {
		int n = S.length;
		if (n < 2) return count;
		int mid = n/2;
		
		//int[] S1 = Arrays.copyOfRange(S, 0, mid);
		//int[] S2 = Arrays.copyOfRange(S, mid, n);
		int[] S1 = new int[mid];
		int[] S2 = new int[n-mid];
		for(int i=0; i<S1.length; i++)
			S1[i] = S[i];
		for(int i=0; i<S2.length; i++)
			S2[i] = S[i+mid];
		
		int c1 = importantPair(S1, count);
		int c2 = importantPair(S2, count);
		return merge(S1, S2, S, count) + c1 + c2;
	}
	
	public static int merge(int[] S1, int[] S2, int[] S, int count) {
		int i = 0, j = 0;
		while (i + j < S.length) {
			if (j == S2.length || (i < S1.length && S1[i] > 2*S2[j])){
				S[i+j] = S1[i++];
				count += S2.length - j;
			}
			else if (j == S2.length || (i < S1.length && S1[i] > S2[j]))
				S[i+j] = S1[i++];
			else
				S[i+j] = S2[j++];
		}
		return count;
	}
}
