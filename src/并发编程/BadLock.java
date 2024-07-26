package 并发编程;

import javax.xml.soap.Node;

public class BadLock {
    private Object o = new Object();

    public static synchronized void synchronizedExample(String name) {
        while (true) {
            System.out.println(name + 1);
        }
    }

    public void synchronizedObject(String name) {
        synchronized (o) {
            while (true) {
                System.out.println(name + 2);
            }
        }
    }

    public static void main(String[] args) {
        BadLock badLock = new BadLock();
        BadLock badLock1 = new BadLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                badLock.synchronizedObject("three");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                badLock.synchronizedObject("four");
            }
        });
        thread.start();
        thread2.start();
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                badLock1.synchronizedExample("first");
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                badLock.synchronizedExample("second");
//            }
//        });
//
//        thread.start();
//        thread2.start();


    }
}
