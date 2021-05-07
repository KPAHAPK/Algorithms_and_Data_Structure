import java.util.Arrays;
import java.util.Random;

/*
        Задание 5.1
        Приведите пример использования рекурсии.
        Задание 5.2
        Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
        Задание 5.3
        Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        Задание 5.4
        Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        Оцените два алгоритма с помощью базового метода System.nanoTime().
        Задание 5.5
        Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.
        Задание 5.6
        На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
        Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().

*/
public class MainClass {
    private static long t1;
    private static long t2;
    private static long dt;

    public static void main(String[] args) {
        //region5.1
        System.out.println("--------------------5.1---------------------");
        System.out.println("Пример рекурсии - поиск факториала.");
        //endregion

        //region5.2
        System.out.println("--------------------5.2---------------------");
        System.out.print("Infinity recursion ");
        boolean recursiveRun = false;
        if (recursiveRun) {
            System.out.println("run.");
            infinity(100000000);
        }else {
            System.out.println("didn't run.(recursiveRun = true to run infinity recursion).");
        }



        System.out.println(factorial(5));
        //endregion

        //region5.3
        System.out.println("--------------------5.3---------------------");
        System.out.println("Basic call stack:");
        System.out.println("Call: main -> a(x)(return b(x)) -> b(x)(return c(x)) -> c(x)(return d(x)) -> ..... -> n(x)(return x).");
        System.out.println("Return: main <- a(x)(return b(x)) <- b(x)(return c(x)) <- c(x)(return d(x)) <- ..... <- n(x)(return x).");
        System.out.println();
        System.out.println("Recursive call stack:");
        System.out.println("Call: main -> a(x)(return a(x-1)) -> a(x-1)(return a(x-2)) -> a(x-2)(return a(x-3)) -> ..... -> a(x-n)(return).");
        System.out.println("Return: main <- a(x)(return a(x-1)) <- a(x-1)(return a(x-2)) <- a(x-2)(return a(x-3)) <- ..... <- a(x-n)(return).");
        //endregion

        //region5.4
        System.out.println("--------------------5.4---------------------");
        int n = 13;
        int result = 1;
        System.out.println(n + "! = ?");

        t1 = System.nanoTime();
        result = factorial(n);
        t2 = System.nanoTime();
        dt = t2 -t1;
        System.out.printf("\nRecursion time: %.2f ns\n", (float) dt);
        System.out.println(n + "! = " + result);

        result = 1;
        t1 = System.nanoTime();
        for (int i = 1; i <= n; i ++){
            result *= i;
        }
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("\n\"For\" cycle time: %.2f ns\n", (float) dt);
        System.out.println(n + "! = " + result);

        t1 = System.nanoTime();
        int j = 1;
        result = 1;
        while(j <= n){
            result *= j;
            j++;
        }
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("\n\"While\" cycle time: %.2f ns\n", (float) dt);
        System.out.println(n + "! = " + result);

        //endregion

        //region5.5
        System.out.println("--------------------5.5---------------------");
        Random random = new Random();
        int[] array;
        int arrayLength = random.ints(15, 30).findFirst().getAsInt();
        array = new int[arrayLength];
        int key = random.nextInt(arrayLength);

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Key: " + key);

        System.out.println("Key index: " + recursiveBinarySearch(array, 0, array.length - 1, key));

        System.out.println();
        key = arrayLength + 1;
        t1 = System.nanoTime();
        result = recursiveBinarySearch(array, 0, array.length - 1, key);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.println("Key: " + key);
        System.out.println("Key index: " + result);

        System.out.println();
        key = - array.length;
        System.out.println("Key: " + key);
        System.out.println("Key index: " + recursiveBinarySearch(array, 0, array.length - 1, key));

        System.out.printf("\nRecursive binarySearch: %.2f ns\n", (float) dt);

        t1 = System.nanoTime();
        cyclicBinarySearch(array, key);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Cyclic binarySearch: %.2f ns\n", (float) dt);
        //endregion

        //region5.6
        System.out.println("--------------------5.6---------------------");

        //endregion
    }

    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        return (factorial(n-1)*n);
    }

    public static void infinity(int n){
        System.out.println((double) n);
        infinity(n / 5000 * 4999);
    }

     public static int recursiveBinarySearch(int[] array, int lowIndex, int highIndex, int key){
        if (lowIndex > highIndex){
            return array.length;
        }

        if (key < array[lowIndex] || key > array[highIndex]){
            return -1;
        }

         int middleIndex = (highIndex + lowIndex) / 2;

         if (key == array[middleIndex]){
            return middleIndex;
        } else if (key > array[middleIndex]){
            return recursiveBinarySearch(array, middleIndex + 1, highIndex, key);
        }else {
            return recursiveBinarySearch(array, lowIndex, middleIndex - 1, key);
        }
    }

    public static int cyclicBinarySearch(int[] array, int key){
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


}


