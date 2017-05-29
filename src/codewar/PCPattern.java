package codewar;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IDEA.
 * User:AndersonKim
 * Date:2017/5/26
 * Time:16:24
 */
public class PCPattern {
    public static void main(String args[]) {
        BlockingQueue sq = new LinkedBlockingDeque<>();

        Thread p = new Thread(new Producer(sq));
        Thread c = new Thread(new Consumer(sq));

        p.start();
        c.start();
    }

    static class Producer implements Runnable {
        private final BlockingQueue sq;

        public Producer(BlockingQueue bq) {
            sq = bq;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("p:" + i);
                try {
                    sq.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue sq;

        public Consumer(BlockingQueue bq) {
            sq = bq;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("c:" + sq.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

