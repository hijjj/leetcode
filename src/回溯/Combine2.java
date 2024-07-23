package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine2 {
    LinkedList<Integer> addNums = new LinkedList<>();
    List<List<Integer>> numbersLists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum4(k,n,1);
        return numbersLists;
    }
    public void combinationSum4(int k, int n,int start){
        if (k == addNums.size()) {
            long sum = addNums.stream().mapToInt(Integer::intValue)  // 将Integer转换为int
                    .sum();
            if(sum==n){
                numbersLists.add(new ArrayList<>(addNums));
            }
            return ;
        }
        for (int i = start; i <= 9; i++) {
            addNums.add(i);
            combinationSum4(k, n,i+1);
            addNums.removeLast();
        }
    }
    public static void main(String[] args) {
        Combine2 combine2 = new Combine2();
        combine2.combinationSum3(3, 7);
    }
}
