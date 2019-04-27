
public class MyMergeSort {

	public static void main(String[] args) {
		int[] array = { 5, 3, 9, 1, 0, 4, 7, 2, 6, 8 };
		mergeSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void Merge(int[] array, int begin, int mid, int end) {
		int[] temp = new int[end - begin + 1];
		int i = begin;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (array[i] <= array[j])
				temp[k++] = array[i++];
			else
				temp[k++] = array[j++];
		}
		while (i <= mid) {
			temp[k++] = array[i++];
		}
		while (j <= end) {
			temp[k++] = array[j++];
		}
		for (int n = 0; n < temp.length; n++) {
			array[begin + n] = temp[n];
		}
	}

	public static void mergeSort(int[] array, int begin, int end) {
		int mid = (begin + end) >> 1;
		if (begin >= end)
			return;
		mergeSort(array, begin, mid);
		mergeSort(array, mid + 1, end);
		Merge(array, begin, mid, end);
	}
}
