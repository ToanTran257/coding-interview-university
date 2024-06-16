package Homework.Graph;

import java.util.*;

class BFSList {

  static class Graph {

    HashMap<Integer, LinkedList<Integer>> adj;

    Graph() {
      adj = new HashMap<Integer, LinkedList<Integer>>();
    }

    void addEdge(int x, int y) {
      if (adj.containsKey(x)) {
        LinkedList<Integer> current = adj.get(x);
        current.add(y);
        return;
      }
      LinkedList<Integer> ll = new LinkedList<Integer>();
      ll.add(y);

      adj.put(x, ll);
    }

    void DFS(int start) {
      System.out.print(start + " ");

      Set<Integer> visited = new HashSet<Integer>();
      Queue<Integer> queue = new LinkedList<Integer>();

      queue.add(start);

      while (!queue.isEmpty()) {
        int poll = queue.poll();

        for (int neighbor : adj.getOrDefault(poll, new LinkedList<>())) {
          if (!visited.contains(neighbor)) {
            queue.add(neighbor);
            System.out.print(neighbor + " ");
            visited.add(poll);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Graph g = new Graph();
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);

    System.out.println("Following is the BFS");
    g.DFS(0);
  }
}
