class Stack{
    private int[] stackArr;
    private int size;
    private int top;

    public Stack(int size){
        stackArr = new int[size];
        this.top = -1;
    }

    public void push(int a){
        stackArr[++top] = a;
    }

    public int pop(){
        return stackArr[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int peek(){
        return stackArr[top];
    }
}

class Vertex{
    public char label;
    public boolean wasVisited;

    public Vertex(char label){
        this.label = label;
        this.wasVisited = false;
    }

}

class Graph{
    private final Vertex[] vertexList;
    private final int[][] adjMat;
    private int size;
    private int MAX_VERTS = 32;
    private Stack stack;

    public Graph(){
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i ++){
            for (int j = 0; j < MAX_VERTS; j++){
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }

    public int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++){
            if (adjMat[ver][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1){
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < size; i++){
            vertexList[i].wasVisited = false;
        }
    }
}

public class StackGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.displayVertex(0);
        graph.displayVertex(1);
        graph.displayVertex(2);
        graph.displayVertex(3);
        graph.displayVertex(4);
        graph.displayVertex(5);

        System.out.println("----------");

        graph.dfs();

    }

}
