package com.example.demo.pool;


/**
 * 错误
 */
public class AddTest {
    static Integer i=0;
    public static class AddCount extends Thread{
        @Override
        public void run() {
            /**
             * 这里不是线程安全的
             *在执行i++的时候，每次都会重新new一个新的Integer对象执行++操作
             * 然后赋值给原来的i对象，所以每个线程拿到的i对象不是同一个
             */
            for (int j = 0; j <100000 ; j++) {
                synchronized (i){
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        AddCount addCount = new AddCount();
        AddCount addCount1 = new AddCount();
        addCount.start();
        addCount1.start();
        try {
            addCount1.join();
            addCount.join();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
