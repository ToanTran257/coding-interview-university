package Homework.Graph;

import java.io.*;
import java.util.*;

class DFSAdjacencyListIterativeWithStack {

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
      Set<Integer> visited = new HashSet<Integer>();
      Stack<Integer> stack = new Stack<Integer>();

      stack.push(start);

      while (!stack.isEmpty()) {
        int pop = stack.pop();

        if (!visited.contains(pop)) {
          System.out.print(pop + " ");
          visited.add(pop);
        }

        for (int neighbor : adj.getOrDefault(pop, new LinkedList<>())) {
          if (!visited.contains(neighbor)) {
            stack.add(neighbor);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Graph g = new Graph();

    g.addEdge(1, 0);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(0, 3);
    g.addEdge(1, 4);

    System.out.println("Following is the Depth First Traversal");
    g.DFS(0);
  }
}
