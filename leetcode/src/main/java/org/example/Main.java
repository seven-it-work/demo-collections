package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        String temp="01、Java并发编程 - 认识并发编程 之 线程与多线程\n" +
                "02、Java并发编程 - 基础（临界资源、线程安全、JAVA内存模型、volatile关键字）\n" +
                "03、Java并发编程 - 基础（乐观锁与CAS）\n" +
                "04、Java并发编程 - 基础（悲观锁与synchronized）（偏向锁、轻量级锁、锁优化）\n" +
                "05、Java并发编程 - 基础（本地线程、多线程问题）\n" +
                "06、Java并发编程 - JUC介绍、JUC锁（公平锁、非公平锁、可重入锁/递归锁、自旋锁、ReentrantLock）\n" +
                "07、Java并发编程 - JUC锁（独占共享锁/读写锁、ReentrantReadWriteLock、LockSupport）\n" +
                "08、Java并发编程 - JUC锁（条件队列 Condition、AQS）\n" +
                "09、Java并发编程 - JUC原子操作类（原子基本数据类型、原子数组、原子引用类型、原子更新字段类型）\n" +
                "10、Java并发编程 - JUC并发集合（CopyOnWriteArrayList、CopyOnWriteArraySet）\n" +
                "11、Java并发编程 - JUC并发集合（ConcurrentHashMap、ConcurrentSkipListMap、ConcurrentSkipListSet）\n" +
                "12、Java并发编程 - JUC阻塞队列（概念、生产者消费者模型）\n" +
                "13、Java并发编程 - JUC阻塞队列（BlockingQueue、ArrayBlockingQueue、PriorityBlockingQueue、DelayQueue）\n" +
                "14、Java并发编程 - JUC阻塞队列（LinkedBlockingQueue、LinkedBlockingDeque）\n" +
                "15、Java并发编程 - JUC阻塞队列（SynchronousQueue、LinkedTransferQueue）\n" +
                "16、Java并发编程 - JUC同步器工具（Semaphore、CountDownLatch）\n" +
                "17、Java并发编程 - JUC同步器工具（CyclicBarrier、Exchanger、Phaser）\n" +
                "18、Java并发编程 - JUC线程池（Executor、Callable、FutureTask、ThreadPoolExecutor）\n" +
                "19、Java并发编程 - JUC线程池（自定义线程池ThreadPoolExecutor）\n" +
                "20、Java并发编程 - JUC线程池（ScheduledThreadPoolExecutor）";
        String[] split = temp.split("\n");
        for (int i = 0; i < split.length; i++) {
            String s = split[i]
                    .replace("?","")
                    .replace("？","")
                    .replace("/",",")
                    .replace("Java并发编程 - ","")
                    ;
            File file = new File("temp/"+ s +".md");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("错误："+ s);
                throw new RuntimeException(e);
            }
        }
    }
}