/**
 * TODO
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/1/20 15:35
 */
package org.huyong.my.thread;

public class ThreadLocalDemo {
    public static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>(){
        protected Object initialValue() {
            System.out.println("initiaValue");
            return null;
        }
    };


    public static void main(String[] args){
        new Thread(new MyIntegerTask("test1")).start();
        new Thread(new MyIntegerTask("test2")).start();

    }

}

class MyIntegerTask implements Runnable {
    private String name;
    MyIntegerTask(String name) {
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            if(null == ThreadLocalDemo.threadLocal.get()){
                ThreadLocalDemo.threadLocal.set(0);
                System.out.println("thread:" + name + " : 0");
            } else {
                int num = (Integer) ThreadLocalDemo.threadLocal.get();
                System.out.println("thread:" + name + " : " +ThreadLocalDemo.threadLocal.get());
                ThreadLocalDemo.threadLocal.set(num + 1);
                if(i == 3){
                    ThreadLocalDemo.threadLocal.remove();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
