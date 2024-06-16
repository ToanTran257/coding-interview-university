package Homework.Graph;

import java.io.*;
import java.util.*;

class BFSMatrix {

  static int[][] matrix;

  static void addEdge(int x, int y) {
    matrix[x][y] = 1;
    matrix[y][x] = 1;
  }

  static void bfs(int start) {
    boolean[] visited = new boolean[matrix.length];
    visited[start] = true;

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(start);

    int poll;
    while (!queue.isEmpty()) {
      poll = queue.poll();

      System.out.print(poll + " ");

      for (int i = 0; i < matrix.length; i++) {
        if (matrix[poll][i] == 1 && !visited[i]) {
          queue.add(i);

          visited[i] = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    int v = 5;
    int e = 4;

    matrix = new int[v][v];

    addEdge(0, 1);
    addEdge(0, 2);
    addEdge(1, 3);

    bfs(0);
  }
}
