package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//计算接口成功率 bad
public class FIndInterfaceSucceMax {
    static int[] result;
     static double[][] dp;
    public  static void findInterfaceSucceMax(int limit, int[] times){
        result  = new int[times.length];
        dp = new double[times.length][times.length];
        result[0]=times[0];
        for(int i =1;i<times.length;i++){
           result[i] = result[i-1]+times[i];
        }
        int tmp=0;
        int tmp2 =0;
        boolean flag  =false;
        List<String> lists = new ArrayList<>();
        for(int i=0;i<times.length;i++){
            for (int j =i+1;j<times.length;j++){
                int len = j-i+1;
                dp[i][j] = (result[j]-result[i]);
                if(len*limit>dp[i][j]){
                    flag=true;
                }
                if(len*limit<dp[i][j]&&j-1>i){
                    lists.add(i+"-"+(j-1));
                    tmp= j;
                    break;
                }
                tmp2=j;
                if(times.length-j ==1){
                    lists.add(i+"-"+j);
                    break;
                }
            }
            if(times.length-tmp2!=1) {
                i = tmp - 1;
            }else {
                break;
            }
        }
        System.out.println(lists.stream().collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        String line = scanner.nextLine();
        findInterfaceSucceMax(num, Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).toArray());
    }
}
