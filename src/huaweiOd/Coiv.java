package huaweiOd;

import java.util.HashSet;
import java.util.Scanner;

//核酸检测 chatgpt 生成 good
public class Coiv {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPeople = Integer.parseInt(scanner.nextLine());
        int[] infectedPeople = parseInputToIntArray(scanner.nextLine());
        int[][] contactMatrix = new int[numPeople][numPeople];

        for (int i = 0; i < numPeople; i++) {
            contactMatrix[i] = parseInputToIntArray(scanner.nextLine());
        }
       int result = calculateTestsNeeded(numPeople, infectedPeople, contactMatrix);
        System.out.println(result);
    }

    private static int[] parseInputToIntArray(String input) {
        String[] strings = input.split(",");
        int[] nums = new int[strings.length];
        int i = 0;
        for (String str : strings) {
            nums[i] = Integer.valueOf(str);
            i++;
        }

        return nums;
    }

    public static int calculateTestsNeeded(int numPeople, int[] infectedPeople, int[][] contactMatrix) {
        UnionFind unionFind = new UnionFind(numPeople);

        mergeContactGroups(numPeople, contactMatrix, unionFind);
        int[] groupSizes = computeGroupSizes(numPeople, unionFind);

        return computeTestsRequired(infectedPeople, unionFind, groupSizes);
    }

    private static void mergeContactGroups(int numPeople, int[][] contactMatrix, UnionFind unionFind) {
        int i =0;
        while(i<numPeople) {
            for (int j = i; j < numPeople; j++) {
                if (contactMatrix[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
            i++;
        }
    }

    private static int[] computeGroupSizes(int numPeople, UnionFind unionFind) {
        int[] groupSizes = new int[numPeople];
        int i = 0;
        while (i<numPeople){
            int root = unionFind.find(i);
            groupSizes[root]++;
            i++;
        }
        return groupSizes;
    }

    private static int computeTestsRequired(int[] infectedPeople, UnionFind unionFind, int[] groupSizes) {
        HashSet<Integer> countedGroups = new HashSet<>();
        int totalTests = 0;

        for (int person : infectedPeople) {
            int group = unionFind.find(person);
            if (countedGroups.add(group)) {
                totalTests += groupSizes[group];
            }
        }

        return totalTests - infectedPeople.length;
    }
}

// 并查集实现
class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        int i = 0;
        while (i < size) {
            parent[i] = i;
            i++;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
           return;
        }
        parent[rootY] = rootX;
    }
}
