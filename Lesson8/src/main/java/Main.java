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

    public void insert(Item item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1){
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key){
     int hashVal = hashFunc(key);
     while (hashArr[hashVal] != null){
         if (hashArr[hashVal].getKey() == key){
             Item temp = hashArr[hashVal];
             hashArr[hashVal] = nonItem;
             return temp;
         }
         ++hashVal;
         hashVal %= arrSize;
     }
     return null;
    }

    public Item find(int key){
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null){
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            ++hashVal;
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
    }



}
