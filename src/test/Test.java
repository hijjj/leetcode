package test;

public class Test {
   Node head;

   public Test(Node node){
       this.head = node;
   }
   static class Node{
        String data;
        String code;
        public Node(){}
    }

    public static void main(String[] args) {
        Test test = new Test(new Test.Node());
        Test test1 = test;
        Test test3 = new Test(new Test.Node());

        System.out.println(test1);
        System.out.println(test);
        System.out.println(test3);
    }
}
