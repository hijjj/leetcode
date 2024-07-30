package ACMModel;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {
    public static void main(String[] args) {
        Comparator<Integer> comparator  =new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        PriorityQueue<Integer> queues = new PriorityQueue(comparator.reversed());
        queues.add(1);
        queues.add(10);
        queues.add(2);
        queues.add(100);
        System.out.println(queues.poll());
        System.out.println(queues.poll());
        System.out.println(queues.poll());
        System.out.println(queues.poll());

    }
}
