package com.atguigu.java;

/**
 * @Author TYL
 * @Date 2021/4/15 13:37
 * @Version V1.0
 * @ClassName WindowTest4
 * @Description TODO:使用同步方法处理继承Thread类中的线程安全问题
 */
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window4 extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private static synchronized void show(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
            ticket--;
        }
    }
}
