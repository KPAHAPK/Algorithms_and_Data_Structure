import java.util.*;

class Cat {
    private String name;
    private String color;


    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void getInfo() {
        System.out.println("Name: " + name + " Color: " + color);
    }

    public void getName() {
        System.out.println("Name: " + name);
    }

    public void getColor() {
        System.out.println("Color: " + color);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Link<T> {
    private T link;
    private Link<T> next;

    public Link(T link) {
        this.link = link;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getValue() {
        return link;
    }
}

class MyLinkedList<T> {
    private Link<T> first;

    public MyLinkedList() {
        first = null;
    }

    public void insert(T link) {
        Link<T> lnk = new Link<>(link);
        lnk.setNext(first);
        this.first = lnk;
    }

    public void delete() {
        Link<T> temp = first;
        first = first.getNext();
    }

    public void display() {
        Link<T> current = first;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public T find(T searchElement) {
        Link<T> findElement = new Link<>(searchElement);
        Link<T> current = first;
        while (current != null) {
            if (current.getValue().equals(findElement.getValue())) {
                return findElement.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}

public class MainClass<T> {
    T[] arrayT;
    static Random random = new Random();

    public static void main(String[] args) {
        int[] array;
        int arrayLength = 20;
        array = new int[arrayLength];
        int temp;
        int key = random.nextInt(arrayLength);

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int randomTemp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            randomTemp = random.nextInt(arrayLength);
            array[i] = array[randomTemp];
            array[randomTemp] = temp;
        }

        System.out.println("Array: " + Arrays.toString(array));

        Integer[] arrayCopy = new Integer[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arrayCopy[i] = Integer.valueOf(array[i]);
        }
        //region 3.1
        System.out.println("---------------3.1-------------------------");
        long t = System.nanoTime();
        ArrayList<Integer> intArrayList = new ArrayList<>(Arrays.asList(arrayCopy));
        long tEnd = System.nanoTime() - t;
        System.out.println("ArrayList: " + intArrayList);
        System.out.println("Time to transform array to ArrayList: " + tEnd + "нс");
        //endregion

        //region 3.2
        System.out.println("---------------3.2-------------------------");

        t = System.nanoTime();
        intArrayList.add(88);
        tEnd = System.nanoTime() - t;
        System.out.println("ArrayList: " + intArrayList);
        System.out.println("Time to add element to the end of ArrayList: " + tEnd + "нс\n");

        t = System.nanoTime();
        intArrayList.remove(intArrayList.size() - 1);
        tEnd = System.nanoTime() - t;
        System.out.println("ArrayList: " + intArrayList);
        System.out.println("Time to remove element from the end of ArrayList: " + tEnd + "нс\n");


        Integer randomIndex = random.nextInt(intArrayList.size());
        System.out.println(randomIndex);
        t = System.nanoTime();
        intArrayList.add(randomIndex, 99);
        tEnd = System.nanoTime() - t;
        System.out.println("ArrayList: " + intArrayList);
        System.out.println("Time to add element to the random place of ArrayList: " + tEnd + "нс\n");

        t = System.nanoTime();
        intArrayList.remove((int) randomIndex);
        tEnd = System.nanoTime() - t;
        System.out.println(randomIndex);
        System.out.println("ArrayList: " + intArrayList);
        System.out.println("Time to remove element from the random place of ArrayList: " + tEnd + "нс\n");


        int elementFromArrayList;
        t = System.nanoTime();
        elementFromArrayList = intArrayList.get(randomIndex);
        tEnd = System.nanoTime() - t;
        System.out.println("ArrayList: " + intArrayList);
        System.out.println("Element from ArrayList: " + elementFromArrayList + " (index: " + randomIndex + ")");
        System.out.println("Time to get number from the random place of ArrayList: " + tEnd + "нс\n");
        //endregion

        //region 3.3
        System.out.println("---------------3.3-------------------------");

        MyLinkedList<Integer> numbers = new MyLinkedList<>();

        numbers.insert(1);
        numbers.insert(2);
        numbers.insert(3);
        numbers.insert(4);

        numbers.display();

        numbers.delete();

        numbers.display();

        System.out.println(numbers.find(2));
        System.out.println(numbers.find(4));

        //endregion

        //region 3.4
        System.out.println("---------------3.4-------------------------");

        LinkedList<Integer> linkedList = new LinkedList<Integer>(intArrayList);

        System.out.println("LinkedList: " + linkedList);

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.add(2, 99);
        System.out.println("LinkedList: " + linkedList);
        linkedList.set(4, 88);
        System.out.println("LinkedList: " + linkedList);

        linkedList.remove();
        System.out.println("LinkedList: " + linkedList);
        linkedList.remove(15);
        System.out.println("LinkedList: " + linkedList);
        linkedList.removeLast();
        System.out.println("LinkedList: " + linkedList);
        linkedList.removeFirst();
        System.out.println("LinkedList: " + linkedList);

        linkedList.addFirst(0);
        linkedList.addLast(100);
        System.out.println("LinkedList: " + linkedList);

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());

        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.pollLast());

        System.out.println("LinkedList: " + linkedList);

        if (linkedList.contains(3)) {
            System.out.println("LinkedList contains 3");
        }

        Cat cat1 = new Cat("Barsik", "White");
        Cat cat2 = new Cat("Murzik", "Black");
        Cat cat3 = new Cat("Boris", "Grey");

        LinkedList<Cat> cats = new LinkedList<>();

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        for (Cat a :
                cats) {
            a.getInfo();
        }

        cats.remove();

        System.out.println(cats);

        cats.add(new Cat("Vasiliy", "Red"));

        cats.get(1).getInfo();

        cats.set(1, new Cat("Masha", "Pointed"));
        for (Cat a :
                cats) {
            a.getInfo();
        }


        //endregion

        //region 3.5
        System.out.println("---------------3.5-------------------------");

        Iterator<Integer> iter = linkedList.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
            iter.remove();
        }
        System.out.println();
        System.out.println(iter);
        System.out.println(linkedList);

        ListIterator<Cat> iter1 = cats.listIterator();

        System.out.println("Down:");
        while (iter1.hasNext()) {
            iter1.next().getInfo();
        }

        System.out.println("Up:");
        while (iter1.hasPrevious()) {
            iter1.previous().getInfo();
            iter1.set(new Cat("Mozart", "Striped"));
        }

        System.out.println();
        for (Cat a :
                cats) {
            a.getInfo();
        }
        //endregion

    }


}
