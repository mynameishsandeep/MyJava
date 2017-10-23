
/*
 * 1) Since the array is sorted. At any point, if split the array, one side is sorted and other is not sorted.
 * 2) Find the sorted side by formula: a[low]<=a[mid]---if true left is sorted, else right side is sorted.
 * 3) Then do binary search from sorted side...If element is not found do binary search for the unsorted side ...
 */
public class FindElementInSortedRotatedArray {
	// Returns index of key in arr[l..h]
	// if key is present, otherwise returns -1
	static int search(int arr[], int l, int h, int key) {
		if (l > h)
			return -1;

		int mid = (l + h) / 2;
		if (arr[mid] == key)
			return mid;

		/* If arr[l...mid] is sorted */
		if (arr[l] <= arr[mid]) {
			/*
			 * As this subarray is sorted, we can quickly check if key lies in
			 * half or other half
			 */
			if (key >= arr[l] && key <= arr[mid])
				return search(arr, l, mid - 1, key);

			return search(arr, mid + 1, h, key);
		}

		/*
		 * If arr[l..mid] is not sorted, then arr[mid... r] must be sorted
		 */
		if (key >= arr[mid] && key <= arr[h])
			return search(arr, mid + 1, h, key);

		return search(arr, l, mid - 1, key);
	}

	// main function
	public static void main(String args[]) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 6;
		int i = search(arr, 0, n - 1, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}
}
