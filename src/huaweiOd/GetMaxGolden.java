package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//小华最多能得到多少克黄金 good
public class GetMaxGolden {
    List<String> hasContainLists = new ArrayList<>();
    //上
    int[] up = {0,1};
    //下
    int[] down = {0,-1};
    //左
    int[] left ={-1,0};
    //右
    int[] right={1,0};

    List<int[]> lists = new ArrayList<>();
    static int k=0;

    static int row=0;

    static  int column=0;

    int sumMax=0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         row = scanner.nextInt();
         column = scanner.nextInt();
         k = scanner.nextInt();
        GetMaxGolden g = new GetMaxGolden();
        g.getMaxGolden(k);
    }
    public void getMaxGolden(int k){

        lists.add(up);
        lists.add(down);
        lists.add(left);
        lists.add(right);
         dfs(0,0);
        System.out.println(sumMax);

    }

    public void dfs(int x,int y){
        int sum = sumNumToK(x,y);
        String str = x+"-"+y;
        if(x<0||y<0||x>=row||y>=column||sum>k||hasContainLists.contains(str)){
return;
        }
     hasContainLists.add(str);
        sumMax++;
      for(int[] it:lists){
          int x1 = x+it[0];
          int y1 = y+it[1];
          dfs(x1,y1);
      }
    }
    public int sumNumToK(int x,int y){
        int sumx =0;
        int sumy=0;
       while (x>0){
           sumx = sumx+x%10;
           x = x/10;
       }
        while (y>0){
            sumy = sumy+y%10;
           y = y/10;
        }
        return sumx+sumy;
    }
}
