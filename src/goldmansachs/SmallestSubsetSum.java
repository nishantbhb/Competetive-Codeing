package goldmansachs;

public class SmallestSubsetSum {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 45, 6, 10, 19 };
		int x = 51;
		int n = arr.length;
		int min_length = n;
		int curr_sum = 0;
		int start = 0;
		int end = 0;
		while (end < n) {

			while (curr_sum <= x && end < n) {
				// Ignore subarrays with negative sum if
				// x is positive.
				if (curr_sum <= 0 && x > 0) {
					start = end;
					curr_sum = 0;
				}

				curr_sum += arr[end++];
			}

			while (curr_sum > x && end < n) {
				if (min_length > end - start)
					min_length = end - start;
				curr_sum -= arr[start++];
			}
		}
		System.out.println(min_length);
	}
}
