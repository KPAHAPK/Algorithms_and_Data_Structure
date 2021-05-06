import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void printName() {
        System.out.println("Name: " + name);
    }

    public String getName() {
        return name;
    }

    public void getColor() {
        System.out.println("Color: " + color);
    }

    public String  printColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

public class MainClass {

    static long t1;
    static long t2;
    static long dt;

    public static void main(String[] args) {

        //region4.1
        System.out.println("------------------4.1------------------------");
        Cat cat1 = new Cat("Barsik", "White");
        Cat cat2 = new Cat("Murzik", "Black");
        Cat cat3 = new Cat("Boris", "Grey");
        Cat cat4 = new Cat("Vasiliy", "Red");
        Cat cat5 = new Cat("Masha", "Pointed");


        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);

        Stack<Cat> stCats = new Stack<>();

        t1 = System.nanoTime();
        stCats.addAll(cats);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to addAll: %.2f\n\n", (float) dt);




        System.out.print("Pop: ");
        t1 = System.nanoTime();
        stCats.pop();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to pop: %.2f\n\n", (float) dt);


        System.out.print("Peek: ");
        t1 = System.nanoTime();
        stCats.peek();
        t2 = System.nanoTime();
        dt = t2 - t1;
        stCats.peek().getInfo();
        System.out.printf("Time to peek: %.2f\n\n", (float) dt);

        System.out.print("Push: ");
        t1 = System.nanoTime();
        stCats.push(cat5);
        t2 = System.nanoTime();
        dt = t2 - t1;
        stCats.peek().getInfo();
        System.out.printf("Time to push: %.2f\n\n", (float) dt);

        int search;
        t1 = System.nanoTime();
        search = stCats.search(cat2);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.println(cat2.getName() + " index: " + search);
        System.out.printf("Time to search: %.2f\n\n", (float) dt);

        System.out.println("Stack is Empty? " + stCats.empty());
        //endregion

        //region 4.2
        System.out.println("------------------4.2------------------------");

        Queue<Cat> qCats = new LinkedList<>();


        t1 = System.nanoTime();
        qCats.add(cat1);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to add: %.2f\n\n", (float) dt);

        qCats.add(cat2);
        qCats.add(cat3);
        qCats.add(cat4);

        t1 = System.nanoTime();
        qCats.remove();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to remove: %.2f\n\n", (float) dt);

        t1 = System.nanoTime();
        qCats.peek();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to peek: %.2f\n\n", (float) dt);

        t1 = System.nanoTime();
        qCats.offer(cat5);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to offer: %.2f\n\n", (float) dt);

        t1 = System.nanoTime();
        qCats.poll();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to poll: %.2f\n\n", (float) dt);

        while (!qCats.isEmpty()){
            System.out.println(qCats.poll().getName());
        }
        //endregion

        //region 4.3
        System.out.println("------------------4.3------------------------");

        //endregion

        //region 4.4
        System.out.println("------------------4.4------------------------");

        //endregion

        //region 4.5
        System.out.println("------------------4.5------------------------");

        //endregion
    }
}
