package com.guoliang.dataStructures.queue;


/**
 * 模式环形数组队列
 * front 为队列的头指针  移动为 front = (front+1) % maxSize;
 * rear  为队列的为指针  移动为  rear = (rear+1) % maxSize;
 * 队列已满  (rear + 1) % maxSize == front;
 * 队列是否为空 rear = front
 * 队列的总数 (rear+maxSize-front)%maxSize;
 *
 *
 * @author guoliang
 */
public class CircleArrayQueue {
    /**
     * 队列的最大值
     * 该对的做是最后一个留出 实际的大小容量为maxSize - 1
     */
    private int maxSize;
    /**
     * 队列的头位置
     */
    private int front;
    /**
     * 队列的尾位置
     */
    private int rear;
    /**
     * 队列的底层结构
     */
    public int[] data;
    

    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize+1;
        data = new int[maxSize];
    }

    public void addElement(int element){
        //判断队列是否已满
        if(!isFull()){
            data[rear] = element;
            rear = (rear+1) % maxSize;

        }else{
            throw  new RuntimeException("队列已满");
        }
    }

    public int getElement(){
        if(!isEmpty()){
            //拿出的队列第一个元素
            int value = data[front];
            //移动的第一个元素的位置
            front = (front+1) % maxSize;
            return value;
        }else{
            throw  new RuntimeException("队列为空");
        }
    }

    public void showQueue(){
        if(!isEmpty()){
            for (int i = front; i <front+size(); i++) {
                System.out.printf("arr[%d]=%d",i%maxSize,data[i%maxSize]);
            }

        }else{
            throw  new RuntimeException("队列为空");
        }
    }

    public int headElement(){
        if(!isEmpty()){
            return data[front];

        }else{
            throw  new RuntimeException("队列为空");
        }
    }

    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    /**
     * 判断的队列是否已满  取模用算
     * @return
     */
    private Boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是的为空队列
     * @return
     */
    private Boolean isEmpty(){
        return rear == front;
    }
}
