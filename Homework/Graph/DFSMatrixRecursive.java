package Homework.Graph;

import java.io.*;

class DFSMatrixRecursive {

  static int[][] matrix;

  static void addEdge(int x, int y) {
    matrix[x][y] = 1;
    matrix[y][x] = 1;
  }

  static void dfs(int start, boolean[] visited) {
    System.out.print(start + " ");

    visited[start] = true;

    for (int i = 0; i < matrix[start].length; i++) {
      if (matrix[start][i] == 1 && !visited[i]) {
        dfs(i, visited);
      }
    }
  }

  public static void main(String[] args) {
    int v = 5;
    int e = 4;

    matrix = new int[v][v];

    addEdge(0, 1);
    addEdge(0, 2);
    addEdge(0, 3);
    addEdge(0, 4);

    boolean[] visited = new boolean[v];

    dfs(0, visited);
  }
}
