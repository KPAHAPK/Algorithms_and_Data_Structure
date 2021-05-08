import java.util.Arrays;
import java.util.Random;

class HeapSort {

    private static int heapSize;

    public static void sort(int[] array) {
        buildHeap(array);
        while (heapSize > 1){
            swap(array, 0, heapSize -1);
            heapSize--;
            heapify(array, 0);
        }
    }

    public static void buildHeap(int[] array) {
        heapSize = array.length;
        for (int i = array.length / 2; i >= 0; i--) {
            heapify(array, i);
        }
    }

    public static void heapify(int[] array, int i) {
        int right = right(i);
        int left = left(i);
        int largest = i;

        if (left < heapSize && array[i] < array[left]) {
            largest = left;
        }
        if (right < heapSize && array[largest] < array[right]) {
            largest = right;
        }
        if (i != largest) {
            swap(array, i, largest);
            heapify(array, largest);
        }
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

public class Main{
    static long t1;
    static long t2;
    static long dt;

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(20);
        }

        System.out.println(Arrays.toString(array));

        int[] arrayCopy = Arrays.copyOf(array, array.length);

        t1 = System.nanoTime();
        HeapSort.sort(array);
        t2 =System.nanoTime();
        dt = t2 - t1;
        System.out.println(Arrays.toString(array));
        System.out.printf("\nHeapSort time: %.2f ns\n", (float) dt);

        t1 = System.nanoTime();
        Arrays.sort(arrayCopy);
        t2 =System.nanoTime();
        dt = t2 - t1;
        System.out.printf("\nQSort time: %.2f ns\n", (float) dt);

    }

}
