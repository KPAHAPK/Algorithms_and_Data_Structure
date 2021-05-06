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

class MyStack{
    private int maxSize;
    private int top;
    private int[] stack;

    public MyStack(int size){
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }
    public void push(int element){
        stack[++top] = element;
    }

    public int pop(){
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize;
    }
}

class MyQueue{
    private int[] queue;
    private int maxSize;
    private int front;
    private int rear;
    private int items;

    public MyQueue(int size){
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void push(int element){
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = element;
        items++;
    }

    public int pop(){
        int temp = queue[front++];
        if (front == maxSize){
            front = 0;
        }
        items--;
        return temp;
    }

    public int peek(){
        return queue[front];
    }

    public boolean isEmpty(){
        return items == 0;
    }

    public boolean isFull(){
        return items == maxSize;
    }
}

public class MainClass {

    static long t1;
    static long t2;
    static long dt;

    public static void main(String[] args) {

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

        //region4.1
        System.out.println("------------------4.1------------------------");
        MyStack myStack = new MyStack(5);

        for(int i = 0; i < 5; i++){
            myStack.push(i);
        }

        System.out.print("Pop: ");
        t1 = System.nanoTime();
        myStack.pop();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to pop: %.2f\n\n", (float) dt);


        System.out.print("Peek: ");
        t1 = System.nanoTime();
        myStack.peek();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to peek: %.2f\n\n", (float) dt);

        System.out.print("Push: ");
        t1 = System.nanoTime();
        myStack.push(5);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to push: %.2f\n\n", (float) dt);

        //endregion
        //region 4.2
        System.out.println("------------------4.2------------------------");

        MyQueue myQueue = new MyQueue(5);

        for(int i = 0; i < 5; i++){
            myQueue.push(i);
        }

        System.out.print("Pop: ");
        t1 = System.nanoTime();
        myQueue.pop();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to pop: %.2f\n\n", (float) dt);


        System.out.print("Peek: ");
        t1 = System.nanoTime();
        myQueue.peek();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to peek: %.2f\n\n", (float) dt);

        System.out.print("Push: ");
        t1 = System.nanoTime();
        myQueue.push(5);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to push: %.2f\n\n", (float) dt);



        //endregion

        //region 4.3
        System.out.println("------------------4.3------------------------");

        Deque<Cat> dqCats = new LinkedList<>();

        t1 = System.nanoTime();
        dqCats.add(cat1);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to add: %.2f\n\n", (float) dt);
        dqCats.add(cat2);

        t1 = System.nanoTime();
        dqCats.offerFirst(cat3);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to offer: %.2f\n\n", (float) dt);
        dqCats.offerLast(cat5);

        t1 = System.nanoTime();
        dqCats.remove();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to remove: %.2f\n\n", (float) dt);

        t1 = System.nanoTime();
        dqCats.removeFirst();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to removeFirst: %.2f\n\n", (float) dt);
        dqCats.removeLast();
        //endregion

        //region 4.4
        System.out.println("------------------4.4------------------------");

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        t1 = System.nanoTime();
        priorityQueue.add(4);
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to add: %.2f\n\n", (float) dt);
        priorityQueue.add(3);
        priorityQueue.add(0);
        priorityQueue.add(2);

        t1 = System.nanoTime();
        priorityQueue.remove();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to remove: %.2f\n\n", (float) dt);

        int a;
        t1 = System.nanoTime();
        a = priorityQueue.peek();
        t2 = System.nanoTime();
        dt = t2 - t1;
        System.out.printf("Time to peek: %.2f\n\n", (float) dt);

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.remove());
        }
        //endregion

        //region 4.5
        System.out.println("------------------4.5------------------------");
        System.out.println("***STACK***");
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

        System.out.println("\n***QUEUE***");
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
    }
}
