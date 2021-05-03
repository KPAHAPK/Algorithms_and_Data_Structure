//        Задание 2.1
//        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
//        Выполните обращение к массиву и базовые операции класса Arrays.
//        Оценить выполненные методы с помощью базового класса System.nanoTime().
//        Задание 2.2
//        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
//        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.
//        Задание 2.3
//
//        Создайте массив размером 400 элементов.
//        Выполните сортировку с помощью метода sort().
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Задание 2.4
//        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
//        Задание 2.5
//        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
//        Задание 2.6
//        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
//        Оцените сортировку с помощью базового класса System.nanoTime().
//        Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.

import java.util.Arrays;
import java.util.Random;

public class MainClass {

    static Random random = new Random();

    public static void main(String[] args) {
        int[] array;
        int[] arrayCopy;
        int arrayLength = 400;
        array = new int[arrayLength];
        int temp;
        int key = random.nextInt(arrayLength);

        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }

        int randomTemp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            randomTemp = random.nextInt(arrayLength);
            array[i] = array[randomTemp];
            array[randomTemp] = temp;
        }

        //region2.1
        System.out.println("--------2.1--------");
        long t1 = System.nanoTime();
        arrayCopy = Arrays.copyOf(array,arrayLength);
        long t1End = System.nanoTime() - t1;
        System.out.println("Copy time: " + t1End  + " нс");
        System.out.println();

        long t2 = System.nanoTime();
        System.out.println("Array: " + Arrays.toString(array));
        long t2End = System.nanoTime() - t2;
        System.out.println("toString time: " + t2End  + " нс");
        System.out.println();
        //endregion
        //region 2.2
        System.out.println("--------2.2--------");

        System.out.println("Find: " + key);
        System.out.println();

        //Линейный
        int linearSearchResult;
        long t4 = System.nanoTime();
        linearSearchResult = linearSearch(array, key);
        long t4End = System.nanoTime() - t4;
        System.out.println("Success: " + linearSearchResult);
        System.out.println("Linear search time: " + t4End  + " нс");
        System.out.println();

        //Бинарный
        int binarySearchResult;
        int[] arrayCopyForBinarySearch = Arrays.copyOf(arrayCopy, arrayLength);
        Arrays.sort(arrayCopyForBinarySearch);
        long t5 = System.nanoTime();
        binarySearchResult = binarySearch(arrayCopyForBinarySearch, key);
        long t5End = System.nanoTime() - t5;
        System.out.println("Success: " + binarySearchResult);
        System.out.println("Binary search time: " + t5End);
        System.out.println();
        //endregion
        //region 2.3
        System.out.println("--------2.3--------");
        System.out.println("Array: " + Arrays.toString(arrayCopy));
        long t6 = System.nanoTime();
        Arrays.sort(arrayCopy);
        long t6End = System.nanoTime() - t6;
        System.out.println("Sorted array: " + Arrays.toString(arrayCopy));
        System.out.println("Qsort time: " + t6End  + " нс");
        System.out.println();
        //endregion
        //region 2.4
        System.out.println("--------2.4--------");
        int[] bubbleSortResult = Arrays.copyOf(array, arrayLength);
        System.out.println("Array: " + Arrays.toString(bubbleSortResult));
        long t7 = System.nanoTime();
        bubbleSort(bubbleSortResult);
        long t7End = System.nanoTime() - t7;
        System.out.println("Sorted array: " + Arrays.toString(bubbleSortResult));
        System.out.println("Bubble sort time: " + t7End + " нс");
        float time1 = (float) t7End/t6End;
        System.out.printf("Sort() is %.2f times quicker then bubble sort.\n", time1);
        System.out.println();

        //endregion
        //region 2.5
        System.out.println("--------2.5--------");
        int[] selectionSortResult = Arrays.copyOf(array, arrayLength);
        System.out.println("Array: " + Arrays.toString(selectionSortResult));
        long t8 = System.nanoTime();
        selectionSort(selectionSortResult);
        long t8End = System.nanoTime() - t8;
        System.out.println("Sorted array: " + Arrays.toString(selectionSortResult));
        System.out.println("Selection sort time: " + t8End  + " нс");
        time1 = (float) t8End/t6End;
        System.out.printf("Sort() is %.2f times quicker then selection sort.\n", time1);
        float time2 = (float) t7End/t8End;
        System.out.printf("Selection sort is %.2f times quicker then bubble sort.\n", time2);
        System.out.println();
        //endregion
        //region 2.6
        System.out.println("--------2.6--------");
        int[] insertionSortResult = Arrays.copyOf(array, arrayLength);
        System.out.println("Array: " + Arrays.toString(insertionSortResult));
        long t9 = System.nanoTime();
        insertionSort(insertionSortResult);
        long t9End = System.nanoTime() - t9;
        System.out.println("Sorted array: " + Arrays.toString(selectionSortResult));
        System.out.println("Selection sort time: " + t9End  + " нс");
        time1 = (float) t9End/t6End;
        System.out.printf("Sort() is %.2f times quicker then insertion sort.\n", time1);
        time2 = (float) t7End/t9End;
        System.out.printf("Insertion sort is %.2f times quicker then bubble sort.\n",  time2);
        float time3 = (float) t8End/t9End;
        System.out.printf("Insertion sort is %.2f times quicker then selection sort.\n", time3);
        //endregion
    }

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int key){
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int middle;
        while (firstIndex <= lastIndex){
            middle = (lastIndex + firstIndex) / 2;

            if (array[middle] == key){
                return middle;
            }
            else if (array[middle] > key) {
                lastIndex = middle - 1;
            }
            else {
                firstIndex = middle + 1;
            }
        }
        return -1;
    }

    public static void  swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void bubbleSort(int[] arr){
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++){
                if (arr[i] > arr[i + 1]){
                    sorted = false;
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int pos = i;
            while (pos > 0 && arr[pos - 1] >= temp){
                arr[pos] = arr[pos - 1];
                --pos;
            }
            arr[pos] = temp;
        }
    }

}
