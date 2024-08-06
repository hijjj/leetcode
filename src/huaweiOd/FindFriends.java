    package huaweiOd;

    import java.util.Scanner;
    import java.util.Stack;
//找朋友 good
    public class FindFriends {
        static class Friends{
            int index;
            int height;

            public Friends(int index,int height){
                this.height= height;
                this.index=index;
            }
        }
        public static void findFriends(Friends[] friends){
            int[] result = new int[friends.length];
            Stack<Friends> stack = new Stack<>();
            stack.push(friends[0]);
            for(int i =1;i< friends.length;i++){
                if(stack.peek().height>friends[i].height){
                    stack.add(friends[i]);
                }else {
                    while (!stack.isEmpty()&& friends[i].height>stack.peek().height){
                        result[stack.peek().index]=friends[i].index;
                        stack.pop();
                    }
                }
                stack.add(friends[i]);
            }
            for(int i:result){
                System.out.print(i+" ");
            }
        }

        public static void main(String[] args) {
            Scanner scanner =new Scanner(System.in);
            int num = Integer.valueOf(scanner.nextLine());
            String[] lines = scanner.nextLine().split(" ");
            Friends[] f = new Friends[lines.length];
            for(int i =0;i<num;i++){
                 f[i] = new Friends(i,Integer.valueOf(lines[i]));
            }
            findFriends(f);
        }
    }
