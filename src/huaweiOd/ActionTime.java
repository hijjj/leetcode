package huaweiOd;

import java.util.Scanner;
//执行时长
public class ActionTime {
    public void actionTime(int doTask, int[] tasks) {
        int currentTasks = 0;
        int needDOTask = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (currentTasks == 0) {
                needDOTask = tasks[i];
            } else {
                needDOTask = tasks[i] + currentTasks;
            }
            if (doTask >= needDOTask) {
                currentTasks = 0;
                needDOTask=0;
            } else {
                currentTasks = needDOTask - doTask;
                needDOTask=currentTasks;
            }
        }
        int time = tasks.length;
        if (needDOTask != 0) {
            while (needDOTask > 0) {
                needDOTask = needDOTask - doTask;
                time++;
            }
        }
        System.out.println(time);
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int nums = Integer.valueOf(scanner.nextLine());
//        int num2 = Integer.valueOf(scanner.nextLine());
//        String line = scanner.nextLine();
//        String[] num3 = line.split(" ");
//        int[] num4 = new int[num3.length];
//        for(int i =0;i<num3.length;i++){
//            num4[i] = Integer.valueOf(num3[i]);
//        }
        int[] num4={5,4,1,1,1,};
        ActionTime actionTime = new ActionTime();
        actionTime.actionTime(4,num4);
    }
}
