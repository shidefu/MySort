public class MyHeapSort {

	public static void main(String[] args) {
		int[] array = { 5, 3, 9, 1, 0, 4, 7, 2, 6, 8 };
		heapSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void heapSort(int[] array) {
		maxHeap(array);
		for (int i = array.length - 1; i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			adjustHeap(array, 0, i);
		}
	}

	public static void maxHeap(int[] array) {
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			adjustHeap(array, i, array.length);
		}
	}

	public static void adjustHeap(int[] array, int begin, int end) {
		int temp = array[begin];
		for (int child = 2 * begin + 1; child < end; child = 2 * child + 1) {
			if (child < end - 1 && array[child] < array[child + 1])
				child++;
			if (array[child] <= temp)
				break;
			else {
				array[begin] = array[child];
				begin = child;
			}
		}
		array[begin] = temp;
	}

}
