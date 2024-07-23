package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> root = new ArrayList<>();
    LinkedList<Integer> addNums = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {

        for (int i = 1; i <= n; i++) {
            root.add(i);
        }

        combine2(k, root, 0);

        return result;
    }

    public void combine2(int k, List<Integer> root, int start) {
        if (addNums.size() == k) {
            result.add(new ArrayList<>(addNums));
            return;
        }
        for (int i = start; i < root.size(); i++) {
            addNums.add(root.get(i));
            combine2(k, root, i+1);
            addNums.removeLast();
        }

    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4, 2);
    }

}
