package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListDG {

    private class ENode {
        int ivex;
        ENode nextEdge;
    }

    private class VNode {
        int timecost;
        int in;
        int out;
        ENode firstEdge;

        public VNode(int t, int i, int o, ENode f) {
            this.timecost = t;
            this.in = i;
            this.out = o;
            this.firstEdge = f;
        }
    }

    private  VNode[] mVexs;

    private static final Scanner input=new Scanner(System.in);

    public ListDG() {

        System.out.println("input vertex number:");
        int vlen = input.nextInt();
        System.out.println("input edge numbers:");
        int elen = input.nextInt();
        if (vlen < 1 || elen < 1 || elen > vlen * (vlen - 1)) {
            return;
        }
        mVexs = new VNode[vlen];
        System.out.printf("input %d node timecost", vlen);
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode(input.nextInt(), 0, 0, null);
        }

        System.out.printf("input %d edges", elen);
        for (int i = 0; i < elen; i++) {
            int p1 = getPosition(input.nextInt());
            int p2 = getPosition(input.nextInt());
            mVexs[p1].out++;
            mVexs[p2].in++;
            ENode node2 = new ENode();
            node2.ivex = p2;
            if (mVexs[p1].firstEdge == null) {
                mVexs[p1].firstEdge = node2;
            } else {
                ENode eNode = mVexs[p1].firstEdge;
                while (eNode.nextEdge != null) eNode = eNode.nextEdge;
                eNode.nextEdge = node2;
            }
        }
    }

    public ListDG(int[] vexs, int[][] edges, int[] timecost) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode(timecost[i], 0, 0, null);
        }

        // 初始化"边"
        for (int i = 0; i < elen; i++) {
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mVexs[p1].out++;
            mVexs[p2].in++;
            ENode node2 = new ENode();
            node2.ivex = p2;
            if (mVexs[p1].firstEdge == null) {
                mVexs[p1].firstEdge = node2;
            } else {
                ENode eNode = mVexs[p1].firstEdge;
                while (eNode.nextEdge != null) eNode = eNode.nextEdge;
                eNode.nextEdge = node2;
            }
        }
    }

    private int getPosition(int i) {
        return i - 1;
    }

    private void DFS(int i, boolean[] visited) {
        ENode node;

        visited[i] = true;
        node = mVexs[i].firstEdge;
        while (node != null) {
            if (!visited[node.ivex])
                DFS(node.ivex, visited);
            node = node.nextEdge;
        }
    }

    private void getMaxLink() {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i].in == 0 && mVexs[i].firstEdge != null) {
                DFSLink(i, new ArrayList<>(), result);
            }
        }
        int linkLength = result.size();
        int maxCost = 0;
        for (int i = 0; i < linkLength; i++) {
            int cost = 0;
            for (int j = 0; j < result.get(i).size(); j++) {
                cost += mVexs[result.get(i).get(j)].timecost;
            }
            maxCost = cost > maxCost ? cost : maxCost;
        }
        return;
    }

    private void DFSLink(int i, List<Integer> l, List<List<Integer>> result) {
        List<Integer> link = new ArrayList<>(l);
        ENode node = mVexs[i].firstEdge;
        link.add(i);
        if (node == null)
            result.add(link);
        while (node != null) {
                DFSLink(node.ivex, link, result);
            node = node.nextEdge;
        }

    }

//    public void getLink() {
//        List<ENode> result = new ArrayList<>();
//        for (int i = 0; i < mVexs.length; i++) {
//            if (mVexs[i].in > 0) {
//                ENode node = mVexs[i].firstEdge;
//                result.add(node);
//                while (node != null) {
//
//                    node = mVexs[node.ivex].firstEdge;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] vexs = {1, 2, 3, 4, 5};
        int[] timecost = {3, 2, 10, 5 ,7};
        int[][] edge = {{1, 2}, {1, 3}, {2, 5}, {4, 5}};

        ListDG listDG = new ListDG(vexs, edge, timecost);
        listDG.getMaxLink();
    }

}
