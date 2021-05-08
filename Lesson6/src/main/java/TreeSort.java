import java.util.Arrays;
import java.util.Random;

/*
        Задание 6.1
        Приведите пример использования древовидной структуры.
        Задание 6.2
        Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
        Задание 6.3
        Реализуйте методы поиска и вставки узла в дерево.
        Задание 6.4
        Реализуйте базовые методы обхода дерева и метода дисплей.
        Реализуйте поиск максимума и минимума.
        Задание 6.5
        Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
        Задание 6.6
        Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
        Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
        Задание 6.7
        Приведите пример сбалансированного дерева и его применения.
*/
class Person {
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}

class Node {
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display() {
        System.out.println("Name: " + person.getName() + " Age: " + person.getAge());
    }

}

class Tree {
    private Node root;

    public void insert(Person person) {
        Node node = new Node();
        node.person = person;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (person.getId() < parent.person.getId()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.person.getId() != key) {
            if (key < current.person.getId()) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void inOrder(Node rootNode) {

        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }


    }

    public void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    public Node min() {
        Node last;
        Node current;

        last = null;
        current = root;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max() {
        Node last;
        Node current;

        last = null;
        current = root;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int id) {
        if (root == null) {
            return false;
        }
        Node current;
        Node parent;
        boolean isLeftChild;

        current = root;
        parent = root;
        isLeftChild = true;

        while (current.person.getId() != id) {
            parent = current;
            if (id < current.person.getId()) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            /*if (current == null) {
                root = current.leftChild;
            } else */
            if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            /*if (current == null) {
                root = current.leftChild;
            } else*/
            if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void display() {
        Node current = root;
        System.out.println("Symmetrical:");
        inOrder(current);
        System.out.println("\rStraight:");
        preOrder(current);
        System.out.println("\rReverse:");
        postOrder(current);
    }
}


public class TreeSort {
    static long t1;
    static long t2;
    static long dt;

    public static void main(String[] args) {
        Tree myTree = new Tree();

        myTree.insert(new Person(5, "Barsik", 2));
        myTree.insert(new Person(7, "Murzik", 6));
        myTree.insert(new Person(2, "Vasiliy", 3));
        myTree.insert(new Person(6, "Mozart", 8));
        myTree.insert(new Person(3, "Masha", 4));
        myTree.insert(new Person(8, "Kuzya", 1));
        myTree.insert(new Person(1, "Boris", 4));

        t1 = System.nanoTime();
        myTree.max().display();
        t2 =System.nanoTime();
        dt = t2 - t1;
        System.out.printf("\nTime to find max: %.2f ns\n", (float) dt);

        t1 = System.nanoTime();
        myTree.min().display();
        t2 =System.nanoTime();
        dt = t2 - t1;
        System.out.printf("\nTime to find min: %.2f ns\n", (float) dt);

        t1 = System.nanoTime();
        myTree.find(2).display();
        t2 =System.nanoTime();
        dt = t2 - t1;
        System.out.printf("\nTime to find element: %.2f ns\n", (float) dt);

        t1 = System.nanoTime();
        myTree.delete(3);
        t2 =System.nanoTime();
        dt = t2 - t1;
        System.out.printf("\nTime to delete element: %.2f ns\n", (float) dt);

        t1 = System.nanoTime();
        myTree.display();
        t2 =System.nanoTime();
        dt = t2 - t1;
        System.out.printf("\nTime to display: %.2f ns\n", (float) dt);
    }
}
