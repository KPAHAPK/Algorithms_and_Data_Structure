import java.util.Arrays;
import java.util.Random;

class Item{
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey(){
        return this.data;
    }
}

class HashTable{
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable(int size){
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);

    }

    public int hashFunc(int key){
        return key % arrSize;
    }
    public int hashFuncDouble(int key){
        return 5 - key % 5;
    }

    public void insert(Item item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int step = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1){
            hashVal += step;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key){
     int hashVal = hashFunc(key);
     int step = hashFuncDouble(key);
     while (hashArr[hashVal] != null){
         if (hashArr[hashVal].getKey() == key){
             Item temp = hashArr[hashVal];
             hashArr[hashVal] = nonItem;
             return temp;
         }
         hashVal += step;
         hashVal %= arrSize;
     }
     return null;
    }

    public Item find(int key){
        int hashVal = hashFunc(key);
        int step = hashFuncDouble(key);
        while (hashArr[hashVal] != null){
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            hashVal += step;
            hashVal %= arrSize;
        }
        return null;
    }

    public void display(){
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null){
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }
    private int getPrime(int min){
        for(int i = min +1; true; i++){
            if (isPrime(i)){
                return i;
            }
        }
    }

    private boolean isPrime(int n){
        for (int j = 2; j*j <= n; j++){
            if (n % j == 0){
                return true;
            }
        }
        return false;
    }

}

public class Main {

    public static void main(String[] args) {
        int size = 66;
        Item data;
        int key;


        HashTable hashTable = new HashTable(size);
        Random  random = new Random();

        for (int i = 0; i < 15; i++) {
            key = random.nextInt(999);
            data = new Item(key);
            hashTable.insert(data);
        }

        hashTable.display();

        hashTable.insert(new Item(111));
        hashTable.insert(new Item(222));
        hashTable.delete(222);
        System.out.println("*******************");
        hashTable.display();
        System.out.println("*******************");
        System.out.println(hashTable.find(111).getKey());

        int[] array = new int[10];
        for (int z : array)
            if (z  == 0)
                System.out.println("*");

        }



}
