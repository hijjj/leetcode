package huaweiOd;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//绘图机器 good
public class Plotter {
    static class Postion{
        int x;
        int y;
        public Postion(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public void plotter(int target, List<Postion> postionList){
        long sum=0;
        long lastX=0;
        long lastY=0;
        for(int i =0;i<postionList.size();i++){
            int currentX = postionList.get(i).x;
            sum =sum+(currentX-lastX)*Math.abs(lastY);
            lastY =lastY+postionList.get(i).y;
            lastX=currentX;
        }

        if(target>lastX){
            sum =sum+(target-lastX)*Math.abs(lastY);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int num = scanner.nextInt();
        int target  = scanner.nextInt();
        List<Postion> lists = new ArrayList<>();
        for(int i =0;i<num;i++){
         Postion postion = new Postion(scanner.nextInt(),scanner.nextInt());
         lists.add(postion);
        }
        Plotter plotter = new Plotter();
        plotter.plotter(target,lists);
    }
}
