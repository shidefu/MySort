
public class MyQuickSort {

	public static void main(String[] args) {
		int[] array = { 5, 3, 9, 1, 0, 4, 7, 2, 6, 8 };
		quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static int Partition(int[] array, int begin, int end) {
		int pivot = array[begin];
		int i = begin;
		int j = end;
		while (i < j) {
			while (i < j && array[j] >= pivot)
				j--;
			while (i < j && array[i] <= pivot)
				i++;
			swap(array, i, j);
		}
		swap(array, begin, j);
		return j;

	}

	public static void quickSort(int[] array, int begin, int end) {
		if (begin >= end)
			return;
		int mid = Partition(array, begin, end);
		quickSort(array, begin, mid - 1);
		quickSort(array, mid + 1, end);
	}

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}