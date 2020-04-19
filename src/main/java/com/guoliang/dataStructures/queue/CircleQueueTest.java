package com.guoliang.dataStructures.queue;

import java.util.Scanner;

/**
 * @author guoliang
 */
public class CircleQueueTest {

    public static void main(String[] args) {
        queueTest();
    }
    public  static  void queueTest() {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");
        // 创建一个环形队列
        CircleArrayQueue queue = new CircleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            // 接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addElement(value);
                    break;
                case 'g':
                    //取出队列元素
                    try {
                        int res = queue.getElement();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    // 查看队列头的数据
                    try {
                        int res = queue.headElement();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {

                    }
                    break;
                case 'e':
                    // 退出
                    scanner.close();

            }
        }
    }

}
