import java.util.LinkedList;
import java.util.Queue;

class Vertex2 {
    public char label;
    public boolean wasVisited;

    public Vertex2(char label) {
        this.label = label;
        this.wasVisited = false;
    }

}

class Graph2 {
    public final Vertex2[] vertexList;
    private final int[][] adjMat;
    private int size;
    private int MAX_VERTS = 32;
    private Stack stack;

    public Graph2() {
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex2[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex2(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    public int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    public void dfs2(int f) {
        vertexList[f].wasVisited = true;
        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(f);
            if (!vertexList[i].wasVisited && v!=-1 && i==v) {
                fullDisplayVertex(f, v);
                dfs2(i);
            }
        }
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }

    }

    public void bfs2(int v) {
        int[] queue = new int[size];
        int qH = 0;
        int qT = 0;

        vertexList[0].wasVisited = true;
        queue[qT++] = 0;

        displayVertex(0);

        int v2;
        while(qH < qT){
            v = queue[qH++];

            for (int i = 0; i < size; i ++){
                v2 = getAdjUnvisitedVertex(v);
                if (!vertexList[i].wasVisited && v2 != -1){
                    vertexList[i].wasVisited = true;
                    displayVertex(qT);
                    queue[qT++] = i;
                }
            }
        }
    }

    public void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println("Vertexes " + vertexList[vertex1].label + " - " + vertexList[vertex2].label);
    }
}


public class RecursiveGraph {
    public static void main(String[] args) {
        Graph2 graph = new Graph2();

        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.displayVertex(0);
        graph.displayVertex(1);
        graph.displayVertex(2);
        graph.displayVertex(3);
        graph.displayVertex(4);
        graph.displayVertex(5);

        System.out.println("----------");

        graph.dfs2(0);
        System.out.println();
        graph.bfs();
        System.out.println();
        graph.bfs2(0);
    }
}
