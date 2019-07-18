package com.advance.al.dfsTopological;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    private Stack<Vertex> stack;

    public DepthFirstSearch() {
        stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList) {

        for (Vertex v : vertexList) {
            if (!v.getVisited()) {
                v.setVisited(Boolean.TRUE);
                dfsRecursive(v);
            }

        }
    }

    private void dfsRecursive(Vertex v) {
        System.err.println(v + "");
        for (Vertex vertex : v.getNeighbourList()) {
            if (!vertex.getVisited()) {
                vertex.setVisited(Boolean.TRUE);
                dfsRecursive(vertex);
            }
        }
    }

    private void dfsWithStack(Vertex v) {
        stack.add(v);
        v.setVisited(Boolean.TRUE);
        while (!stack.isEmpty()) {
            Vertex actual = stack.pop();
            System.err.println(actual + " ");
            for (Vertex vr : actual.getNeighbourList()) {
                if (!vr.getVisited()) {
                    vr.setVisited(Boolean.TRUE);
                    stack.push(vr);
                }
            }
        }
    }
}
